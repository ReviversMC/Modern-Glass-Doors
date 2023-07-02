package com.github.reviversmc.modern_glass_doors;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import com.github.reviversmc.modern_glass_doors.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoors implements ModInitializer {
	// Hardcoded Mod Identification
	public static final String MOD_ID = "modern_glass_doors";

	// ItemGroup Declaration
	public static final RegistryKey<ItemGroup> ITEM_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "blocks"));

	@Override
	public void onInitialize() {
		ModernGlassDoorsBlocks.register();

		Registry.register(Registries.ITEM_GROUP, ITEM_GROUP, FabricItemGroup.builder()
				.displayName(Text.translatable("itemGroup." + MOD_ID + ".blocks"))
				.icon(() -> new ItemStack(ModernGlassDoorsBlocks.OAK_GLASS_DOOR.asItem()))
				.build()
		);
	}
}
