package net.kyrptonaught.glassdoor;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

import net.kyrptonaught.glassdoor.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoors implements ModInitializer {
	// Hardcoded Mod Identification
	public static final String MOD_ID = "glassdoor";

	// ItemGroup Declaration
	public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "blocks"),
			() -> new ItemStack(ModernGlassDoorsBlocks.OAK_GLASS_DOOR.asItem()));

	@Override
	public void onInitialize() {
	}
}
