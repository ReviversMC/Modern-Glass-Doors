package com.github.reviversmc.modern_glass_doors.datagen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import com.github.reviversmc.modern_glass_doors.blocks.GlassDoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.GlassTrapdoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.MaterialCategory;
import com.github.reviversmc.modern_glass_doors.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoorsItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public ModernGlassDoorsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		for (GlassDoorBlock door: ModernGlassDoorsBlocks.GLASS_DOORS) {
			if (door.getMaterialCategory() == MaterialCategory.NETHER_WOOD) {
				getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(door.asItem());
			}
		}

		for (GlassTrapdoorBlock trapdoor: ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			if (trapdoor.getMaterialCategory() == MaterialCategory.NETHER_WOOD) {
				getOrCreateTagBuilder(ItemTags.NON_FLAMMABLE_WOOD).add(trapdoor.asItem());
			}
		}
	}
}
