package net.mornity.dappledup.block;

import net.mornity.dappledup.init.DappledUpModWoodTypes;
import net.mornity.dappledup.init.DappledUpModBlocks;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.SoundType;

public class PoplarWallSignBlock extends WallSignBlock {
	public PoplarWallSignBlock() {
		super(DappledUpModWoodTypes.POPLAR_SIGN_WOOD_TYPE, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.CHERRY_WOOD).strength(1f).noCollission().pushReaction(PushReaction.BLOCK)
				.isRedstoneConductor((bs, br, bp) -> false).ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn().dropsLike(DappledUpModBlocks.POPLAR_SIGN.get()));
	}
}