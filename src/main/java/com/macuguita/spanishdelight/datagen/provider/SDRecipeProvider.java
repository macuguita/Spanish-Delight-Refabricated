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

import com.macuguita.spanishdelight.reg.SDItems;
import com.macuguita.spanishdelight.utils.SDTags;

import net.minecraft.world.item.crafting.CookingBookCategory;

import vectorwing.farmersdelight.common.crafting.CookingPotBookCategory;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;

public class SDRecipeProvider extends FabricRecipeProvider {

	public static final int FAST_COOKING = 100;      // 5 seconds
	public static final int NORMAL_COOKING = 200;    // 10 seconds
	public static final int SLOW_COOKING = 400;      // 20 seconds

	public static final float SMALL_EXP = 0.35F;
	public static final float MEDIUM_EXP = 1.0F;
	public static final float LARGE_EXP = 2.0F;

	public SDRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
		final HolderGetter<Item> itemLookup = wrapperLookup.lookupOrThrow(Registries.ITEM);
		return new RecipeProvider(wrapperLookup, recipeExporter) {
			@Override
			public void buildRecipes() {
				ShapelessRecipeBuilder.shapeless(BuiltInRegistries.ITEM, RecipeCategory.FOOD, SDItems.GAZPACHO)
						.requires(Ingredient.of(itemLookup.getOrThrow(CommonTags.Items.CROPS_TOMATO)))
						.requires(Ingredient.of(itemLookup.getOrThrow(SDTags.Items.GARLIC)))
						.requires(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WATER_BUCKETS)))
						.requires(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.BREAD_FOODS)))
						.requires(Items.BOWL)
						.unlockedBy(getHasName(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()), has(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()))
						.unlockedBy(getHasName(SDItems.GARLIC), has(SDItems.GARLIC))
						.save(recipeExporter);
				ShapelessRecipeBuilder.shapeless(BuiltInRegistries.ITEM, RecipeCategory.FOOD, SDItems.PANTUMACA)
						.requires(Ingredient.of(itemLookup.getOrThrow(CommonTags.Items.CROPS_TOMATO)))
						.requires(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.BREAD_FOODS)))
						.unlockedBy(getHasName(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()), has(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()))
						.unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
						.save(recipeExporter);

				SimpleCookingRecipeBuilder.smelting(Ingredient.of(SDItems.SQUID_RING), RecipeCategory.FOOD, CookingBookCategory.FOOD, SDItems.FRIED_SQUID_RING, 0.35F, 200)
						.unlockedBy(getHasName(SDItems.SQUID_RING), has(SDItems.SQUID_RING))
						.save(recipeExporter);
				SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(SDItems.SQUID_RING), RecipeCategory.FOOD, SDItems.FRIED_SQUID_RING, 0.35F, 200 * 3)
						.unlockedBy(getHasName(SDItems.SQUID_RING), has(SDItems.SQUID_RING))
						.save(recipeExporter, SDItems.FRIED_SQUID_RING + "_from_campfire");
				SimpleCookingRecipeBuilder.smoking(Ingredient.of(SDItems.SQUID_RING), RecipeCategory.FOOD, SDItems.FRIED_SQUID_RING, 0.35F, 200 / 2)
						.unlockedBy(getHasName(SDItems.SQUID_RING), has(SDItems.SQUID_RING))
						.save(recipeExporter, SDItems.FRIED_SQUID_RING + "_from_smoker");

				CookingPotRecipeBuilder.cookingPotRecipe(BuiltInRegistries.ITEM, SDItems.BRAVA_POTATOES, 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
						.addIngredient(SDItems.SLICED_POTATO)
						.addIngredient(SDItems.SLICED_POTATO)
						.addIngredient(SDItems.PAPRIKA)
						.unlockedByItems(getHasName(SDItems.SLICED_POTATO), SDItems.SLICED_POTATO)
						.setRecipeBookCategory(CookingPotBookCategory.MEALS)
						.build(recipeExporter, SDItems.BRAVA_POTATOES + "_from_pot");

				CookingPotRecipeBuilder.cookingPotRecipe(BuiltInRegistries.ITEM, SDItems.CHURRO, 3, NORMAL_COOKING, MEDIUM_EXP)
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WHEAT_CROPS)))
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
						.addIngredient(Items.SUGAR)
						.addIngredient(DefaultCustomIngredients.any(
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WATER_BUCKETS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WATER_DRINKS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WATERY_DRINKS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.MILK_BUCKETS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.MILK_DRINKS))
						))
						.unlockedByItems(getHasName(Items.WHEAT), Items.WHEAT)
						.unlockedByItems(getHasName(Items.EGG), Items.EGG, Items.BROWN_EGG, Items.BLUE_EGG)
						.unlockedByItems(getHasName(Items.SUGAR), Items.SUGAR)
						.unlockedByItems(getHasName(Items.WATER_BUCKET), Items.WATER_BUCKET)
						.setRecipeBookCategory(CookingPotBookCategory.MISC)
						.build(recipeExporter, SDItems.CHURRO + "_from_pot");

				CookingPotRecipeBuilder.cookingPotRecipe(BuiltInRegistries.ITEM, SDItems.CROQUETTES, 1, NORMAL_COOKING, MEDIUM_EXP)
						.addIngredient(vectorwing.farmersdelight.common.registry.ModItems.HAM.get())
						.addIngredient(DefaultCustomIngredients.any(
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WATER_BUCKETS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WATER_DRINKS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WATERY_DRINKS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.MILK_BUCKETS)),
								Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.MILK_DRINKS))
						))
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.WHEAT_CROPS)))
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.BREAD_FOODS)))
						.unlockedByItems(getHasName(Items.WATER_BUCKET), Items.WATER_BUCKET)
						.unlockedByItems(getHasName(Items.WHEAT), Items.WHEAT)
						.unlockedByItems(getHasName(Items.EGG), Items.EGG, Items.BROWN_EGG, Items.BLUE_EGG)
						.unlockedByItems(getHasName(Items.BREAD), Items.BREAD)
						.setRecipeBookCategory(CookingPotBookCategory.MISC)
						.build(recipeExporter, SDItems.CROQUETTES + "_from_pot");

				CookingPotRecipeBuilder.cookingPotRecipe(BuiltInRegistries.ITEM, SDItems.PAELLA, 1, SLOW_COOKING, LARGE_EXP, Items.BOWL)
						.addIngredient(Items.RABBIT)
						.addIngredient(vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get())
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(CommonTags.Items.CROPS_RICE)))
						.addIngredient(SDItems.PAPRIKA)
						.addIngredient(SDItems.GREEN_BEAN)
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(SDTags.Items.GARLIC)))
						.unlockedByItems(getHasName(Items.RABBIT), Items.RABBIT)
						.unlockedByItems(getHasName(vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get()), vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get())
						.unlockedByItems(getHasName(vectorwing.farmersdelight.common.registry.ModItems.RICE.get()), vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
						.unlockedByItems(getHasName(SDItems.PAPRIKA), SDItems.PAPRIKA)
						.unlockedByItems(getHasName(SDItems.GREEN_BEAN), SDItems.GREEN_BEAN)
						.unlockedByItems(getHasName(SDItems.GARLIC), SDItems.GARLIC)
						.setRecipeBookCategory(CookingPotBookCategory.MEALS)
						.build(recipeExporter, SDItems.PAELLA + "_from_pot");

				CookingPotRecipeBuilder.cookingPotRecipe(BuiltInRegistries.ITEM, SDItems.PIL_PIL_COD, 1, SLOW_COOKING, LARGE_EXP, Items.BOWL)
						.addIngredient(SDItems.GREEN_PEPPER)
						.addIngredient(Items.COD)
						.addIngredient(SDItems.SLICED_POTATO)
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(SDTags.Items.GARLIC)))
						.unlockedByItems(getHasName(SDItems.GREEN_PEPPER), SDItems.GREEN_PEPPER)
						.unlockedByItems(getHasName(Items.COD), Items.COD)
						.unlockedByItems(getHasName(SDItems.SLICED_POTATO), SDItems.SLICED_POTATO)
						.unlockedByItems(getHasName(SDItems.GARLIC), SDItems.GARLIC)
						.setRecipeBookCategory(CookingPotBookCategory.MEALS)
						.build(recipeExporter, SDItems.PIL_PIL_COD + "_from_pot");

				CookingPotRecipeBuilder.cookingPotRecipe(BuiltInRegistries.ITEM, SDItems.SPANISH_TORTILLA, 1, NORMAL_COOKING, LARGE_EXP)
						.addIngredient(SDItems.SLICED_POTATO)
						.addIngredient(SDItems.SLICED_ONION)
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
						.addIngredient(Ingredient.of(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
						.unlockedByItems(getHasName(SDItems.SLICED_POTATO), SDItems.SLICED_POTATO)
						.unlockedByItems(getHasName(SDItems.SLICED_ONION), SDItems.SLICED_ONION)
						.unlockedByItems(getHasName(Items.EGG), Items.EGG, Items.BROWN_EGG, Items.BLUE_EGG)
						.setRecipeBookCategory(CookingPotBookCategory.MEALS)
						.build(recipeExporter, SDItems.SPANISH_TORTILLA + "_from_pot");

				CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(vectorwing.farmersdelight.common.registry.ModItems.ONION.get()), Ingredient.of(itemLookup.getOrThrow(CommonTags.Items.TOOLS_KNIFE)), SDItems.SLICED_ONION, 3)
						.build(recipeExporter, SDItems.SLICED_ONION + "_from_board");
				CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(Items.POTATO), Ingredient.of(itemLookup.getOrThrow(CommonTags.Items.TOOLS_KNIFE)), SDItems.SLICED_POTATO, 3)
						.build(recipeExporter, SDItems.SLICED_POTATO + "_from_board");
				CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(SDItems.RED_PEPPER), Ingredient.of(itemLookup.getOrThrow(CommonTags.Items.TOOLS_KNIFE)), SDItems.PAPRIKA, 3)
						.build(recipeExporter, SDItems.PAPRIKA + "_from_board");
			}
		};
	}

	@Override
	public String getName() {
		return "Spanish Delight Refabricated";
	}
}
