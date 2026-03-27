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

package com.macuguita.spanishdelight.datagen.provider;

import com.macuguita.spanishdelight.datagen.ModVillagerTrades;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VillagerTradesTagsProvider;
import net.minecraft.tags.VillagerTradeTags;

import java.util.concurrent.CompletableFuture;

public class ModVillagerTradesTagsProvider extends VillagerTradesTagsProvider {

	public ModVillagerTradesTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
		super(output, lookupProvider);
	}

	@Override
	protected void addTags(HolderLookup.Provider registries) {

		// FARMER LEVEL 1
		this.tag(VillagerTradeTags.FARMER_LEVEL_1)
				.add(
						ModVillagerTrades.FARMER_1_EMERALD_GREEN_BEAM
				);

		// FARMER LEVEL 2
		this.tag(VillagerTradeTags.FARMER_LEVEL_2)
				.add(
						ModVillagerTrades.FARMER_2_TOMATO_GARLIC,
						ModVillagerTrades.FARMER_2_SLICED_POTATO_RED_PEPPER,
						ModVillagerTrades.FARMER_2_RICE_GREEN_PEPPER
				);

		// FARMER LEVEL 3
		this.tag(VillagerTradeTags.FARMER_LEVEL_3)
				.add(
						ModVillagerTrades.FARMER_3_GAZPACHO_GARLIC,
						ModVillagerTrades.FARMER_3_BRAVA_POTATOES_RED_PEPPER,
						ModVillagerTrades.FARMER_3_PIL_PIL_COD_RED_PEPPER
				);

		// FARMER LEVEL 4
		this.tag(VillagerTradeTags.FARMER_LEVEL_4)
				.add(
						ModVillagerTrades.FARMER_4_EMERALD_GARLIC,
						ModVillagerTrades.FARMER_4_EMERALD_RED_PEPPER,
						ModVillagerTrades.FARMER_4_EMERALD_GREEN_PEPPER
				);

		// FARMER LEVEL 5
		this.tag(VillagerTradeTags.FARMER_LEVEL_5)
				.add(
						ModVillagerTrades.FARMER_5_EMERALD_GARLIC,
						ModVillagerTrades.FARMER_5_EMERALD_RED_PEPPER,
						ModVillagerTrades.FARMER_5_EMERALD_GREEN_PEPPER
				);

		// WANDERING TRADER
		this.tag(VillagerTradeTags.WANDERING_TRADER_COMMON)
				.add(
						ModVillagerTrades.WANDERING_GARLIC_DIAMOND_KNIFE,
						ModVillagerTrades.WANDERING_RED_PEPPER_DIAMOND_KNIFE,
						ModVillagerTrades.WANDERING_GREEN_PEPPER_DIAMOND_KNIFE
				);
	}
}
