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

package com.macuguita.spanishdelight.item;

import java.util.function.Function;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;
import com.macuguita.spanishdelight.block.ModBlocks;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.level.block.Block;

public class ModItems {

	public static final Item PAPRIKA = registerItem("paprika", Item::new, new Item.Properties());
	public static final Item SLICED_POTATO = registerItem("sliced_potato", Item::new, new Item.Properties().food(ModFoodComponents.SLICED_POTATO));
	public static final Item SLICED_ONION = registerItem("sliced_onion", Item::new, new Item.Properties().food(ModFoodComponents.SLICED_ONION));
	public static final Item GARLIC = registerItem("garlic", Item::new, new Item.Properties().food(ModFoodComponents.GARLIC));
	public static final Item GREEN_BEAN = registerItem("green_bean", createBlockItemWithUniqueName(ModBlocks.GREEN_BEAN_CROP), new Item.Properties().food(ModFoodComponents.GREEN_BEAN));
	public static final Item RED_PEPPER = registerItem("red_pepper", Item::new, new Item.Properties().food(ModFoodComponents.PEPPER));
	public static final Item GREEN_PEPPER = registerItem("green_pepper", Item::new, new Item.Properties().food(ModFoodComponents.PEPPER));
	public static final Item SQUID_RING = registerItem("squid_ring", Item::new, new Item.Properties().food(ModFoodComponents.SQUID_RING));

	public static final Item SPANISH_TORTILLA = registerItem("spanish_tortilla",
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(ModFoodComponents.SPANISH_TORTILLA, ModConsumableComponents.SPANISH_TORTILLA));
	public static final Item PAELLA = registerItem("paella",
			settings -> new ConsumableItem(settings, true),
			bowlFoodItem(ModFoodComponents.PAELLA, ModConsumableComponents.PAELLA));
	public static final Item PIL_PIL_COD = registerItem("pil_pil_cod",
			settings -> new ConsumableItem(settings, true),
			bowlFoodItem(ModFoodComponents.PIL_PIL_COD, ModConsumableComponents.PIL_PIL_COD));
	public static final Item CROQUETTES = registerItem("croquettes",
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(ModFoodComponents.CROQUETTES, ModConsumableComponents.CROQUETTES));
	public static final Item BRAVA_POTATOES = registerItem("brava_potatoes",
			settings -> new ConsumableItem(settings, true),
			bowlFoodItem(ModFoodComponents.BRAVA_POTATOES, ModConsumableComponents.BRAVA_POTATOES));
	public static final Item CHURRO = registerItem("churro",
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(ModFoodComponents.CHURRO, ModConsumableComponents.CHURRO));
	public static final Item GAZPACHO = registerItem("gazpacho",
			settings -> new ConsumableItem(settings, true),
			bowlFoodItem(ModFoodComponents.GAZPACHO, ModConsumableComponents.GAZPACHO));
	public static final Item PANTUMACA = registerItem("pantumaca",
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(ModFoodComponents.PANTUMACA, ModConsumableComponents.PANTUMACA));
	public static final Item FRIED_SQUID_RING = registerItem("fried_squid_ring",
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(ModFoodComponents.FRIED_SQUID_RING, ModConsumableComponents.FRIED_SQUID_RING));

	private static Item.Properties bowlFoodItem(FoodProperties food, Consumable component) {
		return new Item.Properties()
				.food(food, component)
				.craftRemainder(Items.BOWL)
				.stacksTo(1);
	}

	private static Item registerItem(String name, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, name));

		Item item = itemFactory.apply(settings.setId(itemKey));

		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}

	private static Function<Item.Properties, Item> createBlockItemWithUniqueName(Block block) {
		return settings -> new BlockItem(block, settings.useItemDescriptionPrefix());
	}

	public static void registerModItems() {
		SpanishDelightRefabricated.LOGGER.info("Registering Mod Items for " + SpanishDelightRefabricated.MOD_ID);
	}
}
