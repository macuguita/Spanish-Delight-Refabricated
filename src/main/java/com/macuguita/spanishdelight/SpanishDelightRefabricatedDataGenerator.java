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

import com.macuguita.spanishdelight.datagen.provider.SDBiomeTagProvider;
import com.macuguita.spanishdelight.datagen.provider.SDBlockTagProvider;
import com.macuguita.spanishdelight.datagen.SDVillagerTrades;
import com.macuguita.spanishdelight.datagen.provider.SDItemTagProvider;
import com.macuguita.spanishdelight.datagen.provider.SDLootTableProvider;
import com.macuguita.spanishdelight.datagen.provider.SDModelProvider;
import com.macuguita.spanishdelight.datagen.provider.SDRecipeProvider;

import com.macuguita.spanishdelight.datagen.provider.SDVillagerTradesTagsProvider;

import com.macuguita.spanishdelight.worldgen.SDWorldgen;

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

		pack.addProvider(SDBiomeTagProvider::new);
		pack.addProvider(SDBlockTagProvider::new);
		pack.addProvider(SDItemTagProvider::new);
		pack.addProvider(SDLootTableProvider::new);
		pack.addProvider(SDModelProvider::new);
		pack.addProvider(SDRecipeProvider::new);
		pack.addProvider(SDVillagerTradesTagsProvider::new);
		pack.addProvider(ModDynamicRegistryProvider::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.VILLAGER_TRADE, SDVillagerTrades::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, SDWorldgen::bootstrapConfiguredFeatures);
		registryBuilder.add(Registries.PLACED_FEATURE, SDWorldgen::bootstrapPlacedFeatures);
	}

	static class ModDynamicRegistryProvider extends FabricDynamicRegistryProvider {

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
