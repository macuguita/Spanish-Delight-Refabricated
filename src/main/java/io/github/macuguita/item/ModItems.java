package io.github.macuguita.item;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.block.ModBlocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class ModItems {

    public static Item.Settings bowlFoodItem(FoodComponent food) {
        return new Item.Settings().food(food).recipeRemainder(Items.BOWL).maxCount(16);
    }

    public static Item PAPRIKA = registerItem("paprika", new Item(new Item.Settings()));
    public static Item SLICED_POTATO = registerItem("sliced_potato", new Item(new Item.Settings().food(ModFoodComponents.SLICED_POTATO)));
    public static Item SLICED_ONION = registerItem("sliced_onion", new Item(new Item.Settings().food(ModFoodComponents.SLICED_ONION)));
    public static Item GARLIC = registerItem("garlic", new Item(new Item.Settings().food(ModFoodComponents.GARLIC)));
    public static Item GREEN_BEAN = registerItem("green_bean", new AliasedBlockItem(ModBlocks.GREEN_BEAN_CROP, new Item.Settings().food(ModFoodComponents.GREEN_BEAN)));
    public static Item RED_PEPPER = registerItem("red_pepper", new Item(new Item.Settings().food(ModFoodComponents.PEPPER)));
    public static Item GREEN_PEPPER = registerItem("green_pepper", new Item(new Item.Settings().food(ModFoodComponents.PEPPER)));
    public static Item SQUID_RING = registerItem("squid_ring", new Item(new Item.Settings().food(ModFoodComponents.SQUID_RING)));
    public static Item SPANISH_TORTILLA = registerItem("spanish_tortilla", new ConsumableItem(new Item.Settings().food(ModFoodComponents.SPANISH_TORTILLA), true));
    public static Item PAELLA = registerItem("paella", new ConsumableItem(bowlFoodItem(ModFoodComponents.PAELLA), true));
    public static Item PIL_PIL_COD = registerItem("pil_pil_cod", new ConsumableItem(bowlFoodItem(ModFoodComponents.PIL_PIL_COD), true));
    public static Item CROQUETTES = registerItem("croquettes", new ConsumableItem(new Item.Settings().food(ModFoodComponents.CROQUETTES), true));
    public static Item BRAVA_POTATOES = registerItem("brava_potatoes", new ConsumableItem(bowlFoodItem(ModFoodComponents.BRAVA_POTATOES), true));
    public static Item CHURRO = registerItem("churro", new ConsumableItem(new Item.Settings().food(ModFoodComponents.CHURRO), true));
    public static Item GAZPACHO = registerItem("gazpacho", new ConsumableItem(bowlFoodItem(ModFoodComponents.GAZPACHO), true));
    public static Item PANTUMACA = registerItem("pantumaca", new ConsumableItem(new Item.Settings().food(ModFoodComponents.PANTUMACA), true));
    public static Item FRIED_SQUID_RING = registerItem("fried_squid_ring", new ConsumableItem(new Item.Settings().food(ModFoodComponents.FRIED_SQUID_RING), true));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(SpanishDelightRefabricated.MOD_ID, name), item);
    }

    public static void registerModItems() {
        SpanishDelightRefabricated.LOGGER.info("Registering Mod Items for " + SpanishDelightRefabricated.MOD_ID);
    }
}
