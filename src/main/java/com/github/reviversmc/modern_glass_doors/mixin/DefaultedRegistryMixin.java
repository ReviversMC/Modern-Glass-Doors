package com.github.reviversmc.modern_glass_doors.mixin;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.DefaultedRegistry;

import com.github.reviversmc.modern_glass_doors.ModernGlassDoors;

@Mixin(DefaultedRegistry.class)
public class DefaultedRegistryMixin {
	private static final String OLD_MOD_ID = "glassdoor";

	@ModifyVariable(at = @At("HEAD"), method = "get(Lnet/minecraft/util/Identifier;)Ljava/lang/Object;", ordinal = 0)
	Identifier modern_glass_doors_upgradeIds(@Nullable Identifier identifier) {
		if (identifier == null) {
			return null;
		}

		if (!identifier.getNamespace().equals(OLD_MOD_ID)) {
			return identifier;
		}

		String oldPath = identifier.getPath();
		String newPath = oldPath;

		if (oldPath.contains("_glassdoor")) {
			newPath = oldPath.replace("_glassdoor", "_glass_door");
		} else if (oldPath.contains("_glasstrapdoor")) {
			newPath = oldPath.replace("_glasstrapdoor", "_glass_trapdoor");
		}

		return new Identifier(ModernGlassDoors.MOD_ID, newPath);
	}
}
