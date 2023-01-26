package net.kyrptonaught.glassdoor;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import net.kyrptonaught.glassdoor.blocks.GlassDoorBlock;
import net.kyrptonaught.glassdoor.blocks.GlassTrapdoorBlock;
import net.kyrptonaught.glassdoor.blocks.ModernGlassDoorsBlocks;

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
