/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mornity.dappledup.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mornity.dappledup.client.particle.YellowPoplarLeafParticleParticle;
import net.mornity.dappledup.client.particle.RedPoplarLeafParticleParticle;
import net.mornity.dappledup.client.particle.OrangePoplarLeafParticleParticle;

@EventBusSubscriber(Dist.CLIENT)
public class DappledUpModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(DappledUpModParticleTypes.RED_POPLAR_LEAF_PARTICLE.get(), RedPoplarLeafParticleParticle::provider);
		event.registerSpriteSet(DappledUpModParticleTypes.YELLOW_POPLAR_LEAF_PARTICLE.get(), YellowPoplarLeafParticleParticle::provider);
		event.registerSpriteSet(DappledUpModParticleTypes.ORANGE_POPLAR_LEAF_PARTICLE.get(), OrangePoplarLeafParticleParticle::provider);
	}
}