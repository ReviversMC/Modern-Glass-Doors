package net.kyrptonaught.glassdoor.blocks;

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

import net.kyrptonaught.glassdoor.ModernGlassDoors;

public class ModernGlassDoorsBlocks {
	public static final List<GlassDoorBlock> GLASS_DOORS = new ArrayList<>();
	public static final List<GlassTrapdoorBlock> GLASS_TRAPDOORS = new ArrayList<>();

	// Glass doors
	public static final Block OAK_GLASS_DOOR = registerDoor("oak", MaterialCategory.WOOD, Blocks.OAK_DOOR);
	public static final Block SPRUCE_GLASS_DOOR = registerDoor("spruce", MaterialCategory.WOOD, Blocks.SPRUCE_DOOR);
	public static final Block BIRCH_GLASS_DOOR = registerDoor("birch", MaterialCategory.WOOD, Blocks.BIRCH_DOOR);
	public static final Block ACACIA_GLASS_DOOR = registerDoor("acacia", MaterialCategory.WOOD, Blocks.ACACIA_DOOR);
	public static final Block JUNGLE_GLASS_DOOR = registerDoor("jungle", MaterialCategory.WOOD, Blocks.JUNGLE_DOOR);
	public static final Block DARK_OAK_GLASS_DOOR = registerDoor("dark_oak", MaterialCategory.WOOD, Blocks.DARK_OAK_DOOR);
	public static final Block CRIMSON_GLASS_DOOR = registerDoor("crimson", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.CRIMSON_DOOR);
	public static final Block WARPED_GLASS_DOOR = registerDoor("warped", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.WARPED_DOOR);
	public static final Block IRON_GLASS_DOOR = registerDoor("iron", MaterialCategory.METAL, Blocks.IRON_DOOR);

	// Glass trapdoors
	public static final Block OAK_GLASS_TRAPDOOR = registerTrapdoor("oak", MaterialCategory.WOOD, Blocks.OAK_TRAPDOOR);
	public static final Block SPRUCE_GLASS_TRAPDOOR = registerTrapdoor("spruce", MaterialCategory.WOOD, Blocks.SPRUCE_TRAPDOOR);
	public static final Block BIRCH_GLASS_TRAPDOOR = registerTrapdoor("birch", MaterialCategory.WOOD, Blocks.BIRCH_TRAPDOOR);
	public static final Block ACACIA_GLASS_TRAPDOOR = registerTrapdoor("acacia", MaterialCategory.WOOD, Blocks.ACACIA_TRAPDOOR);
	public static final Block JUNGLE_GLASS_TRAPDOOR = registerTrapdoor("jungle", MaterialCategory.WOOD, Blocks.JUNGLE_TRAPDOOR);
	public static final Block DARK_OAK_GLASS_TRAPDOOR = registerTrapdoor("dark_oak", MaterialCategory.WOOD, Blocks.DARK_OAK_TRAPDOOR);
	public static final Block CRIMSON_GLASS_TRAPDOOR = registerTrapdoor("crimson", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.CRIMSON_TRAPDOOR);
	public static final Block WARPED_GLASS_TRAPDOOR = registerTrapdoor("warped", MaterialCategory.NON_FLAMMABLE_WOOD, Blocks.WARPED_TRAPDOOR);
	public static final Block IRON_GLASS_TRAPDOOR = registerTrapdoor("iron", MaterialCategory.METAL, Blocks.IRON_TRAPDOOR);

	public static Block registerDoor(String material, MaterialCategory materialCategory, Block parentDoorType) {
		assert parentDoorType instanceof DoorBlock;

		GlassDoorBlock door = new GlassDoorBlock(materialCategory, parentDoorType);
		Identifier id = new Identifier(ModernGlassDoors.MOD_ID, material + "_glass_door");

		GLASS_DOORS.add(door);
		Registry.register(Registry.BLOCK, id, door);
		Registry.register(Registry.ITEM, id, new TallBlockItem(door, new Item.Settings().group(ModernGlassDoors.ITEM_GROUP)));

		return door;
	}

	public static Block registerTrapdoor(String material, MaterialCategory materialCategory, Block parentTrapdoorType) {
		assert parentTrapdoorType instanceof TrapdoorBlock;

		GlassTrapdoorBlock trapdoor = new GlassTrapdoorBlock(materialCategory, parentTrapdoorType);
		Identifier id = new Identifier(ModernGlassDoors.MOD_ID, material + "_glass_trapdoor");

		GLASS_TRAPDOORS.add(trapdoor);
		Registry.register(Registry.BLOCK, id, trapdoor);
		Registry.register(Registry.ITEM, id, new BlockItem(trapdoor, new Item.Settings().group(ModernGlassDoors.ITEM_GROUP)));

		return trapdoor;
	}
}
