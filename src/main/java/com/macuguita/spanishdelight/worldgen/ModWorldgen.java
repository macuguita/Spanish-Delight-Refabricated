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
import com.macuguita.spanishdelight.block.ModBlocks;
import com.macuguita.spanishdelight.utils.ModTags;

import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import vectorwing.farmersdelight.common.registry.ModBiomeFeatures;
import vectorwing.farmersdelight.common.world.configuration.InOrderFeatureConfiguration;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Vec3i;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
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
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;

import vectorwing.farmersdelight.common.world.filter.BiomeTagFilter;

public class ModWorldgen {

	public static final ResourceKey<ConfiguredFeature<?, ?>> COARSE_DIRT_CONFIGURED = registerConfiguredFeature("coarse_dirt");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_GRASS_CONFIGURED = registerConfiguredFeature("short_grass");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_GARLIC_CONFIGURED = registerConfiguredFeature("wild_garlic");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_GREEN_PEPPER_CONFIGURED = registerConfiguredFeature("wild_green_pepper");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_RED_PEPPER_CONFIGURED = registerConfiguredFeature("wild_red_pepper");

	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_GARLIC_PATCH_CONFIGURED = registerConfiguredFeature("wild_garlic_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_RED_PEPPER_PATCH_CONFIGURED = registerConfiguredFeature("wild_red_pepper_patch");
	public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_GREEN_PEPPER_PATCH_CONFIGURED = registerConfiguredFeature("wild_green_pepper_patch");


	public static final ResourceKey<PlacedFeature> COARSE_DIRT_PLACED = registerPlacedFeature("coarse_dirt");
	public static final ResourceKey<PlacedFeature> SHORT_GRASS_PLACED = registerPlacedFeature("short_grass");
	public static final ResourceKey<PlacedFeature> WILD_GARLIC_PLACED = registerPlacedFeature("wild_garlic");
	public static final ResourceKey<PlacedFeature> WILD_GREEN_PEPPER_PLACED = registerPlacedFeature("wild_green_pepper");
	public static final ResourceKey<PlacedFeature> WILD_RED_PEPPER_PLACED = registerPlacedFeature("wild_red_pepper");

	public static final ResourceKey<PlacedFeature> WILD_GARLIC_PATCH_PLACED = registerPlacedFeature("wild_garlic_patch");
	public static final ResourceKey<PlacedFeature> WILD_RED_PEPPER_PATCH_PLACED = registerPlacedFeature("wild_red_pepper_patch");
	public static final ResourceKey<PlacedFeature> WILD_GREEN_PEPPER_PATCH_PLACED = registerPlacedFeature("wild_green_pepper_patch");

	private static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredFeature(String id) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, SpanishDelightRefabricated.id(id));
	}

	private static ResourceKey<PlacedFeature> registerPlacedFeature(String id) {
		return ResourceKey.create(Registries.PLACED_FEATURE, SpanishDelightRefabricated.id(id));
	}

	public static void init() {
		BiomeModifications.create(SpanishDelightRefabricated.id("spanish_delight_refabricated_wild_garlic_biome_modifications"))
				.add(ModificationPhase.ADDITIONS, BiomeSelectors.tag(ModTags.Biomes.IS_PLAINS),
						context -> context.getGenerationSettings()
								.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GARLIC_PATCH_PLACED));

		BiomeModifications.create(SpanishDelightRefabricated.id("spanish_delight_refabricated_wild_green_pepper_biome_modifications"))
				.add(ModificationPhase.ADDITIONS, BiomeSelectors.tag(ModTags.Biomes.IS_TAIGA),
						context -> context.getGenerationSettings()
								.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WILD_GREEN_PEPPER_PATCH_PLACED));

		BiomeModifications.create(SpanishDelightRefabricated.id("spanish_delight_refabricated_wild_red_pepper_biome_modifications"))
				.add(ModificationPhase.ADDITIONS, BiomeSelectors.tag(ModTags.Biomes.IS_SAVANNA),
						context -> context.getGenerationSettings()
								.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, WILD_RED_PEPPER_PATCH_PLACED));
	}

	public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
		HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

		registerSimpleBlock(context, COARSE_DIRT_CONFIGURED, Blocks.COARSE_DIRT);
		registerSimpleBlock(context, SHORT_GRASS_CONFIGURED, Blocks.SHORT_GRASS);
		registerSimpleBlock(context, WILD_GARLIC_CONFIGURED, ModBlocks.WILD_GARLIC);
		registerSimpleBlock(context, WILD_GREEN_PEPPER_CONFIGURED, ModBlocks.WILD_GREEN_PEPPER);
		registerSimpleBlock(context, WILD_RED_PEPPER_CONFIGURED, ModBlocks.WILD_RED_PEPPER);

		registerPatch(context, WILD_GARLIC_PATCH_CONFIGURED, placedFeatures, WILD_GARLIC_PLACED);
		registerPatch(context, WILD_GREEN_PEPPER_PATCH_CONFIGURED, placedFeatures, WILD_GREEN_PEPPER_PLACED);
		registerPatch(context, WILD_RED_PEPPER_PATCH_CONFIGURED, placedFeatures, WILD_RED_PEPPER_PLACED);
	}

	public static void bootstrapPlacedFeatures(BootstrapContext<PlacedFeature> context) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(context, COARSE_DIRT_PLACED, configuredFeatures.getOrThrow(COARSE_DIRT_CONFIGURED), coarseDirtPlacement());
		PlacementUtils.register(context, SHORT_GRASS_PLACED, configuredFeatures.getOrThrow(SHORT_GRASS_CONFIGURED), List.of(
				RandomOffsetPlacement.of(
						TrapezoidInt.of(-6, 6, 0),
						TrapezoidInt.of(-3, 3, 0)
				),
				BlockPredicateFilter.forPredicate(
						BlockPredicate.allOf(
								BlockPredicate.matchesBlocks(Blocks.AIR),
								BlockPredicate.matchesTag(new Vec3i(0, -1, 0), BlockTags.DIRT)
						)
				)
		));

		PlacementUtils.register(context, WILD_GARLIC_PLACED,
				configuredFeatures.getOrThrow(WILD_GARLIC_CONFIGURED),
				wildPatchPlacement()
		);
		PlacementUtils.register(context, WILD_GREEN_PEPPER_PLACED,
				configuredFeatures.getOrThrow(WILD_GREEN_PEPPER_CONFIGURED),
				wildPatchPlacement()
		);
		PlacementUtils.register(context, WILD_RED_PEPPER_PLACED,
				configuredFeatures.getOrThrow(WILD_RED_PEPPER_CONFIGURED),
				wildPatchPlacement()
		);

		PlacementUtils.register(context, WILD_GARLIC_PATCH_PLACED, configuredFeatures.getOrThrow(WILD_GARLIC_PATCH_CONFIGURED), patchPlacement());
		PlacementUtils.register(context, WILD_GREEN_PEPPER_PATCH_PLACED, configuredFeatures.getOrThrow(WILD_GREEN_PEPPER_PATCH_CONFIGURED), patchPlacement());
		PlacementUtils.register(context, WILD_RED_PEPPER_PATCH_PLACED, configuredFeatures.getOrThrow(WILD_RED_PEPPER_PATCH_CONFIGURED), patchPlacement());
	}

	private static void registerSimpleBlock(
			BootstrapContext<ConfiguredFeature<?, ?>> ctx,
			ResourceKey<ConfiguredFeature<?, ?>> key,
			Block block
	) {
		FeatureUtils.register(ctx, key, Feature.SIMPLE_BLOCK,
				new SimpleBlockConfiguration(BlockStateProvider.simple(block))
		);
	}

	private static List<PlacementModifier> wildPatchPlacement() {
		return List.of(
				RandomOffsetPlacement.of(
						TrapezoidInt.of(-6, 6, 0),
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

	private static List<PlacementModifier> coarseDirtPlacement() {
		return List.of(
				RandomOffsetPlacement.of(ConstantInt.of(0), ConstantInt.of(1)),
				RandomOffsetPlacement.of(
						TrapezoidInt.of(-6, 6, 0),
						TrapezoidInt.of(-3, 3, 0)
				),
				BlockPredicateFilter.forPredicate(
						BlockPredicate.allOf(
								BlockPredicate.replaceable(new Vec3i(0, 1, 0)),
								BlockPredicate.matchesTag(BlockTags.DIRT)
						)
				)
		);
	}

	private static List<PlacementModifier> patchPlacement() {
		return List.of(
				RarityFilter.onAverageOnceEvery(120),
				InSquarePlacement.spread(),
				CountPlacement.of(64),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome(),
				BiomeTagFilter.biomeIsInTag(BiomeTags.IS_OVERWORLD)
		);
	}

	private static InOrderFeatureConfiguration inOrder(
			HolderGetter<PlacedFeature> placed,
			ResourceKey<PlacedFeature> a,
			ResourceKey<PlacedFeature> b,
			ResourceKey<PlacedFeature> c
	) {
		return new InOrderFeatureConfiguration(
				HolderSet.direct(
						placed.getOrThrow(a),
						placed.getOrThrow(b),
						placed.getOrThrow(c)
				)
		);
	}

	private static void registerPatch(
			BootstrapContext<ConfiguredFeature<?, ?>> ctx,
			ResourceKey<ConfiguredFeature<?, ?>> key,
			HolderGetter<PlacedFeature> placed,
			ResourceKey<PlacedFeature> plant
	) {
		FeatureUtils.register(ctx, key,
				ModBiomeFeatures.IN_ORDER.get(),
				inOrder(placed, COARSE_DIRT_PLACED, plant, SHORT_GRASS_PLACED)
		);
	}
}
