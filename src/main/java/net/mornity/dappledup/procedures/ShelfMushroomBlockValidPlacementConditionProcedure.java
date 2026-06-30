package net.mornity.dappledup.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class ShelfMushroomBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((getDirectionFromBlockState(blockstate)) == Direction.NORTH && world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude()) {
			return true;
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.SOUTH && world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude()) {
			return true;
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.WEST && world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
			return true;
		} else if ((getDirectionFromBlockState(blockstate)) == Direction.EAST && world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude()) {
			return true;
		}
		return false;
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = getPropertyByName(blockState, "facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = getPropertyByName(blockState, "axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}