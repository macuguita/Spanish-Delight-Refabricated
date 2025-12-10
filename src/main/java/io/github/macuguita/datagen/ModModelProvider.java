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

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.block.custom.GreenBeanCropBlock;
import io.github.macuguita.item.ModItems;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

public class ModModelProvider extends FabricModelProvider {

	public ModModelProvider(FabricDataOutput output) {
		super(output);
	}

	@Override
	public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

		blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.WILD_GARLIC, BlockModelGenerators.PlantType.NOT_TINTED);
		blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.WILD_RED_PEPPER, BlockModelGenerators.PlantType.NOT_TINTED);
		blockStateModelGenerator.createCrossBlockWithDefaultItem(ModBlocks.WILD_GREEN_PEPPER, BlockModelGenerators.PlantType.NOT_TINTED);

		blockStateModelGenerator.createCropBlock(ModBlocks.GREEN_BEAN_CROP, GreenBeanCropBlock.GREEN_BEAN_AGE, 0, 1, 2, 3, 4, 5);
	}

	@Override
	public void generateItemModels(ItemModelGenerators itemModelGenerator) {
		itemModelGenerator.generateFlatItem(ModItems.PAPRIKA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.SLICED_POTATO, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.SLICED_ONION, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.GARLIC, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.RED_PEPPER, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.GREEN_PEPPER, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.SQUID_RING, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.SPANISH_TORTILLA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.PAELLA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.PIL_PIL_COD, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.CROQUETTES, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.BRAVA_POTATOES, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.CHURRO, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.GAZPACHO, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.PANTUMACA, ModelTemplates.FLAT_ITEM);
		itemModelGenerator.generateFlatItem(ModItems.FRIED_SQUID_RING, ModelTemplates.FLAT_ITEM);
	}
}
