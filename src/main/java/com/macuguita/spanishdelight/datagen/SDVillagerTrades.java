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

package com.macuguita.spanishdelight.datagen;

import java.util.List;
import java.util.Optional;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;
import com.macuguita.spanishdelight.reg.SDItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.item.trading.VillagerTrades;

public class SDVillagerTrades {

	public static final ResourceKey<VillagerTrade> FARMER_1_EMERALD_GREEN_BEAM = resourceKey("farmer/1/emerald_green_bean");

	public static final ResourceKey<VillagerTrade> FARMER_2_TOMATO_GARLIC = resourceKey("farmer/2/tomato_garlic");
	public static final ResourceKey<VillagerTrade> FARMER_2_SLICED_POTATO_RED_PEPPER = resourceKey("farmer/2/sliced_potato_red_pepper");
	public static final ResourceKey<VillagerTrade> FARMER_2_RICE_GREEN_PEPPER = resourceKey("farmer/2/rice_green_pepper");

	public static final ResourceKey<VillagerTrade> FARMER_3_GAZPACHO_GARLIC = resourceKey("farmer/3/gazpacho_garlic");
	public static final ResourceKey<VillagerTrade> FARMER_3_BRAVA_POTATOES_RED_PEPPER = resourceKey("farmer/3/brava_potatoes_red_pepper");
	public static final ResourceKey<VillagerTrade> FARMER_3_PIL_PIL_COD_RED_PEPPER = resourceKey("farmer/3/pil_pil_cod_red_pepper");

	public static final ResourceKey<VillagerTrade> FARMER_4_EMERALD_GARLIC = resourceKey("farmer/4/emerald_garlic");
	public static final ResourceKey<VillagerTrade> FARMER_4_EMERALD_RED_PEPPER = resourceKey("farmer/4/emerald_red_pepper");
	public static final ResourceKey<VillagerTrade> FARMER_4_EMERALD_GREEN_PEPPER = resourceKey("farmer/4/emerald_green_pepper");

	public static final ResourceKey<VillagerTrade> FARMER_5_EMERALD_GARLIC = resourceKey("farmer/5/emerald_garlic");
	public static final ResourceKey<VillagerTrade> FARMER_5_EMERALD_RED_PEPPER = resourceKey("farmer/5/emerald_red_pepper");
	public static final ResourceKey<VillagerTrade> FARMER_5_EMERALD_GREEN_PEPPER = resourceKey("farmer/5/emerald_green_pepper");

	public static final ResourceKey<VillagerTrade> WANDERING_GARLIC_DIAMOND_KNIFE = resourceKey("wandering_trader/garlic_diamond_knife");
	public static final ResourceKey<VillagerTrade> WANDERING_RED_PEPPER_DIAMOND_KNIFE = resourceKey("wandering_trader/red_pepper_diamond_knife");
	public static final ResourceKey<VillagerTrade> WANDERING_GREEN_PEPPER_DIAMOND_KNIFE = resourceKey("wandering_trader/green_pepper_diamond_knife");

