package com.github.reviversmc.modern_glass_doors.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;

public class GlassDoorBlock extends DoorBlock {
	public static BlockState copyState(BlockState state) {
		if (!(state.getBlock() instanceof DoorBlock)) {
			return state;
		}

		for (GlassDoorBlock door : ModernGlassDoorsBlocks.GLASS_DOORS) {
			if (door.getParentDoorType().equals(state.getBlock())) {
				return door.getDefaultState()
						.with(DoorBlock.FACING, state.get(DoorBlock.FACING))
						.with(DoorBlock.HINGE, state.get(DoorBlock.HINGE))
						.with(DoorBlock.OPEN, state.get(DoorBlock.OPEN));
			}
		}

		return state;
	}

	public final MaterialCategory materialCategory;
	public final DoorBlock parentDoorType;

	GlassDoorBlock(MaterialCategory materialCategory, DoorBlock parentDoorType) {
		super(Block.Settings.copy(parentDoorType), parentDoorType.blockSetType);

		this.materialCategory = materialCategory;
		this.parentDoorType = (DoorBlock) parentDoorType;
	}

	public MaterialCategory getMaterialCategory() {
		return materialCategory;
	}

	public DoorBlock getParentDoorType() {
		return parentDoorType;
	}
}
