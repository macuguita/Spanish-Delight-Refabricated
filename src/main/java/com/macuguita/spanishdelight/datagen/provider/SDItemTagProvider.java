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

import java.util.concurrent.CompletableFuture;

import com.macuguita.spanishdelight.reg.id.SDBlockItemIds;
import com.macuguita.spanishdelight.reg.id.SDItemIds;
import com.macuguita.spanishdelight.utils.SDTags;

import net.minecraft.tags.ItemTags;

import vectorwing.farmersdelight.common.tag.CommonTags;

import net.minecraft.core.HolderLookup;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;

public class SDItemTagProvider extends FabricTagsProvider.ItemTagsProvider {

	public SDItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		tag(vectorwing.farmersdelight.common.tag.ModTags.Items.WILD_CROPS)
				.add(SDBlockItemIds.WILD_GARLIC.item())
				.add(SDBlockItemIds.WILD_GREEN_PEPPER.item())
				.add(SDBlockItemIds.WILD_RED_PEPPER.item());
		tag(vectorwing.farmersdelight.common.tag.ModTags.Items.MEALS)
				.add(SDItemIds.PAELLA)
				.add(SDItemIds.PIL_PIL_COD)
				.add(SDItemIds.BRAVA_POTATOES)
				.add(SDItemIds.GAZPACHO);
		tag(CommonTags.Items.CROPS_ONION)
				.add(SDItemIds.SLICED_ONION);
		tag(ConventionalItemTags.POTATO_CROPS)
				.add(SDItemIds.SLICED_POTATO);
		tag(ConventionalItemTags.BREAD_FOODS)
				.add(SDItemIds.PANTUMACA);
		tag(SDTags.Items.GARLIC)
				.add(SDItemIds.GARLIC);
		tag(ItemTags.VILLAGER_PLANTABLE_SEEDS)
				.add(SDBlockItemIds.GREEN_BEAN.item());
	}
}
