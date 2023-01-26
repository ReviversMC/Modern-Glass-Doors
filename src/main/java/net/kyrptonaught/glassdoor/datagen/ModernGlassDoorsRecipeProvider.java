package net.kyrptonaught.glassdoor.datagen;

import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.Identifier;

import net.kyrptonaught.glassdoor.blocks.GlassDoorBlock;
import net.kyrptonaught.glassdoor.blocks.GlassTrapdoorBlock;
import net.kyrptonaught.glassdoor.blocks.ModernGlassDoorsBlocks;
import net.kyrptonaught.glassdoor.ModernGlassDoors;

public class ModernGlassDoorsRecipeProvider extends FabricRecipeProvider {
	public ModernGlassDoorsRecipeProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected Identifier getRecipeIdentifier(Identifier identifier) {
		return new Identifier(ModernGlassDoors.MOD_ID, identifier.getPath());
	}

	@Override
	protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
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
		ShapelessRecipeJsonBuilder.create(output)
				.input(input)
				.input(Blocks.GLASS_PANE)
				.criterion(hasItem(input), conditionsFromItem(input))
				.criterion("has_glass_pane", conditionsFromItem(Blocks.GLASS_PANE))
				.offerTo(exporter);
	}

	private static void createDoorFromGlassDoorRecipe(Consumer<RecipeJsonProvider> exporter, ItemConvertible output, ItemConvertible input) {
		ShapelessRecipeJsonBuilder.create(output)
				.input(input)
				.criterion(hasItem(input), conditionsFromItem(input))
				.offerTo(exporter, convertBetween(output, input));
	}
}