	public static void bootstrap(final BootstrapContext<VillagerTrade> context) {
		// FARMER 1
		VillagerTrades.register(context, FARMER_1_EMERALD_GREEN_BEAM,
				new VillagerTrade(
						new TradeCost(Items.EMERALD, 1),
						new ItemStackTemplate(SDItems.GREEN_BEAN, 10),
						10, 8, 0.02F, Optional.empty(), List.of()
				)
		);

		// FARMER 2
		VillagerTrades.register(context, FARMER_2_TOMATO_GARLIC,
				new VillagerTrade(
						new TradeCost(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get(), 15),
						new ItemStackTemplate(SDItems.GARLIC, 5),
						8, 8, 0.02F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_2_SLICED_POTATO_RED_PEPPER,
				new VillagerTrade(
						new TradeCost(SDItems.SLICED_POTATO, 24),
						new ItemStackTemplate(SDItems.RED_PEPPER, 3),
						8, 8, 0.02F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_2_RICE_GREEN_PEPPER,
				new VillagerTrade(
						new TradeCost(vectorwing.farmersdelight.common.registry.ModItems.RICE.get(), 27),
						new ItemStackTemplate(SDItems.GREEN_PEPPER, 9),
						8, 8, 0.02F, Optional.empty(), List.of()
				)
		);

		// FARMER 3
		VillagerTrades.register(context, FARMER_3_GAZPACHO_GARLIC,
				new VillagerTrade(
						new TradeCost(SDItems.GAZPACHO, 1),
						new ItemStackTemplate(SDItems.GARLIC, 20),
						10, 8, 0.02F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_3_BRAVA_POTATOES_RED_PEPPER,
				new VillagerTrade(
						new TradeCost(SDItems.BRAVA_POTATOES, 1),
						new ItemStackTemplate(SDItems.RED_PEPPER, 20),
						10, 8, 0.02F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_3_PIL_PIL_COD_RED_PEPPER,
				new VillagerTrade(
						new TradeCost(SDItems.PIL_PIL_COD, 1),
						new ItemStackTemplate(SDItems.RED_PEPPER, 20),
						10, 8, 0.02F, Optional.empty(), List.of()
				)
		);

		// FARMER 4
		VillagerTrades.register(context, FARMER_4_EMERALD_GARLIC,
				new VillagerTrade(
						new TradeCost(Items.EMERALD, 1),
						new ItemStackTemplate(SDItems.GARLIC, 34),
						6, 10, 0.15F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_4_EMERALD_RED_PEPPER,
				new VillagerTrade(
						new TradeCost(Items.EMERALD, 1),
						new ItemStackTemplate(SDItems.RED_PEPPER, 34),
						6, 10, 0.15F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_4_EMERALD_GREEN_PEPPER,
				new VillagerTrade(
						new TradeCost(Items.EMERALD, 1),
						new ItemStackTemplate(SDItems.GREEN_PEPPER, 34),
						6, 10, 0.15F, Optional.empty(), List.of()
				)
		);

		// FARMER 5
		VillagerTrades.register(context, FARMER_5_EMERALD_GARLIC,
				new VillagerTrade(
						new TradeCost(Items.EMERALD, 6),
						new ItemStackTemplate(SDItems.GARLIC, 64),
						1, 15, 0.02F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_5_EMERALD_RED_PEPPER,
				new VillagerTrade(
						new TradeCost(Items.EMERALD, 6),
						new ItemStackTemplate(SDItems.RED_PEPPER, 64),
						1, 15, 0.02F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, FARMER_5_EMERALD_GREEN_PEPPER,
				new VillagerTrade(
						new TradeCost(Items.EMERALD, 6),
						new ItemStackTemplate(SDItems.GREEN_PEPPER, 64),
						1, 15, 0.02F, Optional.empty(), List.of()
				)
		);

		// WANDERING TRADER
		VillagerTrades.register(context, WANDERING_GARLIC_DIAMOND_KNIFE,
				new VillagerTrade(
						new TradeCost(SDItems.GARLIC, 64),
						new ItemStackTemplate(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
						1, 12, 0.15F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, WANDERING_RED_PEPPER_DIAMOND_KNIFE,
				new VillagerTrade(
						new TradeCost(SDItems.RED_PEPPER, 64),
						new ItemStackTemplate(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
						1, 12, 0.15F, Optional.empty(), List.of()
				)
		);

		VillagerTrades.register(context, WANDERING_GREEN_PEPPER_DIAMOND_KNIFE,
				new VillagerTrade(
						new TradeCost(SDItems.GREEN_PEPPER, 64),
						new ItemStackTemplate(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
						1, 12, 0.15F, Optional.empty(), List.of()
				)
		);
	}

	public static ResourceKey<VillagerTrade> resourceKey(final String path) {
		return ResourceKey.create(Registries.VILLAGER_TRADE, SpanishDelightRefabricated.id(path));
	}
}
