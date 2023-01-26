package net.kyrptonaught.glassdoor.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ModernGlassDoorsDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		dataGenerator.addProvider(ModernGlassDoorsLootTableProvider::new);
		dataGenerator.addProvider(ModernGlassDoorsBlockTagProvider::new);
		dataGenerator.addProvider(ModernGlassDoorsRecipeProvider::new);
		dataGenerator.addProvider(ModernGlassDoorsModelProvider::new);
	}
}
