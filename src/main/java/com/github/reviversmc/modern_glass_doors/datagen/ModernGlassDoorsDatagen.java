package com.github.reviversmc.modern_glass_doors.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModernGlassDoorsDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();
		pack.addProvider(ModernGlassDoorsLootTableProvider::new);
		pack.addProvider(ModernGlassDoorsBlockTagProvider::new);
		pack.addProvider(ModernGlassDoorsItemTagProvider::new);
		pack.addProvider(ModernGlassDoorsRecipeProvider::new);
		pack.addProvider(ModernGlassDoorsModelProvider::new);
	}
}
