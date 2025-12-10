/*
 * Copyright (c) 2025 macuguita
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

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
