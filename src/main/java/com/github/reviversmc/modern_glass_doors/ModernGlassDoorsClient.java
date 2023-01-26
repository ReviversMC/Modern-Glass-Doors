package com.github.reviversmc.modern_glass_doors;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import com.github.reviversmc.modern_glass_doors.blocks.GlassDoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.GlassTrapdoorBlock;
import com.github.reviversmc.modern_glass_doors.blocks.ModernGlassDoorsBlocks;

public class ModernGlassDoorsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Make sure that the glass renders translucent on the client
		for (GlassDoorBlock door : ModernGlassDoorsBlocks.GLASS_DOORS) {
			BlockRenderLayerMap.INSTANCE.putBlock(door, RenderLayer.getTranslucent());
		}

		for (GlassTrapdoorBlock trapdoor : ModernGlassDoorsBlocks.GLASS_TRAPDOORS) {
			BlockRenderLayerMap.INSTANCE.putBlock(trapdoor, RenderLayer.getTranslucent());
		}
	}
}
