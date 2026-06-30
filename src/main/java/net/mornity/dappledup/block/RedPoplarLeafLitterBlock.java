package net.mornity.dappledup.block;

import net.mornity.dappledup.procedures.RedPoplarLeafLitterBlockValidPlacementConditionProcedure;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.google.common.collect.ImmutableMap;

public class RedPoplarLeafLitterBlock extends Block {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty AMOUNT = IntegerProperty.create("amount", 1, 4);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public RedPoplarLeafLitterBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.PINK_PETALS).instabreak().noCollission().pushReaction(PushReaction.DESTROY).isRedstoneConductor((bs, br, bp) -> false).replaceable());
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AMOUNT, 1));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			if (state.getValue(AMOUNT) == 2) {
				return switch (state.getValue(FACING)) {
					default -> Shapes.or(box(0, 0, 0, 8, 1, 8), box(8, 0, 0, 16, 2, 8));
					case NORTH -> Shapes.or(box(8, 0, 8, 16, 1, 16), box(0, 0, 8, 8, 2, 16));
					case EAST -> Shapes.or(box(0, 0, 8, 8, 1, 16), box(0, 0, 0, 8, 2, 8));
					case WEST -> Shapes.or(box(8, 0, 0, 16, 1, 8), box(8, 0, 8, 16, 2, 16));
				};
			} else if (state.getValue(AMOUNT) == 3) {
				return switch (state.getValue(FACING)) {
					default -> Shapes.or(box(0, 0, 0, 8, 1, 8), box(8, 0, 0, 16, 2, 8), box(0, 0, 8, 8, 3, 16));
					case NORTH -> Shapes.or(box(8, 0, 8, 16, 1, 16), box(0, 0, 8, 8, 2, 16), box(8, 0, 0, 16, 3, 8));
					case EAST -> Shapes.or(box(0, 0, 8, 8, 1, 16), box(0, 0, 0, 8, 2, 8), box(8, 0, 8, 16, 3, 16));
					case WEST -> Shapes.or(box(8, 0, 0, 16, 1, 8), box(8, 0, 8, 16, 2, 16), box(0, 0, 0, 8, 3, 8));
				};
			} else if (state.getValue(AMOUNT) == 4) {
				return switch (state.getValue(FACING)) {
					default -> Shapes.or(box(0, 0, 0, 8, 1, 8), box(8, 0, 0, 16, 2, 8), box(0, 0, 8, 8, 3, 16), box(8, 0, 8, 16, 1, 16));
					case NORTH -> Shapes.or(box(8, 0, 8, 16, 1, 16), box(0, 0, 8, 8, 2, 16), box(8, 0, 0, 16, 3, 8), box(0, 0, 0, 8, 1, 8));
					case EAST -> Shapes.or(box(0, 0, 8, 8, 1, 16), box(0, 0, 0, 8, 2, 8), box(8, 0, 8, 16, 3, 16), box(8, 0, 0, 16, 1, 8));
					case WEST -> Shapes.or(box(8, 0, 0, 16, 1, 8), box(8, 0, 8, 16, 2, 16), box(0, 0, 0, 8, 3, 8), box(0, 0, 8, 8, 1, 16));
				};
			}
			return switch (state.getValue(FACING)) {
				default -> box(0, 0, 0, 8, 1, 8);
				case NORTH -> box(8, 0, 8, 16, 1, 16);
				case EAST -> box(0, 0, 8, 8, 1, 16);
				case WEST -> box(8, 0, 0, 16, 1, 8);
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, AMOUNT);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState blockstate = context.getLevel().getBlockState(context.getClickedPos());
        if (blockstate.is(this)) {
            return blockstate.setValue(AMOUNT, Integer.valueOf(Math.min(4, blockstate.getValue(AMOUNT) + 1)));
        } else {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(AMOUNT, 1);

        }
	}

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return !context.isSecondaryUseActive() && context.getItemInHand().is(this.asItem()) && state.getValue(AMOUNT) < 4
            ? true
            : super.canBeReplaced(state, context);
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
			return RedPoplarLeafLitterBlockValidPlacementConditionProcedure.execute(world, x, y, z);
		}
		return super.canSurvive(blockstate, worldIn, pos);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		return !state.canSurvive(world, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}
}