package net.mornity.dappledup.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.PressurePlateBlock;

public class PoplarPressurePlateBlock extends PressurePlateBlock {
	public PoplarPressurePlateBlock() {
		super(BlockSetType.CHERRY,
				BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.CHERRY_WOOD).strength(0.5f).noCollission().pushReaction(PushReaction.DESTROY).ignitedByLava().instrument(NoteBlockInstrument.BASS).forceSolidOn());
	}
}