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

package com.macuguita.spanishdelight;

import com.macuguita.spanishdelight.datagen.ModBlockTagProvider;
import com.macuguita.spanishdelight.datagen.ModVillagerTrades;
import com.macuguita.spanishdelight.datagen.provider.ModItemTagProvider;
import com.macuguita.spanishdelight.datagen.provider.ModLootTableProvider;
import com.macuguita.spanishdelight.datagen.provider.ModModelProvider;
import com.macuguita.spanishdelight.datagen.provider.ModRecipeProvider;

import com.macuguita.spanishdelight.datagen.provider.ModVillagerTradesTagsProvider;

import com.macuguita.spanishdelight.worldgen.ModWorldgen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

import java.util.concurrent.CompletableFuture;

public class SpanishDelightRefabricatedDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModVillagerTradesTagsProvider::new);
		pack.addProvider(ModDynamicRegistryProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.VILLAGER_TRADE, ModVillagerTrades::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, ModWorldgen::bootstrapConfiguredFeatures);
		registryBuilder.add(Registries.PLACED_FEATURE, ModWorldgen::bootstrapPlacedFeatures);
	}

	class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {

		public ModDynamicRegistryProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected void configure(HolderLookup.Provider registries, Entries entries) {
			entries.addAll(registries.lookupOrThrow(Registries.VILLAGER_TRADE));
			entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE));
			entries.addAll(registries.lookupOrThrow(Registries.PLACED_FEATURE));
		}

		@Override
		public String getName() {
			return "Spanish delight dynamic registry provider";
		}
	}
}
