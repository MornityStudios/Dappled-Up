/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mornity.dappledup.block.*;
import net.mornity.dappledup.DappledUpMod;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.client.renderer.Sheets;

@EventBusSubscriber
public class DappledUpModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(DappledUpMod.MODID);
	public static final DeferredBlock<Block> POPLAR_LOG;
	public static final DeferredBlock<Block> RED_POPLAR_LEAVES;
	public static final DeferredBlock<Block> YELLOW_POPLAR_LEAVES;
	public static final DeferredBlock<Block> ORANGE_POPLAR_LEAVES;
	public static final DeferredBlock<Block> RED_POPLAR_LEAF_BUSH;
	public static final DeferredBlock<Block> YELLOW_POPLAR_LEAF_BUSH;
	public static final DeferredBlock<Block> ORANGE_POPLAR_LEAF_BUSH;
	public static final DeferredBlock<Block> RED_POPLAR_LEAF_LITTER;
	public static final DeferredBlock<Block> YELLOW_POPLAR_LEAF_LITTER;
	public static final DeferredBlock<Block> ORANGE_POPLAR_LEAF_LITTER;
	public static final DeferredBlock<Block> RED_SHRUB;
	public static final DeferredBlock<Block> SHELF_MUSHROOM;
	public static final DeferredBlock<Block> RED_MOSS_BLOCK;
	public static final DeferredBlock<Block> RED_MOSS_CARPET;
	public static final DeferredBlock<Block> POPLAR_WOOD;
	public static final DeferredBlock<Block> STRIPPED_POPLAR_LOG;
	public static final DeferredBlock<Block> STRIPPED_POPLAR_WOOD;
	public static final DeferredBlock<Block> POPLAR_PLANKS;
	public static final DeferredBlock<Block> POPLAR_STAIRS;
	public static final DeferredBlock<Block> POPLAR_SLAB;
	public static final DeferredBlock<Block> POPLAR_FENCE;
	public static final DeferredBlock<Block> POPLAR_FENCE_GATE;
	public static final DeferredBlock<Block> POPLAR_DOOR;
	public static final DeferredBlock<Block> POPLAR_TRAPDOOR;
	public static final DeferredBlock<Block> POPLAR_PRESSURE_PLATE;
	public static final DeferredBlock<Block> POPLAR_BUTTON;
	public static final DeferredBlock<Block> POPLAR_SIGN;
	public static final DeferredBlock<Block> POPLAR_WALL_SIGN;
	public static final DeferredBlock<Block> POPLAR_HANGING_SIGN;
	public static final DeferredBlock<Block> POPLAR_WALL_HANGING_SIGN;
	public static final DeferredBlock<Block> RED_POPLAR_SAPLING;
	public static final DeferredBlock<Block> YELLOW_POPLAR_SAPLING;
	public static final DeferredBlock<Block> ORANGE_POPLAR_SAPLING;
	static {
		POPLAR_LOG = REGISTRY.register("poplar_log", PoplarLogBlock::new);
		RED_POPLAR_LEAVES = REGISTRY.register("red_poplar_leaves", RedPoplarLeavesBlock::new);
		YELLOW_POPLAR_LEAVES = REGISTRY.register("yellow_poplar_leaves", YellowPoplarLeavesBlock::new);
		ORANGE_POPLAR_LEAVES = REGISTRY.register("orange_poplar_leaves", OrangePoplarLeavesBlock::new);
		RED_POPLAR_LEAF_BUSH = REGISTRY.register("red_poplar_leaf_bush", RedPoplarLeafBushBlock::new);
		YELLOW_POPLAR_LEAF_BUSH = REGISTRY.register("yellow_poplar_leaf_bush", YellowPoplarLeafBushBlock::new);
		ORANGE_POPLAR_LEAF_BUSH = REGISTRY.register("orange_poplar_leaf_bush", OrangePoplarLeafBushBlock::new);
		RED_POPLAR_LEAF_LITTER = REGISTRY.register("red_poplar_leaf_litter", RedPoplarLeafLitterBlock::new);
		YELLOW_POPLAR_LEAF_LITTER = REGISTRY.register("yellow_poplar_leaf_litter", YellowPoplarLeafLitterBlock::new);
		ORANGE_POPLAR_LEAF_LITTER = REGISTRY.register("orange_poplar_leaf_litter", OrangePoplarLeafLitterBlock::new);
		RED_SHRUB = REGISTRY.register("red_shrub", RedShrubBlock::new);
		SHELF_MUSHROOM = REGISTRY.register("shelf_mushroom", ShelfMushroomBlock::new);
		RED_MOSS_BLOCK = REGISTRY.register("red_moss_block", RedMossBlockBlock::new);
		RED_MOSS_CARPET = REGISTRY.register("red_moss_carpet", RedMossCarpetBlock::new);
		POPLAR_WOOD = REGISTRY.register("poplar_wood", PoplarWoodBlock::new);
		STRIPPED_POPLAR_LOG = REGISTRY.register("stripped_poplar_log", StrippedPoplarLogBlock::new);
		STRIPPED_POPLAR_WOOD = REGISTRY.register("stripped_poplar_wood", StrippedPoplarWoodBlock::new);
		POPLAR_PLANKS = REGISTRY.register("poplar_planks", PoplarPlanksBlock::new);
		POPLAR_STAIRS = REGISTRY.register("poplar_stairs", PoplarStairsBlock::new);
		POPLAR_SLAB = REGISTRY.register("poplar_slab", PoplarSlabBlock::new);
		POPLAR_FENCE = REGISTRY.register("poplar_fence", PoplarFenceBlock::new);
		POPLAR_FENCE_GATE = REGISTRY.register("poplar_fence_gate", PoplarFenceGateBlock::new);
		POPLAR_DOOR = REGISTRY.register("poplar_door", PoplarDoorBlock::new);
		POPLAR_TRAPDOOR = REGISTRY.register("poplar_trapdoor", PoplarTrapdoorBlock::new);
		POPLAR_PRESSURE_PLATE = REGISTRY.register("poplar_pressure_plate", PoplarPressurePlateBlock::new);
		POPLAR_BUTTON = REGISTRY.register("poplar_button", PoplarButtonBlock::new);
		POPLAR_SIGN = REGISTRY.register("poplar_sign", PoplarSignBlock::new);
		POPLAR_WALL_SIGN = REGISTRY.register("poplar_wall_sign", PoplarWallSignBlock::new);
		POPLAR_HANGING_SIGN = REGISTRY.register("poplar_hanging_sign", PoplarHangingSignBlock::new);
		POPLAR_WALL_HANGING_SIGN = REGISTRY.register("poplar_wall_hanging_sign", PoplarWallHangingSignBlock::new);
		RED_POPLAR_SAPLING = REGISTRY.register("red_poplar_sapling", RedPoplarSaplingBlock::new);
		YELLOW_POPLAR_SAPLING = REGISTRY.register("yellow_poplar_sapling", YellowPoplarSaplingBlock::new);
		ORANGE_POPLAR_SAPLING = REGISTRY.register("orange_poplar_sapling", OrangePoplarSaplingBlock::new);
	}

	// Start of user code block custom blocks
	// End of user code block custom blocks
	@EventBusSubscriber(Dist.CLIENT)
	public static class BlocksClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			Sheets.addWoodType(DappledUpModWoodTypes.POPLAR_SIGN_WOOD_TYPE);
			Sheets.addWoodType(DappledUpModWoodTypes.POPLAR_HANGING_SIGN_WOOD_TYPE);
		}
	}

	@SubscribeEvent
	public static void registerSigns(BlockEntityTypeAddBlocksEvent event) {
		event.modify(BlockEntityType.SIGN, POPLAR_SIGN.get(), POPLAR_WALL_SIGN.get());
		event.modify(BlockEntityType.HANGING_SIGN, POPLAR_HANGING_SIGN.get(), POPLAR_WALL_HANGING_SIGN.get());
	}
}