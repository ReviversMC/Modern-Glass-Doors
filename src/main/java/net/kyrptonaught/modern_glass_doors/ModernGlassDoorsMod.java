package net.kyrptonaught.modern_glass_doors;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;


public class ModernGlassDoorsMod implements ModInitializer, ClientModInitializer {
    public static final String MOD_ID = "modern_glass_doors";

    public static GlassDoorBlock oakGlassDoor;
    public static GlassDoorBlock spruceGlassDoor;
    public static GlassDoorBlock birchGlassDoor;
    public static GlassDoorBlock acaciaGlassDoor;
    public static GlassDoorBlock jungleGlassDoor;
    public static GlassDoorBlock darkOakGlassDoor;
    public static GlassDoorBlock ironGlassDoor;

    public static GlassTrapDoorBlock oakGlassTrapdoor;
    public static GlassTrapDoorBlock spruceGlassTrapdoor;
    public static GlassTrapDoorBlock birchGlassTrapdoor;
    public static GlassTrapDoorBlock acaciaGlassTrapdoor;
    public static GlassTrapDoorBlock jungleGlassTrapdoor;
    public static GlassTrapDoorBlock darkOakGlassTrapdoor;
    public static GlassTrapDoorBlock ironGlassTrapdoor;

    @Override
    public void onInitialize() {
        oakGlassDoor = new GlassDoorBlock(Block.Settings.copy(Blocks.OAK_DOOR), "oak_glass_door");
        spruceGlassDoor = new GlassDoorBlock(Block.Settings.copy(Blocks.SPRUCE_DOOR), "spruce_glass_door");
        birchGlassDoor = new GlassDoorBlock(Block.Settings.copy(Blocks.BIRCH_DOOR), "birch_glass_door");
        acaciaGlassDoor = new GlassDoorBlock(Block.Settings.copy(Blocks.ACACIA_DOOR), "acacia_glass_door");
        jungleGlassDoor = new GlassDoorBlock(Block.Settings.copy(Blocks.JUNGLE_DOOR), "jungle_glass_door");
        darkOakGlassDoor = new GlassDoorBlock(Block.Settings.copy(Blocks.DARK_OAK_DOOR), "dark_oak_glass_door");
        ironGlassDoor = new GlassDoorBlock(Block.Settings.copy(Blocks.IRON_DOOR), "iron_glass_door");

        oakGlassTrapdoor = new GlassTrapDoorBlock(Block.Settings.copy(Blocks.OAK_TRAPDOOR), "oak_glass_trapdoor");
        spruceGlassTrapdoor = new GlassTrapDoorBlock(Block.Settings.copy(Blocks.SPRUCE_TRAPDOOR), "spruce_glass_trapdoor");
        birchGlassTrapdoor = new GlassTrapDoorBlock(Block.Settings.copy(Blocks.BIRCH_TRAPDOOR), "birch_glass_trapdoor");
        acaciaGlassTrapdoor = new GlassTrapDoorBlock(Block.Settings.copy(Blocks.ACACIA_TRAPDOOR), "acacia_glass_trapdoor");
        jungleGlassTrapdoor = new GlassTrapDoorBlock(Block.Settings.copy(Blocks.JUNGLE_TRAPDOOR), "jungle_glass_trapdoor");
        darkOakGlassTrapdoor = new GlassTrapDoorBlock(Block.Settings.copy(Blocks.DARK_OAK_TRAPDOOR), "dark_oak_glass_trapdoor");
        ironGlassTrapdoor = new GlassTrapDoorBlock(Block.Settings.copy(Blocks.IRON_TRAPDOOR), "iron_glass_trapdoor");
    }
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(oakGlassDoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(spruceGlassDoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(birchGlassDoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(acaciaGlassDoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(jungleGlassDoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(darkOakGlassDoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ironGlassDoor, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(oakGlassTrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(spruceGlassTrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(birchGlassTrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(acaciaGlassTrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(jungleGlassTrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(darkOakGlassTrapdoor, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ironGlassTrapdoor, RenderLayer.getCutout());

    }
    public static BlockState copyState(BlockState copyState) {
        if (!(copyState.getBlock() instanceof DoorBlock)) return copyState;

        BlockState newState = oakGlassDoor.getDefaultState();
        if (copyState.getBlock().equals(Blocks.JUNGLE_DOOR)) newState = jungleGlassDoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.BIRCH_DOOR)) newState = birchGlassDoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.SPRUCE_DOOR)) newState = spruceGlassDoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.ACACIA_DOOR)) newState = acaciaGlassDoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.DARK_OAK_DOOR)) newState = darkOakGlassDoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.IRON_DOOR)) newState = ironGlassDoor.getDefaultState();
        return newState.with(DoorBlock.FACING, copyState.get(DoorBlock.FACING)).with(DoorBlock.HINGE, copyState.get(DoorBlock.HINGE)).with(DoorBlock.OPEN, copyState.get(DoorBlock.OPEN));
    }
    public static BlockState copyTrapdoorState(BlockState copyState) {
        if (!(copyState.getBlock() instanceof TrapdoorBlock)) return copyState;

        BlockState newState = oakGlassTrapdoor.getDefaultState();
        if (copyState.getBlock().equals(Blocks.JUNGLE_TRAPDOOR)) newState = jungleGlassTrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.BIRCH_TRAPDOOR)) newState = birchGlassTrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.SPRUCE_TRAPDOOR)) newState = spruceGlassTrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.ACACIA_TRAPDOOR)) newState = acaciaGlassTrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.DARK_OAK_TRAPDOOR)) newState = darkOakGlassTrapdoor.getDefaultState();
        else if (copyState.getBlock().equals(Blocks.IRON_TRAPDOOR)) newState = ironGlassTrapdoor.getDefaultState();
        return newState.with(TrapdoorBlock.FACING, copyState.get(TrapdoorBlock.FACING)).with(TrapdoorBlock.OPEN, copyState.get(TrapdoorBlock.OPEN)).with(TrapdoorBlock.HALF, copyState.get(TrapdoorBlock.HALF)).with(TrapdoorBlock.POWERED, copyState.get(TrapdoorBlock.POWERED)).with(TrapdoorBlock.WATERLOGGED, copyState.get(TrapdoorBlock.WATERLOGGED));
    }
}
