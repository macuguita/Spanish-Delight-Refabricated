package io.github.macuguita.datagen;

import io.github.macuguita.item.ModItems;
import io.github.macuguita.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.recipe.v1.ingredient.DefaultCustomIngredients;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import vectorwing.farmersdelight.common.crafting.CookingPotBookCategory;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        final RegistryEntryLookup<Item> itemLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                ShapelessRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.FOOD, ModItems.GAZPACHO)
                        .input(Ingredient.fromTag(itemLookup.getOrThrow(CommonTags.CROPS_TOMATO)))
                        .input(Ingredient.fromTag(itemLookup.getOrThrow(ModTags.Items.GARLIC)))
                        .input(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WATER_BUCKETS)))
                        .input(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.BREAD_FOODS)))
                        .input(Items.BOWL)
                        .criterion(hasItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()), conditionsFromItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()))
                        .criterion(hasItem(ModItems.GARLIC), conditionsFromItem(ModItems.GARLIC))
                        .offerTo(recipeExporter);
                ShapelessRecipeJsonBuilder.create(Registries.ITEM, RecipeCategory.FOOD, ModItems.PANTUMACA)
                        .input(Ingredient.fromTag(itemLookup.getOrThrow(CommonTags.CROPS_TOMATO)))
                        .input(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.BREAD_FOODS)))
                        .criterion(hasItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()), conditionsFromItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()))
                        .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                        .offerTo(recipeExporter);

                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.SQUID_RING), RecipeCategory.FOOD, ModItems.FRIED_SQUID_RING, 0.35F, 200)
                        .criterion(hasItem(ModItems.SQUID_RING), conditionsFromItem(ModItems.SQUID_RING))
                        .offerTo(recipeExporter);
                CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(ModItems.SQUID_RING), RecipeCategory.FOOD, ModItems.FRIED_SQUID_RING, 0.35F, 200*3)
                        .criterion(hasItem(ModItems.SQUID_RING), conditionsFromItem(ModItems.SQUID_RING))
                        .offerTo(recipeExporter, ModItems.FRIED_SQUID_RING + "_from_campfire");
                CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.SQUID_RING), RecipeCategory.FOOD, ModItems.FRIED_SQUID_RING, 0.35F, 200/2)
                        .criterion(hasItem(ModItems.SQUID_RING), conditionsFromItem(ModItems.SQUID_RING))
                        .offerTo(recipeExporter, ModItems.FRIED_SQUID_RING + "_from_smoker");

                CookingPotRecipeBuilder.cookingPotRecipe(Registries.ITEM, ModItems.BRAVA_POTATOES, 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                        .addIngredient(ModItems.SLICED_POTATO)
                        .addIngredient(ModItems.SLICED_POTATO)
                        .addIngredient(ModItems.PAPRIKA)
                        .unlockedByItems(hasItem(ModItems.SLICED_POTATO), ModItems.SLICED_POTATO)
                        .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                        .build(recipeExporter);

                CookingPotRecipeBuilder.cookingPotRecipe(Registries.ITEM, ModItems.CHURRO, 3, NORMAL_COOKING, MEDIUM_EXP)
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WHEAT_CROPS)))
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
                        .addIngredient(Items.SUGAR)
                        .addIngredient(DefaultCustomIngredients.any(
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WATER_BUCKETS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WATER_DRINKS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WATERY_DRINKS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.MILK_BUCKETS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.MILK_DRINKS))
                        ))
                        .unlockedByItems(hasItem(Items.WHEAT), Items.WHEAT)
                        .unlockedByItems(hasItem(Items.EGG), Items.EGG, Items.BROWN_EGG, Items.BLUE_EGG)
                        .unlockedByItems(hasItem(Items.SUGAR), Items.SUGAR)
                        .unlockedByItems(hasItem(Items.WATER_BUCKET), Items.WATER_BUCKET)
                        .setRecipeBookCategory(CookingPotBookCategory.MISC)
                        .build(recipeExporter);

                CookingPotRecipeBuilder.cookingPotRecipe(Registries.ITEM, ModItems.CROQUETTES, 1, NORMAL_COOKING, MEDIUM_EXP)
                        .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.HAM.get())
                        .addIngredient(DefaultCustomIngredients.any(
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WATER_BUCKETS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WATER_DRINKS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WATERY_DRINKS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.MILK_BUCKETS)),
                                Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.MILK_DRINKS))
                        ))
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.WHEAT_CROPS)))
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.BREAD_FOODS)))
                        .unlockedByItems(hasItem(Items.WATER_BUCKET), Items.WATER_BUCKET)
                        .unlockedByItems(hasItem(Items.WHEAT), Items.WHEAT)
                        .unlockedByItems(hasItem(Items.EGG), Items.EGG, Items.BROWN_EGG, Items.BLUE_EGG)
                        .unlockedByItems(hasItem(Items.BREAD), Items.BREAD)
                        .setRecipeBookCategory(CookingPotBookCategory.MISC)
                        .build(recipeExporter);

                CookingPotRecipeBuilder.cookingPotRecipe(Registries.ITEM, ModItems.PAELLA, 1, SLOW_COOKING, LARGE_EXP, Items.BOWL)
                        .addIngredient(Items.RABBIT)
                        .addIngredient(vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get())
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(CommonTags.CROPS_RICE)))
                        .addIngredient(ModItems.PAPRIKA)
                        .addIngredient(ModItems.GREEN_BEAN)
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ModTags.Items.GARLIC)))
                        .unlockedByItems(hasItem(Items.RABBIT), Items.RABBIT)
                        .unlockedByItems(hasItem(vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get()), vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get())
                        .unlockedByItems(hasItem(vectorwing.farmersdelight.common.registry.ModItems.RICE.get()), vectorwing.farmersdelight.common.registry.ModItems.RICE.get())
                        .unlockedByItems(hasItem(ModItems.PAPRIKA), ModItems.PAPRIKA)
                        .unlockedByItems(hasItem(ModItems.GREEN_BEAN), ModItems.GREEN_BEAN)
                        .unlockedByItems(hasItem(ModItems.GARLIC), ModItems.GARLIC)
                        .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                        .build(recipeExporter);

                CookingPotRecipeBuilder.cookingPotRecipe(Registries.ITEM, ModItems.PIL_PIL_COD, 1, SLOW_COOKING, LARGE_EXP, Items.BOWL)
                        .addIngredient(ModItems.GREEN_PEPPER)
                        .addIngredient(Items.COD)
                        .addIngredient(ModItems.SLICED_POTATO)
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ModTags.Items.GARLIC)))
                        .unlockedByItems(hasItem(ModItems.GREEN_PEPPER), ModItems.GREEN_PEPPER)
                        .unlockedByItems(hasItem(Items.COD), Items.COD)
                        .unlockedByItems(hasItem(ModItems.SLICED_POTATO), ModItems.SLICED_POTATO)
                        .unlockedByItems(hasItem(ModItems.GARLIC), ModItems.GARLIC)
                        .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                        .build(recipeExporter);

                CookingPotRecipeBuilder.cookingPotRecipe(Registries.ITEM, ModItems.SPANISH_TORTILLA, 1, NORMAL_COOKING, LARGE_EXP)
                        .addIngredient(ModItems.SLICED_POTATO)
                        .addIngredient(ModItems.SLICED_ONION)
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
                        .addIngredient(Ingredient.fromTag(itemLookup.getOrThrow(ConventionalItemTags.EGGS)))
                        .unlockedByItems(hasItem(ModItems.SLICED_POTATO), ModItems.SLICED_POTATO)
                        .unlockedByItems(hasItem(ModItems.SLICED_ONION), ModItems.SLICED_ONION)
                        .unlockedByItems(hasItem(Items.EGG), Items.EGG, Items.BROWN_EGG, Items.BLUE_EGG)
                        .setRecipeBookCategory(CookingPotBookCategory.MEALS)
                        .build(recipeExporter);

                CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.ofItems(vectorwing.farmersdelight.common.registry.ModItems.ONION.get()), Ingredient.fromTag(itemLookup.getOrThrow(CommonTags.TOOLS_KNIFE)), ModItems.SLICED_ONION, 3)
                        .build(recipeExporter);
                CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.ofItems(Items.POTATO), Ingredient.fromTag(itemLookup.getOrThrow(CommonTags.TOOLS_KNIFE)), ModItems.SLICED_POTATO, 3)
                        .build(recipeExporter);
                CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.ofItems(ModItems.RED_PEPPER), Ingredient.fromTag(itemLookup.getOrThrow(CommonTags.TOOLS_KNIFE)), ModItems.PAPRIKA, 3)
                        .build(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Spanish Delight Refabricated";
    }
}
