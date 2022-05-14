package net.kyrptonaught.modern_glass_doors;

import net.minecraft.block.DoorBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.TallBlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GlassDoorBlock extends DoorBlock {

    GlassDoorBlock(Settings blockSettings, String name) {
        super(blockSettings);
        Registry.register(Registry.BLOCK, new Identifier(ModernGlassDoorsMod.MOD_ID, name), this);
        Registry.register(
                Registry.ITEM,
                new Identifier(ModernGlassDoorsMod.MOD_ID, name),
                new TallBlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));
    }
}
