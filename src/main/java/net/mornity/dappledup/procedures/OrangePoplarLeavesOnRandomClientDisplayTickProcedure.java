package net.mornity.dappledup.procedures;

import net.mornity.dappledup.init.DappledUpModParticleTypes;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

public class OrangePoplarLeavesOnRandomClientDisplayTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("dappled_up:leaf_bush")))) {
			if (Math.random() < 0.01) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (DappledUpModParticleTypes.ORANGE_POPLAR_LEAF_PARTICLE.get()), (x + Mth.nextDouble(RandomSource.create(), 0, 1)), y, (z + Mth.nextDouble(RandomSource.create(), 0, 1)), 1, 0, 0, 0, 0);
			}
		}
	}
}