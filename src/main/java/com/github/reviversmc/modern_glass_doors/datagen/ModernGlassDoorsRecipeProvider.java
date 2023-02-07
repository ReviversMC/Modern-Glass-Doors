package com.github.reviversmc.modern_glass_doors.datagen;

import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;

import com.github.reviversmc.modern_glass_doors.blocks.GlassDoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.GlassTrapdoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoorsRecipeProvider extends FabricRecipeProvider {
	public ModernGlassDoorsRecipeProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generate(Consumer<RecipeJsonProvider> exporter) {
		for (GlassDoorBlock door : ModernGlassDoorsBlocks.GLASS_DOORS) {
			createGlassDoorRecipe(exporter, door, door.getParentDoorType());
			createDoorFromGlassDoorRecipe(exporter, door.getParentDoorType(), door);
		}

		for (GlassTrapdoorBlock trapdoor : ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			createGlassDoorRecipe(exporter, trapdoor, trapdoor.getParentTrapdoorType());
			createDoorFromGlassDoorRecipe(exporter, trapdoor.getParentTrapdoorType(), trapdoor);
		}
	}

	private static void createGlassDoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
				.input(input)
				.input(Blocks.GLASS_PANE)
				.criterion(hasItem(input), conditionsFromItem(input))
				.criterion("has_glass_pane", conditionsFromItem(Blocks.GLASS_PANE))
				.offerTo(exporter);
	}

	private static void createDoorFromGlassDoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
		ShapelessRecipeJsonBuilder.create(RecipeCategory.REDSTONE, output)
				.input(input)
				.criterion(hasItem(input), conditionsFromItem(input))
				.offerTo(exporter, convertBetween(output, input));
	}
}
