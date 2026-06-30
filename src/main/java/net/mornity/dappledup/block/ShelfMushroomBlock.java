package net.mornity.dappledup.block;

import net.mornity.dappledup.procedures.ShelfMushroomBlockValidPlacementConditionProcedure;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class ShelfMushroomBlock extends Block implements SimpleWaterloggedBlock, BonemealableBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
	public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, 1);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public ShelfMushroomBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).instabreak().jumpFactor(1.3f).noOcclusion().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(STAGE, 0).setValue(WATERLOGGED, false));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(STAGE) == 1) {
				return switch (state.getValue(FACING)) {
					default -> Shapes.or(box(1, 8, 0, 15, 11, 10), box(4, 6, 0, 12, 8, 6));
					case NORTH -> Shapes.or(box(1, 8, 6, 15, 11, 16), box(4, 6, 10, 12, 8, 16));
					case EAST -> Shapes.or(box(0, 8, 1, 10, 11, 15), box(0, 6, 4, 6, 8, 12));
					case WEST -> Shapes.or(box(6, 8, 1, 16, 11, 15), box(10, 6, 4, 16, 8, 12));
				};
			}
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(3, 8, 0, 13, 10, 7), box(5, 7, 0, 11, 8, 4));
				case NORTH -> Shapes.or(box(3, 8, 9, 13, 10, 16), box(5, 7, 12, 11, 8, 16));
				case EAST -> Shapes.or(box(0, 8, 3, 7, 10, 13), box(0, 7, 5, 4, 8, 11));
				case WEST -> Shapes.or(box(9, 8, 3, 16, 10, 13), box(12, 7, 5, 16, 8, 11));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return propagatesSkylightDown(state, worldIn, pos) ? 0 : 1;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, STAGE, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(STAGE, 0).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		if (worldIn instanceof LevelAccessor world) {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return ShelfMushroomBlockValidPlacementConditionProcedure.execute(world, x, y, z, blockstate);
		}
		return super.canSurvive(blockstate, worldIn, pos);
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public boolean isValidBonemealTarget(LevelReader worldIn, BlockPos pos, BlockState blockstate) {
		return blockstate.getValue(STAGE) == 0;
	}

	@Override
	public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState blockstate) {
		return true;
	}

	@Override
	public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState blockstate) {
		world.setBlock(pos, blockstate.setValue(STAGE, 1), 3);
	}
}