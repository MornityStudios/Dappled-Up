package net.mornity.dappledup.world.biome;

import com.terraformersmc.biolith.api.biome.BiomePlacement;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.mornity.dappledup.DappledUpMod;

public final class DappledUpBiomeRegistry {
    public static final ResourceKey<Biome> DAPPLED_FOREST = ResourceKey.create(
            Registries.BIOME, ResourceLocation.fromNamespaceAndPath(DappledUpMod.MODID, "dappled_forest"));

    private static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(-0.45F, -0.15F);
    private static final Climate.Parameter HUMIDITY = Climate.Parameter.span(-1.0F, -0.35F);
    private static final Climate.Parameter CONTINENTALNESS = Climate.Parameter.span(-0.19F, 1.0F);
    private static final Climate.Parameter EROSION = Climate.Parameter.span(-1.0F, 1.0F);
    private static final Climate.Parameter WEIRDNESS = Climate.Parameter.span(0.05F, 1.0F);

    public static void register() {
        registerBiomePlacement();
        DappledForestSurfaceBuilder.register();
    }

    private static void registerBiomePlacement() {
        BiomePlacement.addOverworld(DAPPLED_FOREST, new Climate.ParameterPoint(
                TEMPERATURE, HUMIDITY, CONTINENTALNESS, EROSION, Climate.Parameter.point(0.0F), WEIRDNESS, 0L));
        BiomePlacement.addOverworld(DAPPLED_FOREST, new Climate.ParameterPoint(
                TEMPERATURE, HUMIDITY, CONTINENTALNESS, EROSION, Climate.Parameter.point(1.0F), WEIRDNESS, 0L));
    }

    private DappledUpBiomeRegistry() {
    }
}