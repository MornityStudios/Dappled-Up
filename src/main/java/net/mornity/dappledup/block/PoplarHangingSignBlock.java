package net.mornity.dappledup.block;

import net.mornity.dappledup.init.DappledUpModWoodTypes;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.CeilingHangingSignBlock;

public class PoplarHangingSignBlock extends CeilingHangingSignBlock {
	public PoplarHangingSignBlock() {
		super(DappledUpModWoodTypes.POPLAR_HANGING_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.CHERRY_WOOD_HANGING_SIGN).strength(1f).noOcclusion().pushReaction(PushReaction.BLOCK)
				.isRedstoneConductor((bs, br, bp) -> false).ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn());
	}
}