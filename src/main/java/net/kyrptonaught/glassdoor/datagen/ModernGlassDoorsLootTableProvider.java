package net.kyrptonaught.glassdoor.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.BlockLootTableGenerator;

import net.kyrptonaught.glassdoor.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoorsLootTableProvider extends FabricBlockLootTableProvider {
	public ModernGlassDoorsLootTableProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateBlockLootTables() {
		for (Block door: ModernGlassDoorsBlocks.GLASS_DOORS) {
			addDrop(door, BlockLootTableGenerator::doorDrops);;
		}

		for (Block trapdoor: ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			addDrop(trapdoor);
		}
	}
}
