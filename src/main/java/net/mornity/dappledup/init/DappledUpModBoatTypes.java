/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.fml.common.asm.enumextension.EnumProxy;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.vehicle.Boat;

import java.util.function.Supplier;

public class DappledUpModBoatTypes {
	public static final EnumProxy<Boat.Type> POPLAR_BOAT_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "dappled_up:poplar_boat", DappledUpModItems.POPLAR_BOAT, (Supplier<Item>) () -> Items.AIR,
			(Supplier<Item>) () -> Items.STICK, false);
	public static final EnumProxy<Boat.Type> POPLAR_BOAT_WITH_CHEST_TYPE = new EnumProxy<>(Boat.Type.class, (Supplier<Block>) () -> Blocks.OAK_PLANKS, "dappled_up:poplar_boat_with_chest", (Supplier<Item>) () -> Items.AIR,
			DappledUpModItems.POPLAR_BOAT_WITH_CHEST, (Supplier<Item>) () -> Items.STICK, false);
}