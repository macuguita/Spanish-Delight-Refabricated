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

package io.github.macuguita.datagen;

import java.util.concurrent.CompletableFuture;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItems;
import io.github.macuguita.utils.ModTags;
import vectorwing.farmersdelight.common.tag.CommonTags;

import net.minecraft.core.HolderLookup;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

	public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
		super(output, completableFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		valueLookupBuilder(vectorwing.farmersdelight.common.tag.ModTags.WILD_CROPS_ITEM)
				.add(ModBlocks.WILD_GARLIC.asItem())
				.add(ModBlocks.WILD_GREEN_PEPPER.asItem())
				.add(ModBlocks.WILD_RED_PEPPER.asItem());
		valueLookupBuilder(vectorwing.farmersdelight.common.tag.ModTags.MEALS)
				.add(ModItems.PAELLA)
				.add(ModItems.PIL_PIL_COD)
				.add(ModItems.BRAVA_POTATOES)
				.add(ModItems.GAZPACHO);
		valueLookupBuilder(CommonTags.CROPS_ONION)
				.add(ModItems.SLICED_ONION);
		valueLookupBuilder(ConventionalItemTags.POTATO_CROPS)
				.add(ModItems.SLICED_POTATO);
		valueLookupBuilder(ConventionalItemTags.BREAD_FOODS)
				.add(ModItems.PANTUMACA);
		valueLookupBuilder(ModTags.Items.GARLIC)
				.add(ModItems.GARLIC);
	}
}
