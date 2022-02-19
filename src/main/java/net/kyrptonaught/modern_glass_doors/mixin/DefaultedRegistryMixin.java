package net.kyrptonaught.modern_glass_doors.mixin;

import net.kyrptonaught.modern_glass_doors.ModernGlassDoorsMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(DefaultedRegistry.class)
public class DefaultedRegistryMixin {
    @ModifyVariable(at = @At("HEAD"), method = "get(Lnet/minecraft/util/Identifier;)Ljava/lang/Object;", ordinal = 0)
    Identifier fixMissingFromRegistry(@Nullable Identifier id) {
        if(id != null) {
            if(id.getNamespace().equals("glassdoor")) return new Identifier(ModernGlassDoorsMod.MOD_ID, id.getPath());
        }
        return id;
    }
}
