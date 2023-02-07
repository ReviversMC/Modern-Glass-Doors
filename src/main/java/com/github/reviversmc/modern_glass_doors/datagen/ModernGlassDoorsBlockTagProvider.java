package com.github.reviversmc.modern_glass_doors.datagen;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import com.github.reviversmc.modern_glass_doors.ModernGlassDoors;
import com.github.reviversmc.modern_glass_doors.blocks.GlassDoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.GlassTrapdoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoorsBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public static final TagKey<Block> WOODEN_GLASS_DOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier(ModernGlassDoors.MOD_ID, "wooden_glass_doors"));
	public static final TagKey<Block> METAL_GLASS_DOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier(ModernGlassDoors.MOD_ID, "metal_glass_doors"));
	public static final TagKey<Block> WOODEN_GLASS_TRAPDOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier(ModernGlassDoors.MOD_ID, "wooden_glass_trapdoors"));
	public static final TagKey<Block> METAL_GLASS_TRAPDOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier(ModernGlassDoors.MOD_ID, "metal_glass_trapdoors"));
	public static final TagKey<Block> C_METAL_DOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c:metal_doors"));
	public static final TagKey<Block> C_METAL_TRAPDOORS = TagKey.of(RegistryKeys.BLOCK, new Identifier("c:metal_trapdoors"));

	public ModernGlassDoorsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(RegistryWrapper.WrapperLookup arg) {
		List<FabricTagBuilder> woodenGlassDoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.WOODEN_DOORS),
				getOrCreateTagBuilder(WOODEN_GLASS_DOORS));

		List<FabricTagBuilder> metalGlassDoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.DOORS),
				getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE),
				getOrCreateTagBuilder(METAL_GLASS_DOORS));

		List<FabricTagBuilder> woodenGlassTrapdoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS),
				getOrCreateTagBuilder(WOODEN_GLASS_TRAPDOORS));

		List<FabricTagBuilder> metalGlassTrapDoorTagBuilders = Arrays.asList(
				getOrCreateTagBuilder(BlockTags.TRAPDOORS),
				getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE),
				getOrCreateTagBuilder(METAL_GLASS_TRAPDOORS));

		for (GlassDoorBlock door: ModernGlassDoorsBlocks.GLASS_DOORS) {
			switch (door.getMaterialCategory()) {
				case NON_FLAMMABLE_WOOD:
				case WOOD:
					for (FabricTagBuilder tagBuilder : woodenGlassDoorTagBuilders) {
						tagBuilder.add(door);
					}

					break;

				case METAL:
					for (FabricTagBuilder tagBuilder : metalGlassDoorTagBuilders) {
						tagBuilder.add(door);
					}

					break;
			}
		}

		for (GlassTrapdoorBlock trapdoor: ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			switch (trapdoor.getMaterialCategory()) {
				case NON_FLAMMABLE_WOOD:
				case WOOD:
					for (FabricTagBuilder tagBuilder : woodenGlassTrapdoorTagBuilders) {
						tagBuilder.add(trapdoor);
					}

					break;

				case METAL:
					for (FabricTagBuilder tagBuilder : metalGlassTrapDoorTagBuilders) {
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
