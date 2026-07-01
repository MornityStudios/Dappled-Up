package net.mornity.dappledup.world.biome;

import com.terraformersmc.biolith.api.surface.BiolithSurfaceBuilder;
import com.terraformersmc.biolith.api.surface.SurfaceGeneration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeManager;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.BlockColumn;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Heightmap;
import net.mornity.dappledup.DappledUpMod;

public final class DappledForestSurfaceBuilder extends BiolithSurfaceBuilder {
    private static final BlockState GROUND = Blocks.GRASS_BLOCK.defaultBlockState();
    private static final BlockState UNDERGROUND = Blocks.DIRT.defaultBlockState();
    private static final BlockState UNDERWATER = Blocks.GRAVEL.defaultBlockState();

    public static void register() {
        SurfaceGeneration.addSurfaceBuilder(
                ResourceLocation.fromNamespaceAndPath(DappledUpMod.MODID, "dappled_forest"),
                new DappledForestSurfaceBuilder().setBiomeKey(DappledUpBiomeRegistry.DAPPLED_FOREST));
    }

    @Override
    public void generate(BiomeManager biomeManager, BlockColumn column, RandomSource random, ChunkAccess chunk,
                          Biome biome, int x, int z, int vHeight, int seaLevel) {
        int localX = x & 15;
        int localZ = z & 15;
        int topY = chunk.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, localX, localZ);

        boolean nearWater = column.getBlock(topY + 1).getFluidState().is(FluidTags.WATER)
                || column.getBlock(topY).getFluidState().is(FluidTags.WATER);

        column.setBlock(topY, nearWater ? UNDERWATER : GROUND);
        if (topY - 1 >= 0) {
            column.setBlock(topY - 1, UNDERGROUND);
        }
    }
}