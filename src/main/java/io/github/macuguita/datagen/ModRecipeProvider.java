package io.github.macuguita.datagen;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> consumer) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GAZPACHO)
                .input(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .input(ModItems.GARLIC)
                .input(Items.WATER_BUCKET)
                .input(Items.BREAD)
                .input(Items.BOWL)
                .criterion(hasItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()), conditionsFromItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()))
                .criterion(hasItem(ModItems.GARLIC), conditionsFromItem(ModItems.GARLIC))
                .offerTo(consumer);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.PANTUMACA)
                .input(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get())
                .input(Items.BREAD)
                .criterion(hasItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()), conditionsFromItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get()))
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(consumer);

        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(ModItems.SQUID_RING), RecipeCategory.FOOD, ModItems.FRIED_SQUID_RING, 0.35F, 200)
                .criterion(hasItem(ModItems.SQUID_RING), conditionsFromItem(ModItems.SQUID_RING))
                .offerTo(consumer);
        CookingRecipeJsonBuilder.createCampfireCooking(Ingredient.ofItems(ModItems.SQUID_RING), RecipeCategory.FOOD, ModItems.FRIED_SQUID_RING, 0.35F, 200)
                .criterion(hasItem(ModItems.SQUID_RING), conditionsFromItem(ModItems.SQUID_RING))
                .offerTo(consumer, new Identifier(SpanishDelightRefabricated.MOD_ID, ModItems.FRIED_SQUID_RING + "_from_campfire"));
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.SQUID_RING), RecipeCategory.FOOD, ModItems.FRIED_SQUID_RING, 0.35F, 200)
                .criterion(hasItem(ModItems.SQUID_RING), conditionsFromItem(ModItems.SQUID_RING))
                .offerTo(consumer, new Identifier(SpanishDelightRefabricated.MOD_ID, ModItems.FRIED_SQUID_RING + "_from_smoker"));
    }
}
