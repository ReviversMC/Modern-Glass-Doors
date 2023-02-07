package com.github.reviversmc.modern_glass_doors.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrapdoorBlock;

public class GlassTrapdoorBlock extends TrapdoorBlock {
	public static BlockState copyState(BlockState state) {
		if (!(state.getBlock() instanceof TrapdoorBlock)) {
			return state;
		}

		for (GlassTrapdoorBlock trapdoor : ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			if (trapdoor.getParentTrapdoorType().equals(state.getBlock())) {
				return trapdoor.getDefaultState()
						.with(TrapdoorBlock.FACING, state.get(TrapdoorBlock.FACING))
						.with(TrapdoorBlock.OPEN, state.get(TrapdoorBlock.OPEN))
						.with(TrapdoorBlock.HALF, state.get(TrapdoorBlock.HALF))
						.with(TrapdoorBlock.POWERED, state.get(TrapdoorBlock.POWERED))
						.with(TrapdoorBlock.WATERLOGGED, state.get(TrapdoorBlock.WATERLOGGED));
			}
		}

		return state;
	}

	private final MaterialCategory materialCategory;
	private final TrapdoorBlock parentTrapdoorType;

	GlassTrapdoorBlock(MaterialCategory materialCategory, TrapdoorBlock parentTrapdoorType) {
		super(Block.Settings.copy(parentTrapdoorType), parentTrapdoorType.closeSound, parentTrapdoorType.openSound);

		this.materialCategory = materialCategory;
		this.parentTrapdoorType = (TrapdoorBlock) parentTrapdoorType;
	}

	public MaterialCategory getMaterialCategory() {
		return materialCategory;
	}

	public TrapdoorBlock getParentTrapdoorType() {
		return parentTrapdoorType;
	}
}
