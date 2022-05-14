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
	Identifier fixMissingFromRegistry(@Nullable Identifier originalIdentifier) {
		if (originalIdentifier == null) {
			return null;
		}

		if (originalIdentifier.getNamespace().equals(ModernGlassDoorsMod.MOD_ID)
				|| originalIdentifier.getNamespace().equals("glassdoor")) {

			String newPath;
			switch (originalIdentifier.getPath()) {
				// Normal glass doors
				case "oak_glassdoor":
					newPath = "oak_glass_door";
					break;
				case "spruce_glassdoor":
					newPath = "spruce_glass_door";
					break;
				case "birch_glassdoor":
					newPath = "birch_glass_door";
					break;
				case "acacia_glassdoor":
					newPath = "acacia_glass_door";
					break;
				case "jungle_glassdoor":
					newPath = "jungle_glass_door";
					break;
				case "dark_oak_glassdoor":
					newPath = "dark_oak_glass_door";
					break;
				case "iron_glassdoor":
					newPath = "iron_glass_door";
					break;

				// Glass trapdoors
				case "oak_glasstrapdoor":
					newPath = "oak_glass_trapdoor";
					break;
				case "spruce_glasstrapdoor":
					newPath = "spruce_glass_trapdoor";
					break;
				case "birch_glasstrapdoor":
					newPath = "birch_glass_trapdoor";
					break;
				case "acacia_glasstrapdoor":
					newPath = "acacia_glass_trapdoor";
					break;
				case "jungle_glasstrapdoor":
					newPath = "jungle_glass_trapdoor";
					break;
				case "dark_oak_glasstrapdoor":
					newPath = "dark_oak_glass_trapdoor";
					break;
				case "iron_glasstrapdoor":
					newPath = "iron_glass_trapdoor";
					break;

				default:
					newPath = originalIdentifier.getPath();
			}
			return new Identifier(ModernGlassDoorsMod.MOD_ID, newPath);

		} else {
			return originalIdentifier;
		}

	}
}
