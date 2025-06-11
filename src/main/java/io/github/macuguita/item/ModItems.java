package io.github.macuguita.item;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.function.Function;

public class ModItems {

    private static Item.Settings bowlFoodItem(FoodComponent food, ConsumableComponent component) {
        return new Item.Settings()
                .food(food, component)
                .recipeRemainder(Items.BOWL)
                .maxCount(1);
    }

    public static final Item PAPRIKA = registerItem("paprika", Item::new, new Item.Settings());
    public static final Item SLICED_POTATO = registerItem("sliced_potato", Item::new, new Item.Settings().food(ModFoodComponents.SLICED_POTATO));
    public static final Item SLICED_ONION = registerItem("sliced_onion", Item::new, new Item.Settings().food(ModFoodComponents.SLICED_ONION));
    public static final Item GARLIC = registerItem("garlic", Item::new, new Item.Settings().food(ModFoodComponents.GARLIC));
    public static final Item GREEN_BEAN = registerItem("green_bean", createBlockItemWithUniqueName(ModBlocks.GREEN_BEAN_CROP), new Item.Settings().food(ModFoodComponents.GREEN_BEAN));
    public static final Item RED_PEPPER = registerItem("red_pepper", Item::new, new Item.Settings().food(ModFoodComponents.PEPPER));
    public static final Item GREEN_PEPPER = registerItem("green_pepper", Item::new, new Item.Settings().food(ModFoodComponents.PEPPER));
    public static final Item SQUID_RING = registerItem("squid_ring", Item::new, new Item.Settings().food(ModFoodComponents.SQUID_RING));

    public static final Item SPANISH_TORTILLA = registerItem("spanish_tortilla",
            settings -> new ConsumableItem(settings, true),
            new Item.Settings().food(ModFoodComponents.SPANISH_TORTILLA, ModConsumableComponents.SPANISH_TORTILLA));

    public static final Item PAELLA = registerItem("paella",
            settings -> new ConsumableItem(settings, true),
            bowlFoodItem(ModFoodComponents.PAELLA, ModConsumableComponents.PAELLA));

    public static final Item PIL_PIL_COD = registerItem("pil_pil_cod",
            settings -> new ConsumableItem(settings, true),
            bowlFoodItem(ModFoodComponents.PIL_PIL_COD, ModConsumableComponents.PIL_PIL_COD));

    public static final Item CROQUETTES = registerItem("croquettes",
            settings -> new ConsumableItem(settings, true),
            new Item.Settings().food(ModFoodComponents.CROQUETTES, ModConsumableComponents.CROQUETTES));

    public static final Item BRAVA_POTATOES = registerItem("brava_potatoes",
            settings -> new ConsumableItem(settings, true),
            bowlFoodItem(ModFoodComponents.BRAVA_POTATOES, ModConsumableComponents.BRAVA_POTATOES));

    public static final Item CHURRO = registerItem("churro",
            settings -> new ConsumableItem(settings, true),
            new Item.Settings().food(ModFoodComponents.CHURRO, ModConsumableComponents.CHURRO));

    public static final Item GAZPACHO = registerItem("gazpacho",
            settings -> new ConsumableItem(settings, true),
            bowlFoodItem(ModFoodComponents.GAZPACHO, ModConsumableComponents.GAZPACHO));

    public static final Item PANTUMACA = registerItem("pantumaca",
            settings -> new ConsumableItem(settings, true),
            new Item.Settings().food(ModFoodComponents.PANTUMACA, ModConsumableComponents.PANTUMACA));

    public static final Item FRIED_SQUID_RING = registerItem("fried_squid_ring",
            settings -> new ConsumableItem(settings, true),
            new Item.Settings().food(ModFoodComponents.FRIED_SQUID_RING, ModConsumableComponents.FRIED_SQUID_RING));

    public static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SpanishDelightRefabricated.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    public static void registerModItems() {
        SpanishDelightRefabricated.LOGGER.info("Registering Mod Items for " + SpanishDelightRefabricated.MOD_ID);
    }
}
