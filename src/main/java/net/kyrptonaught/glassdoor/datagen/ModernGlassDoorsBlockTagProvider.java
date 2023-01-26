package net.kyrptonaught.glassdoor.datagen;

import java.util.Arrays;
import java.util.List;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.kyrptonaught.glassdoor.ModernGlassDoors;
import net.kyrptonaught.glassdoor.blocks.GlassDoorBlock;
import net.kyrptonaught.glassdoor.blocks.GlassTrapdoorBlock;
import net.kyrptonaught.glassdoor.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoorsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public static final TagKey<Block> WOODEN_GLASS_DOORS = TagKey.of(Registry.BLOCK_KEY, new Identifier(ModernGlassDoors.MOD_ID, "wooden_glass_doors"));
	public static final TagKey<Block> METAL_GLASS_DOORS = TagKey.of(Registry.BLOCK_KEY, new Identifier(ModernGlassDoors.MOD_ID, "metal_glass_doors"));
	public static final TagKey<Block> WOODEN_GLASS_TRAPDOORS = TagKey.of(Registry.BLOCK_KEY, new Identifier(ModernGlassDoors.MOD_ID, "wooden_glass_trapdoors"));
	public static final TagKey<Block> METAL_GLASS_TRAPDOORS = TagKey.of(Registry.BLOCK_KEY, new Identifier(ModernGlassDoors.MOD_ID, "metal_glass_trapdoors"));
	public static final TagKey<Block> C_METAL_DOORS = TagKey.of(Registry.BLOCK_KEY, new Identifier("c:metal_doors"));
	public static final TagKey<Block> C_METAL_TRAPDOORS = TagKey.of(Registry.BLOCK_KEY, new Identifier("c:metal_trapdoors"));

	public ModernGlassDoorsBlockTagProvider(FabricDataGenerator dataGenerator) {
		super(dataGenerator);
	}

	@Override
	protected void generateTags() {
		List<FabricTagBuilder<Block>> woodenGlassDoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.WOODEN_DOORS),
				getOrCreateTagBuilder(WOODEN_GLASS_DOORS));

		List<FabricTagBuilder<Block>> metalGlassDoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.DOORS),
				getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE),
				getOrCreateTagBuilder(METAL_GLASS_DOORS));

		List<FabricTagBuilder<Block>> woodenGlassTrapdoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS),
				getOrCreateTagBuilder(WOODEN_GLASS_TRAPDOORS));

		List<FabricTagBuilder<Block>> metalGlassTrapDoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.TRAPDOORS),
				getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE),
				getOrCreateTagBuilder(METAL_GLASS_TRAPDOORS));

		for (GlassDoorBlock door: ModernGlassDoorsBlocks.GLASS_DOORS) {
			switch (door.getMaterialCategory()) {
				case NON_FLAMMABLE_WOOD:
					getOrCreateTagBuilder(BlockTags.NON_FLAMMABLE_WOOD).add(door);
				case WOOD:
					for (FabricTagBuilder<Block> tagBuilder : woodenGlassDoorTagBuilders) {
						tagBuilder.add(door);
					}

					break;

				case METAL:
					for (FabricTagBuilder<Block> tagBuilder : metalGlassDoorTagBuilders) {
						tagBuilder.add(door);
					}

					break;
			}
		}

		for (GlassTrapdoorBlock trapdoor: ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			switch (trapdoor.getMaterialCategory()) {
				case NON_FLAMMABLE_WOOD:
					getOrCreateTagBuilder(BlockTags.NON_FLAMMABLE_WOOD).add(trapdoor);
				case WOOD:
					for (FabricTagBuilder<Block> tagBuilder : woodenGlassTrapdoorTagBuilders) {
						tagBuilder.add(trapdoor);
					}

					break;

				case METAL:
					for (FabricTagBuilder<Block> tagBuilder : metalGlassTrapDoorTagBuilders) {
						tagBuilder.add(trapdoor);
					}

					break;
			}
		}

		getOrCreateTagBuilder(C_METAL_DOORS)
				.add(Blocks.IRON_DOOR)
				.addTag(METAL_GLASS_DOORS);
		getOrCreateTagBuilder(C_METAL_TRAPDOORS)
				.add(Blocks.IRON_TRAPDOOR)
				.addTag(METAL_GLASS_TRAPDOORS);
	}
}
