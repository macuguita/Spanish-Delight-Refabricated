/*
 * Copyright (c) 2026 macuguita
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

package com.macuguita.spanishdelight.worldgen;

import java.util.List;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;
import com.macuguita.spanishdelight.reg.SDBlocks;
import com.macuguita.spanishdelight.utils.SDTags;

import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;
import vectorwing.farmersdelight.common.registry.ModBiomeModifiers;
import vectorwing.farmersdelight.common.world.configuration.InOrderFeatureConfiguration;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.TrapezoidInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;

import vectorwing.farmersdelight.common.world.filter.BiomeTagFilter;

public class SDWorldgen {

	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_GARLIC_CONFIGURED = registerConfiguredFeature("wild_garlic");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_RED_PEPPER_CONFIGURED = registerConfiguredFeature("wild_red_pepper");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_GREEN_PEPPER_CONFIGURED = registerConfiguredFeature("wild_green_pepper");

	public static final ResourceKey<PlacedFeature> WILD_GARLIC_PLACED = registerPlacedFeature("wild_garlic");
	public static final ResourceKey<PlacedFeature> WILD_RED_PEPPER_PLACED = registerPlacedFeature("wild_red_pepper");
	public static final ResourceKey<PlacedFeature> WILD_GREEN_PEPPER_PLACED = registerPlacedFeature("wild_green_pepper");

	private static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String id) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, SpanishDelightRefabricated.id(id));
	}

	private static ResourceKey<PlacedFeature> registerPlacedFeature(String id) {
		return ResourceKey.create(Registries.PLACED_FEATURE, SpanishDelightRefabricated.id(id));
	}

	public static void init() {
		BiomeModifications.addFeature(new ModBiomeModifiers.FDBiomeSelector(SDTags.Biomes.IS_PLAINS),
				GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GARLIC_PLACED);

		BiomeModifications.addFeature(new ModBiomeModifiers.FDBiomeSelector(SDTags.Biomes.IS_TAIGA),
				GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GREEN_PEPPER_PLACED);

		BiomeModifications.addFeature(new ModBiomeModifiers.FDBiomeSelector(SDTags.Biomes.IS_SAVANNA),
				GenerationStep.Decoration.VEGETAL_DECORATION, WILD_RED_PEPPER_PLACED);
	}

	public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		registerPatch(context, WILD_GARLIC_CONFIGURED, SDBlocks.WILD_GARLIC);
		registerPatch(context, WILD_GREEN_PEPPER_CONFIGURED, SDBlocks.WILD_GREEN_PEPPER);
		registerPatch(context, WILD_RED_PEPPER_CONFIGURED, SDBlocks.WILD_RED_PEPPER);
	}

	public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configured = context.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(context, WILD_GARLIC_PLACED,
				configured.getOrThrow(WILD_GARLIC_CONFIGURED),
				patchPlacement()
		);

		PlacementUtils.register(context, WILD_GREEN_PEPPER_PLACED,
				configured.getOrThrow(WILD_GREEN_PEPPER_CONFIGURED),
				patchPlacement()
		);

		PlacementUtils.register(context, WILD_RED_PEPPER_PLACED,
				configured.getOrThrow(WILD_RED_PEPPER_CONFIGURED),
				patchPlacement()
		);
	}

	private static List<PlacementModifier> wildPatchPlacement() {
		return List.of(
				RandomOffsetPlacement.of(
						TrapezoidInt.of(-4, 4, 0),
						TrapezoidInt.of(-3, 3, 0)
				),
				BlockPredicateFilter.forPredicate(
						BlockPredicate.allOf(
								BlockPredicate.matchesBlocks(Blocks.AIR),
								BlockPredicate.matchesTag(new Vec3i(0, -1, 0), BlockTags.DIRT)
						)
				)
		);
	}

	private static List<PlacementModifier> patchPlacement() {
		return List.of(
				RarityFilter.onAverageOnceEvery(100),
				InSquarePlacement.spread(),
				CountPlacement.of(64),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				BiomeTagFilter.biomeIsInTag(BiomeTags.IS_OVERWORLD)
		);
	}

	private static void registerPatch(
			BootstrapContext<ConfiguredFeature<?, ?>> ctx,
			ResourceKey<ConfiguredFeature<?, ?>> key,
			Block plantBlock
	) {
		ctx.register(key,
				new ConfiguredFeature<>(
						ModBiomeFeatures.IN_ORDER.get(),
						new InOrderFeatureConfiguration(
								HolderSet.direct(
										Holder.direct(new PlacedFeature(
												Holder.direct(new ConfiguredFeature<>(
														Feature.SIMPLE_BLOCK,
														new SimpleBlockConfiguration(
																BlockStateProvider.simple(plantBlock)
														)
												)),
												wildPatchPlacement()
										)),

										Holder.direct(new PlacedFeature(
												Holder.direct(new ConfiguredFeature<>(
														Feature.SIMPLE_BLOCK,
														new SimpleBlockConfiguration(
																BlockStateProvider.simple(Blocks.SHORT_GRASS)
														)
												)),
												wildPatchPlacement()
										))
								)
						)
				)
		);
	}
}
