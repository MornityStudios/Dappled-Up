package net.mornity.dappledup.block;

import net.neoforged.neoforge.common.util.TriState;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class RedMossBlockBlock extends Block implements BonemealableBlock {
	public RedMossBlockBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.MOSS).strength(0.1f));
	}

	@Override
	public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, BlockState plant) {
		return TriState.TRUE;
	}

    @Override
    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state) {
        return reader.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel serverlevel, RandomSource source, BlockPos pos, BlockState state) {
        serverlevel.registryAccess()
            .registry(Registries.CONFIGURED_FEATURE)
            .flatMap(falthing -> falthing.getHolder(ResourceLocation.parse("dappled_up:red_moss_bone_meal")))
            .ifPresent(targetPos -> targetPos.value().place(serverlevel, serverlevel.getChunkSource().getGenerator(), source, pos.above()));
    }

    @Override
    public BonemealableBlock.Type getType() {
        return BonemealableBlock.Type.NEIGHBOR_SPREADER;
    }
}