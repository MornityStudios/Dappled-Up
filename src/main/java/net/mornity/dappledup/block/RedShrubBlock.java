package net.mornity.dappledup.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import java.util.List;
import java.util.Optional;

public class RedShrubBlock extends FlowerBlock implements BonemealableBlock {
	public RedShrubBlock() {
		super(MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.GRASS).instabreak().noCollission().replaceable().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

    @Override
    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state) {
        return hasSpreadableNeighbourPos(reader, pos, state);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverlevel, RandomSource source, BlockPos pos, BlockState state) {
        findSpreadableNeighbourPos(serverlevel, pos, state)
            .ifPresent(targetPos -> { serverlevel.setBlockAndUpdate(targetPos, this.defaultBlockState());});
    }


    static Optional<BlockPos> findSpreadableNeighbourPos(Level level, BlockPos pos, BlockState state) {
        return getSpreadableNeighbourPos(Direction.Plane.HORIZONTAL.shuffledCopy(level.random), level, pos, state);
    }
    
    static boolean hasSpreadableNeighbourPos(LevelReader reader, BlockPos pos, BlockState state) {
        return getSpreadableNeighbourPos(Direction.Plane.HORIZONTAL.stream().toList(), reader, pos, state).isPresent();
    }

    private static Optional<BlockPos> getSpreadableNeighbourPos(List<Direction> list, LevelReader reader, BlockPos pos, BlockState state) {
        for (Direction direction : list) {
            BlockPos blockpos = pos.relative(direction);
            if (reader.isEmptyBlock(blockpos) && state.canSurvive(reader, blockpos)) {
                return Optional.of(blockpos);
            }
        }

        return Optional.empty();
    }
}