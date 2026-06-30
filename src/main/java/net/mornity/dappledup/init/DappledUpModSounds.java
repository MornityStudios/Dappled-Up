/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mornity.dappledup.DappledUpMod;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class DappledUpModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, DappledUpMod.MODID);
	public static final DeferredHolder<SoundEvent, SoundEvent> POPLAR_AMBIENT = REGISTRY.register("poplar_ambient", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("dappled_up", "poplar_ambient")));
	public static final DeferredHolder<SoundEvent, SoundEvent> POPLAR_WIND = REGISTRY.register("poplar_wind", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("dappled_up", "poplar_wind")));
}