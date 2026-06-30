/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.mornity.dappledup.DappledUpMod;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.*;

public class DappledUpModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(DappledUpMod.MODID);
	public static final DeferredItem<Item> POPLAR_LOG;
	public static final DeferredItem<Item> RED_POPLAR_LEAVES;
	public static final DeferredItem<Item> YELLOW_POPLAR_LEAVES;
	public static final DeferredItem<Item> ORANGE_POPLAR_LEAVES;
	public static final DeferredItem<Item> RED_POPLAR_LEAF_BUSH;
	public static final DeferredItem<Item> YELLOW_POPLAR_LEAF_BUSH;
	public static final DeferredItem<Item> ORANGE_POPLAR_LEAF_BUSH;
	public static final DeferredItem<Item> RED_POPLAR_LEAF_LITTER;
	public static final DeferredItem<Item> YELLOW_POPLAR_LEAF_LITTER;
	public static final DeferredItem<Item> ORANGE_POPLAR_LEAF_LITTER;
	public static final DeferredItem<Item> RED_SHRUB;
	public static final DeferredItem<Item> SHELF_MUSHROOM;
	public static final DeferredItem<Item> RED_MOSS_BLOCK;
	public static final DeferredItem<Item> RED_MOSS_CARPET;
	public static final DeferredItem<Item> POPLAR_WOOD;
	public static final DeferredItem<Item> STRIPPED_POPLAR_LOG;
	public static final DeferredItem<Item> STRIPPED_POPLAR_WOOD;
	public static final DeferredItem<Item> POPLAR_PLANKS;
	public static final DeferredItem<Item> POPLAR_STAIRS;
	public static final DeferredItem<Item> POPLAR_SLAB;
	public static final DeferredItem<Item> POPLAR_FENCE;
	public static final DeferredItem<Item> POPLAR_FENCE_GATE;
	public static final DeferredItem<Item> POPLAR_DOOR;
	public static final DeferredItem<Item> POPLAR_TRAPDOOR;
	public static final DeferredItem<Item> POPLAR_PRESSURE_PLATE;
	public static final DeferredItem<Item> POPLAR_BUTTON;
	public static final DeferredItem<Item> POPLAR_SIGN;
	public static final DeferredItem<Item> POPLAR_HANGING_SIGN;
	public static final DeferredItem<Item> POPLAR_BOAT;
	public static final DeferredItem<Item> POPLAR_BOAT_WITH_CHEST;
	public static final DeferredItem<Item> RED_POPLAR_SAPLING;
	public static final DeferredItem<Item> YELLOW_POPLAR_SAPLING;
	public static final DeferredItem<Item> ORANGE_POPLAR_SAPLING;
	static {
		POPLAR_LOG = block(DappledUpModBlocks.POPLAR_LOG);
		RED_POPLAR_LEAVES = block(DappledUpModBlocks.RED_POPLAR_LEAVES);
		YELLOW_POPLAR_LEAVES = block(DappledUpModBlocks.YELLOW_POPLAR_LEAVES);
		ORANGE_POPLAR_LEAVES = block(DappledUpModBlocks.ORANGE_POPLAR_LEAVES);
		RED_POPLAR_LEAF_BUSH = block(DappledUpModBlocks.RED_POPLAR_LEAF_BUSH);
		YELLOW_POPLAR_LEAF_BUSH = block(DappledUpModBlocks.YELLOW_POPLAR_LEAF_BUSH);
		ORANGE_POPLAR_LEAF_BUSH = block(DappledUpModBlocks.ORANGE_POPLAR_LEAF_BUSH);
		RED_POPLAR_LEAF_LITTER = block(DappledUpModBlocks.RED_POPLAR_LEAF_LITTER);
		YELLOW_POPLAR_LEAF_LITTER = block(DappledUpModBlocks.YELLOW_POPLAR_LEAF_LITTER);
		ORANGE_POPLAR_LEAF_LITTER = block(DappledUpModBlocks.ORANGE_POPLAR_LEAF_LITTER);
		RED_SHRUB = block(DappledUpModBlocks.RED_SHRUB);
		SHELF_MUSHROOM = block(DappledUpModBlocks.SHELF_MUSHROOM);
		RED_MOSS_BLOCK = block(DappledUpModBlocks.RED_MOSS_BLOCK);
		RED_MOSS_CARPET = block(DappledUpModBlocks.RED_MOSS_CARPET);
		POPLAR_WOOD = block(DappledUpModBlocks.POPLAR_WOOD);
		STRIPPED_POPLAR_LOG = block(DappledUpModBlocks.STRIPPED_POPLAR_LOG);
		STRIPPED_POPLAR_WOOD = block(DappledUpModBlocks.STRIPPED_POPLAR_WOOD);
		POPLAR_PLANKS = block(DappledUpModBlocks.POPLAR_PLANKS);
		POPLAR_STAIRS = block(DappledUpModBlocks.POPLAR_STAIRS);
		POPLAR_SLAB = block(DappledUpModBlocks.POPLAR_SLAB);
		POPLAR_FENCE = block(DappledUpModBlocks.POPLAR_FENCE);
		POPLAR_FENCE_GATE = block(DappledUpModBlocks.POPLAR_FENCE_GATE);
		POPLAR_DOOR = doubleBlock(DappledUpModBlocks.POPLAR_DOOR);
		POPLAR_TRAPDOOR = block(DappledUpModBlocks.POPLAR_TRAPDOOR);
		POPLAR_PRESSURE_PLATE = block(DappledUpModBlocks.POPLAR_PRESSURE_PLATE);
		POPLAR_BUTTON = block(DappledUpModBlocks.POPLAR_BUTTON);
		POPLAR_SIGN = signBlock(DappledUpModBlocks.POPLAR_SIGN, DappledUpModBlocks.POPLAR_WALL_SIGN, new Item.Properties().stacksTo(16));
		POPLAR_HANGING_SIGN = hangingSignBlock(DappledUpModBlocks.POPLAR_HANGING_SIGN, DappledUpModBlocks.POPLAR_WALL_HANGING_SIGN, new Item.Properties().stacksTo(16));
		POPLAR_BOAT = REGISTRY.register("poplar_boat", () -> new BoatItem(false, DappledUpModBoatTypes.POPLAR_BOAT_TYPE.getValue(), new Item.Properties().stacksTo(1)));
		POPLAR_BOAT_WITH_CHEST = REGISTRY.register("poplar_boat_with_chest", () -> new BoatItem(true, DappledUpModBoatTypes.POPLAR_BOAT_WITH_CHEST_TYPE.getValue(), new Item.Properties().stacksTo(1)));
		RED_POPLAR_SAPLING = block(DappledUpModBlocks.RED_POPLAR_SAPLING);
		YELLOW_POPLAR_SAPLING = block(DappledUpModBlocks.YELLOW_POPLAR_SAPLING);
		ORANGE_POPLAR_SAPLING = block(DappledUpModBlocks.ORANGE_POPLAR_SAPLING);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return doubleBlock(block, new Item.Properties());
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new DoubleHighBlockItem(block.get(), properties));
	}

	private static DeferredItem<Item> signBlock(DeferredHolder<Block, Block> block, DeferredHolder<Block, Block> wallBlock) {
		return signBlock(block, wallBlock, new Item.Properties());
	}

	private static DeferredItem<Item> signBlock(DeferredHolder<Block, Block> block, DeferredHolder<Block, Block> wallBlock, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new SignItem(properties, block.get(), wallBlock.get()));
	}

	private static DeferredItem<Item> hangingSignBlock(DeferredHolder<Block, Block> block, DeferredHolder<Block, Block> wallBlock) {
		return hangingSignBlock(block, wallBlock, new Item.Properties());
	}

	private static DeferredItem<Item> hangingSignBlock(DeferredHolder<Block, Block> block, DeferredHolder<Block, Block> wallBlock, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new HangingSignItem(block.get(), wallBlock.get(), properties));
	}
}