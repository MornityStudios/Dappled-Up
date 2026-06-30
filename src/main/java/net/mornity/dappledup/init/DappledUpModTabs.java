/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mornity.dappledup.DappledUpMod;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

public class DappledUpModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DappledUpMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> DAPPLED_UP_TAB = REGISTRY.register("dappled_up_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.dappled_up.dappled_up_tab")).icon(() -> new ItemStack(DappledUpModBlocks.POPLAR_LOG.get())).displayItems((parameters, tabData) -> {
				tabData.accept(DappledUpModBlocks.POPLAR_LOG.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_WOOD.get().asItem());
				tabData.accept(DappledUpModBlocks.STRIPPED_POPLAR_LOG.get().asItem());
				tabData.accept(DappledUpModBlocks.STRIPPED_POPLAR_WOOD.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_PLANKS.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_STAIRS.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_SLAB.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_FENCE.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_FENCE_GATE.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_DOOR.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_TRAPDOOR.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_PRESSURE_PLATE.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_BUTTON.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_SIGN.get().asItem());
				tabData.accept(DappledUpModBlocks.POPLAR_HANGING_SIGN.get().asItem());
				tabData.accept(DappledUpModItems.POPLAR_BOAT.get());
				tabData.accept(DappledUpModItems.POPLAR_BOAT_WITH_CHEST.get());
				tabData.accept(DappledUpModBlocks.RED_POPLAR_LEAVES.get().asItem());
				tabData.accept(DappledUpModBlocks.YELLOW_POPLAR_LEAVES.get().asItem());
				tabData.accept(DappledUpModBlocks.ORANGE_POPLAR_LEAVES.get().asItem());
				tabData.accept(DappledUpModBlocks.RED_POPLAR_SAPLING.get().asItem());
				tabData.accept(DappledUpModBlocks.YELLOW_POPLAR_SAPLING.get().asItem());
				tabData.accept(DappledUpModBlocks.ORANGE_POPLAR_SAPLING.get().asItem());
				tabData.accept(DappledUpModBlocks.RED_POPLAR_LEAF_BUSH.get().asItem());
				tabData.accept(DappledUpModBlocks.YELLOW_POPLAR_LEAF_BUSH.get().asItem());
				tabData.accept(DappledUpModBlocks.ORANGE_POPLAR_LEAF_BUSH.get().asItem());
				tabData.accept(DappledUpModBlocks.RED_POPLAR_LEAF_LITTER.get().asItem());
				tabData.accept(DappledUpModBlocks.YELLOW_POPLAR_LEAF_LITTER.get().asItem());
				tabData.accept(DappledUpModBlocks.ORANGE_POPLAR_LEAF_LITTER.get().asItem());
				tabData.accept(DappledUpModBlocks.RED_SHRUB.get().asItem());
				tabData.accept(DappledUpModBlocks.SHELF_MUSHROOM.get().asItem());
				tabData.accept(DappledUpModBlocks.RED_MOSS_BLOCK.get().asItem());
				tabData.accept(DappledUpModBlocks.RED_MOSS_CARPET.get().asItem());
			}).build());
}