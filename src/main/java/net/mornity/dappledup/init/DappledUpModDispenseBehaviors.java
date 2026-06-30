/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;

@EventBusSubscriber
public class DappledUpModDispenseBehaviors {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			DispenserBlock.registerBehavior(DappledUpModItems.POPLAR_BOAT.get(), new BoatDispenseItemBehavior(DappledUpModBoatTypes.POPLAR_BOAT_TYPE.getValue()));
			DispenserBlock.registerBehavior(DappledUpModItems.POPLAR_BOAT_WITH_CHEST.get(), new BoatDispenseItemBehavior(DappledUpModBoatTypes.POPLAR_BOAT_WITH_CHEST_TYPE.getValue(), true));
		});
	}
}