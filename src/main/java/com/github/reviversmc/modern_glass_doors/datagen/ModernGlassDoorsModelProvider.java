package com.github.reviversmc.modern_glass_doors.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

import com.github.reviversmc.modern_glass_doors.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoorsModelProvider extends FabricModelProvider {
	public ModernGlassDoorsModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockStateModelGenerator generator) {
		for (Block door: ModernGlassDoorsBlocks.GLASS_DOORS) {
			generator.registerDoor(door);
		}

		for (Block trapdoor: ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			generator.registerOrientableTrapdoor(trapdoor);
		}
	}

	@Override
	public void generateItemModels(ItemModelGenerator generator) {
	}
}
