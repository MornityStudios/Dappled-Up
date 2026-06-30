/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mornity.dappledup.DappledUpMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class DappledUpModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, DappledUpMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> RED_POPLAR_LEAF_PARTICLE = REGISTRY.register("red_poplar_leaf_particle", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> YELLOW_POPLAR_LEAF_PARTICLE = REGISTRY.register("yellow_poplar_leaf_particle", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ORANGE_POPLAR_LEAF_PARTICLE = REGISTRY.register("orange_poplar_leaf_particle", () -> new SimpleParticleType(false));
}