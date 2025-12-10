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

package io.github.macuguita.utils;

import io.github.macuguita.item.ModItems;

import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

public class ModCustomTrades {

	public static void registerCustomTrades() {
		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
				factories -> {
					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(Items.EMERALD, 1),
							new ItemStack(ModItems.GREEN_BEAN, 10),
							10, 8, 0.02F
					));
				});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2,
				factories -> {
					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get(), 15),
							new ItemStack(ModItems.GARLIC, 5),
							8, 8, 0.02F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(ModItems.SLICED_POTATO, 24),
							new ItemStack(ModItems.RED_PEPPER, 3),
							8, 8, 0.02F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(vectorwing.farmersdelight.common.registry.ModItems.RICE.get(), 27),
							new ItemStack(ModItems.GREEN_PEPPER, 9),
							8, 8, 0.02F
					));
				});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3,
				factories -> {
					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(ModItems.GAZPACHO, 1),
							new ItemStack(ModItems.GARLIC, 20),
							10, 8, 0.02F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(ModItems.BRAVA_POTATOES, 1),
							new ItemStack(ModItems.RED_PEPPER, 20),
							10, 8, 0.02F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(ModItems.PIL_PIL_COD, 1),
							new ItemStack(ModItems.RED_PEPPER, 20),
							10, 8, 0.02F
					));
				});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 4,
				factories -> {
					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(Items.EMERALD, 1),
							new ItemStack(ModItems.GARLIC, 34),
							6, 10, 0.15F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(Items.EMERALD, 1),
							new ItemStack(ModItems.RED_PEPPER, 34),
							6, 10, 0.15F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(Items.EMERALD, 1),
							new ItemStack(ModItems.GREEN_PEPPER, 34),
							6, 10, 0.15F
					));
				});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5,
				factories -> {
					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(Items.EMERALD, 6),
							new ItemStack(ModItems.GARLIC, 64),
							1, 15, 0.02F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(Items.EMERALD, 6),
							new ItemStack(ModItems.RED_PEPPER, 64),
							1, 15, 0.02F
					));

					factories.add((serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(Items.EMERALD, 6),
							new ItemStack(ModItems.GREEN_PEPPER, 64),
							1, 15, 0.02F
					));
				});


		TradeOfferHelper.registerWanderingTraderOffers(builder -> {
			builder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
					(serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(ModItems.GARLIC, 64),
							new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
							1, 12, 0.15F
					),
					(serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(ModItems.RED_PEPPER, 64),
							new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
							1, 12, 0.15F
					),
					(serverLevel, entity, random) -> new MerchantOffer(
							new ItemCost(ModItems.GREEN_PEPPER, 64),
							new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
							1, 12, 0.15F
					)
			);
		});
	}
}
