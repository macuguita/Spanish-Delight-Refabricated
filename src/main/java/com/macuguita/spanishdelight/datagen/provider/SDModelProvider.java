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

import com.macuguita.spanishdelight.reg.SDBlocks;
import com.macuguita.spanishdelight.block.GreenBeanCropBlock;
import com.macuguita.spanishdelight.reg.SDItems;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;

public class SDModelProvider extends FabricModelProvider {

	public SDModelProvider(FabricPackOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

		blockStateModelGenerator.createCrossBlockWithDefaultItem(SDBlocks.WILD_GARLIC, BlockModelGenerators.PlantType.NOT_TINTED);
		blockStateModelGenerator.createCrossBlockWithDefaultItem(SDBlocks.WILD_RED_PEPPER, BlockModelGenerators.PlantType.NOT_TINTED);
		blockStateModelGenerator.createCrossBlockWithDefaultItem(SDBlocks.WILD_GREEN_PEPPER, BlockModelGenerators.PlantType.NOT_TINTED);

		blockStateModelGenerator.createCropBlock(SDBlocks.GREEN_BEAN_CROP, GreenBeanCropBlock.GREEN_BEAN_AGE, 0, 1, 2, 3, 4, 5);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		itemModelGenerator.generateFlatItem(SDItems.PAPRIKA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.SLICED_POTATO, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.SLICED_ONION, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.GARLIC, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.RED_PEPPER, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.GREEN_PEPPER, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.SQUID_RING, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.SPANISH_TORTILLA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.PAELLA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.PIL_PIL_COD, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.CROQUETTES, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.BRAVA_POTATOES, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.CHURRO, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.GAZPACHO, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.PANTUMACA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(SDItems.FRIED_SQUID_RING, ModelTemplates.FLAT_ITEM);
	}
}
