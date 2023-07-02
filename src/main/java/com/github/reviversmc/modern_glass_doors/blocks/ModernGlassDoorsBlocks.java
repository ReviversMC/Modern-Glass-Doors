package com.github.reviversmc.modern_glass_doors.blocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.TallBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.github.reviversmc.modern_glass_doors.ModernGlassDoors;

public class ModernGlassDoorsBlocks {
	public static final List<GlassDoorBlock> GLASS_DOORS = new ArrayList<>();
	public static final List<GlassTrapdoorBlock> GLASS_TRAPDOORS = new ArrayList<>();

	// Glass doors
	public static Block OAK_GLASS_DOOR;
	public static Block SPRUCE_GLASS_DOOR;
	public static Block BIRCH_GLASS_DOOR;
	public static Block ACACIA_GLASS_DOOR;
	public static Block JUNGLE_GLASS_DOOR;
	public static Block DARK_OAK_GLASS_DOOR;
	public static Block CRIMSON_GLASS_DOOR;
	public static Block WARPED_GLASS_DOOR;
	public static Block IRON_GLASS_DOOR;

	// Glass trapdoors
	public static Block OAK_GLASS_TRAPDOOR;
	public static Block SPRUCE_GLASS_TRAPDOOR;
	public static Block BIRCH_GLASS_TRAPDOOR;
	public static Block ACACIA_GLASS_TRAPDOOR;
	public static Block JUNGLE_GLASS_TRAPDOOR;
	public static Block DARK_OAK_GLASS_TRAPDOOR;
	public static Block CRIMSON_GLASS_TRAPDOOR;
	public static Block WARPED_GLASS_TRAPDOOR;
	public static Block IRON_GLASS_TRAPDOOR;

	public static void register() {
		// Glass doors
		OAK_GLASS_DOOR = registerDoor("oak", MaterialCategory.WOOD, Blocks.OAK_DOOR);
		SPRUCE_GLASS_DOOR = registerDoor("spruce", MaterialCategory.WOOD, Blocks.SPRUCE_DOOR);
		BIRCH_GLASS_DOOR = registerDoor("birch", MaterialCategory.WOOD, Blocks.BIRCH_DOOR);
		ACACIA_GLASS_DOOR = registerDoor("acacia", MaterialCategory.WOOD, Blocks.ACACIA_DOOR);
		JUNGLE_GLASS_DOOR = registerDoor("jungle", MaterialCategory.WOOD, Blocks.JUNGLE_DOOR);
		DARK_OAK_GLASS_DOOR = registerDoor("dark_oak", MaterialCategory.WOOD, Blocks.DARK_OAK_DOOR);
		CRIMSON_GLASS_DOOR = registerDoor("crimson", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.CRIMSON_DOOR);
		WARPED_GLASS_DOOR = registerDoor("warped", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.WARPED_DOOR);
		IRON_GLASS_DOOR = registerDoor("iron", MaterialCategory.METAL, Blocks.IRON_DOOR);

		// Glass trapdoors
		OAK_GLASS_TRAPDOOR = registerTrapdoor("oak", MaterialCategory.WOOD, Blocks.OAK_TRAPDOOR);
		SPRUCE_GLASS_TRAPDOOR = registerTrapdoor("spruce", MaterialCategory.WOOD, Blocks.SPRUCE_TRAPDOOR);
		BIRCH_GLASS_TRAPDOOR = registerTrapdoor("birch", MaterialCategory.WOOD, Blocks.BIRCH_TRAPDOOR);
		ACACIA_GLASS_TRAPDOOR = registerTrapdoor("acacia", MaterialCategory.WOOD, Blocks.ACACIA_TRAPDOOR);
		JUNGLE_GLASS_TRAPDOOR = registerTrapdoor("jungle", MaterialCategory.WOOD, Blocks.JUNGLE_TRAPDOOR);
		DARK_OAK_GLASS_TRAPDOOR = registerTrapdoor("dark_oak", MaterialCategory.WOOD, Blocks.DARK_OAK_TRAPDOOR);
		CRIMSON_GLASS_TRAPDOOR = registerTrapdoor("crimson", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.CRIMSON_TRAPDOOR);
		WARPED_GLASS_TRAPDOOR = registerTrapdoor("warped", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.WARPED_TRAPDOOR);
		IRON_GLASS_TRAPDOOR = registerTrapdoor("iron", MaterialCategory.METAL, Blocks.IRON_TRAPDOOR);
	}

	private static Block registerDoor(String material, MaterialCategory materialCategory, Block parentDoorType) {
		assert parentDoorType instanceof DoorBlock;

		GlassDoorBlock door = new GlassDoorBlock(materialCategory, parentDoorType);
		Identifier id = new Identifier(ModernGlassDoors.MOD_ID, material + "_glass_door");

		GLASS_DOORS.add(door);
		Registry.register(Registry.BLOCK, id, door);
		Registry.register(Registry.ITEM, id, new TallBlockItem(door, new Item.Settings().group(ModernGlassDoors.ITEM_GROUP)));

		return door;
	}

	private static Block registerTrapdoor(String material, MaterialCategory materialCategory, Block parentTrapdoorType) {
		assert parentTrapdoorType instanceof TrapdoorBlock;

		GlassTrapdoorBlock trapdoor = new GlassTrapdoorBlock(materialCategory, parentTrapdoorType);
		Identifier id = new Identifier(ModernGlassDoors.MOD_ID, material + "_glass_trapdoor");

		GLASS_TRAPDOORS.add(trapdoor);
		Registry.register(Registry.BLOCK, id, trapdoor);
		Registry.register(Registry.ITEM, id, new BlockItem(trapdoor, new Item.Settings().group(ModernGlassDoors.ITEM_GROUP)));

		return trapdoor;
	}
}
