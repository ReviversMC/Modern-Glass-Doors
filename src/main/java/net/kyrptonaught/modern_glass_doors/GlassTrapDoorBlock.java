package net.kyrptonaught.modern_glass_doors;

import net.minecraft.block.TrapdoorBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GlassTrapDoorBlock extends TrapdoorBlock {
    protected GlassTrapDoorBlock(Settings settings, String name) {
        super(settings);
        Registry.register(Registry.BLOCK, new Identifier(ModernGlassDoorsMod.MOD_ID, name), this);
        Registry.register(
                Registry.ITEM, new Identifier(ModernGlassDoorsMod.MOD_ID, name),
                new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));
    }
}
