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

package com.macuguita.spanishdelight.reg;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;

import com.macuguita.spanishdelight.reg.id.SDBlockItemIds;
import com.macuguita.spanishdelight.reg.id.SDItemIds;

import net.minecraft.references.BlockItemId;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.SpawnEggItem;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import vectorwing.farmersdelight.common.block.WildCropBlock;
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

import vectorwing.farmersdelight.common.registry.ModItems;

public final class SDItems {

	public static final Item PAPRIKA = registerItem(SDItemIds.PAPRIKA, Item::new, new Item.Properties());
	public static final Item SLICED_POTATO = registerItem(SDItemIds.SLICED_POTATO, Item::new, new Item.Properties().food(SDFoodComponents.SLICED_POTATO));
	public static final Item SLICED_ONION = registerItem(SDItemIds.SLICED_ONION, Item::new, new Item.Properties().food(SDFoodComponents.SLICED_ONION));
	public static final Item GARLIC = registerItem(SDItemIds.GARLIC, Item::new, new Item.Properties().food(SDFoodComponents.GARLIC));
	public static final Item GREEN_BEAN = registerItem(SDBlockItemIds.GREEN_BEAN, createBlockItemWithCustomItemName(SDBlocks.GREEN_BEAN_CROP), new Item.Properties().food(SDFoodComponents.GREEN_BEAN));
	public static final Item RED_PEPPER = registerItem(SDItemIds.RED_PEPPER, Item::new, new Item.Properties().food(SDFoodComponents.PEPPER));
	public static final Item GREEN_PEPPER = registerItem(SDItemIds.GREEN_PEPPER, Item::new, new Item.Properties().food(SDFoodComponents.PEPPER));
	public static final Item SQUID_RING = registerItem(SDItemIds.SQUID_RING, Item::new, new Item.Properties().food(SDFoodComponents.SQUID_RING));

	public static final Item SPANISH_TORTILLA = registerItem(SDItemIds.SPANISH_TORTILLA,
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(SDFoodComponents.SPANISH_TORTILLA, SDConsumableComponents.SPANISH_TORTILLA));
	public static final Item PAELLA = registerItem(SDItemIds.PAELLA,
			settings -> new ConsumableItem(settings, true),
			ModItems.bowlFoodItem(SDFoodComponents.PAELLA, SDConsumableComponents.PAELLA));
	public static final Item PIL_PIL_COD = registerItem(SDItemIds.PIL_PIL_COD,
			settings -> new ConsumableItem(settings, true),
			ModItems.bowlFoodItem(SDFoodComponents.PIL_PIL_COD, SDConsumableComponents.PIL_PIL_COD));
	public static final Item CROQUETTES = registerItem(SDItemIds.CROQUETTES,
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(SDFoodComponents.CROQUETTES, SDConsumableComponents.CROQUETTES));
	public static final Item BRAVA_POTATOES = registerItem(SDItemIds.BRAVA_POTATOES,
			settings -> new ConsumableItem(settings, true),
			ModItems.bowlFoodItem(SDFoodComponents.BRAVA_POTATOES, SDConsumableComponents.BRAVA_POTATOES));
	public static final Item CHURRO = registerItem(SDItemIds.CHURRO,
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(SDFoodComponents.CHURRO, SDConsumableComponents.CHURRO));
	public static final Item GAZPACHO = registerItem(SDItemIds.GAZPACHO,
			settings -> new ConsumableItem(settings, true),
			ModItems.bowlFoodItem(SDFoodComponents.GAZPACHO, SDConsumableComponents.GAZPACHO));
	public static final Item PANTUMACA = registerItem(SDItemIds.PANTUMACA,
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(SDFoodComponents.PANTUMACA, SDConsumableComponents.PANTUMACA));
	public static final Item FRIED_SQUID_RING = registerItem(SDItemIds.FRIED_SQUID_RING,
			settings -> new ConsumableItem(settings, true),
			new Item.Properties().food(SDFoodComponents.FRIED_SQUID_RING, SDConsumableComponents.FRIED_SQUID_RING));

	public static Item WILD_GARLIC = registerBlock(SDBlockItemIds.WILD_GARLIC, SDBlocks.WILD_GARLIC);
	public static Item WILD_RED_PEPPER = registerBlock(SDBlockItemIds.WILD_RED_PEPPER, SDBlocks.WILD_RED_PEPPER);
	public static Item WILD_GREEN_PEPPER = registerBlock(SDBlockItemIds.WILD_GREEN_PEPPER, SDBlocks.WILD_GREEN_PEPPER);

	private SDItems() {}

	private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(final Block block) {
		return (p) -> new BlockItem(block, p.useItemDescriptionPrefix());
	}

	private static Item registerBlock(final BlockItemId id, final Block block) {
		return registerBlock(id, block, BlockItem::new);
	}

	private static Item registerBlock(final BlockItemId id, final Block block, final Item.Properties properties) {
		return registerBlock(id, block, BlockItem::new, properties);
	}

	private static Item registerBlock(final BlockItemId id, final Block block, final UnaryOperator<Item.Properties> propertiesFunction) {
		return registerBlock(id, block, (b, p) -> new BlockItem(b, propertiesFunction.apply(p)));
	}

	private static Item registerBlock(final BlockItemId id, final Block block, final Block... alternatives) {
		Item item = registerBlock(id, block);

		for(Block alternative : alternatives) {
			Item.BY_BLOCK.put(alternative, item);
		}

		return item;
	}

	private static Item registerBlock(final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory) {
		return registerBlock(id, block, itemFactory, new Item.Properties());
	}

	private static Item registerBlock(final BlockItemId id, final Block block, final BiFunction<Block, Item.Properties, Item> itemFactory, final Item.Properties properties) {
		return registerItem(id.item(), (p) -> (Item)itemFactory.apply(block, p), properties.useBlockDescriptionPrefix().requiredFeatures(block.requiredFeatures()));
	}

	private static Item registerItem(final ResourceKey<Item> id, final Item.Properties properties) {
		return registerItem(id, Item::new, properties);
	}

	private static Item registerItem(final ResourceKey<Item> id) {
		return registerItem(id, Item::new, new Item.Properties());
	}

	private static Item registerItem(final BlockItemId id, final Function<Item.Properties, Item> itemFactory) {
		return registerItem(id.item(), itemFactory);
	}

	private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory) {
		return registerItem(id, itemFactory, new Item.Properties());
	}

	private static Item registerItem(final BlockItemId id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
		return registerItem(id.item(), itemFactory, properties);
	}

	private static Item registerItem(final ResourceKey<Item> id, final Function<Item.Properties, Item> itemFactory, final Item.Properties properties) {
		Item item = itemFactory.apply(properties.setId(id));
		if (item instanceof BlockItem blockItem) {
			blockItem.registerBlocks(Item.BY_BLOCK, item);
		}

		return Registry.register(BuiltInRegistries.ITEM, id, item);
	}

	public static void registerModItems() {
		SpanishDelightRefabricated.LOGGER.info("Registering Mod Items for " + SpanishDelightRefabricated.MOD_ID);
	}
}
