package io.github.macuguita.utils;

import java.util.function.Predicate;

import io.github.macuguita.SpanishDelightRefabricated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;

public class ModFeatures {

	private static final ResourceKey<PlacedFeature> WILD_GARLIC = modFeature("wild_garlic_placement");
	private static final ResourceKey<PlacedFeature> WILD_RED_PEPPER = modFeature("wild_red_pepper_placement");
	private static final ResourceKey<PlacedFeature> WILD_GREEN_PEPPER = modFeature("wild_green_pepper_placement");

	@NotNull
	private static ResourceKey<PlacedFeature> modFeature(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, name));
	}

	public static void init() {
		BiomeModifications.addFeature(new FDBiomeSelector(ModTags.Biomes.IS_PLAINS),
				GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GARLIC);
		BiomeModifications.addFeature(new FDBiomeSelector(ModTags.Biomes.IS_SAVANNA),
				GenerationStep.Decoration.VEGETAL_DECORATION, WILD_RED_PEPPER);
		BiomeModifications.addFeature(new FDBiomeSelector(ModTags.Biomes.IS_TAIGA),
				GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GREEN_PEPPER);
	}

	public record FDBiomeSelector(float minTemperature, float maxTemperature, TagKey<Biome> allowed,
								  @Nullable TagKey<Biome> denied) implements Predicate<BiomeSelectionContext> {

		public FDBiomeSelector(TagKey<Biome> tagKey) {
			this(-4f, 4f, tagKey, null);
		}

		@Override
		public boolean test(BiomeSelectionContext biomeSelectionContext) {
			Holder<Biome> biome = biomeSelectionContext.getBiomeRegistryEntry();
			float temp = biome.value().getBaseTemperature();
			if (denied != null && biome.is(denied)) return false;
			return biome.is(allowed) && temp >= minTemperature && temp <= maxTemperature;
		}
	}
}
