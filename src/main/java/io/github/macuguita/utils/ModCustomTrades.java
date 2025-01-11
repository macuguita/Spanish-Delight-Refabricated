package io.github.macuguita.utils;

import io.github.macuguita.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class ModCustomTrades {

    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ModItems.GREEN_BEAN, 10),
                            10, 8, 0.02F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(vectorwing.farmersdelight.common.registry.ModItems.TOMATO.get(), 15),
                            new ItemStack(ModItems.GARLIC, 5),
                            8, 8, 0.02F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.SLICED_POTATO, 24),
                            new ItemStack(ModItems.RED_PEPPER, 3),
                            8, 8, 0.02F
                    ));
                    
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(vectorwing.farmersdelight.common.registry.ModItems.RICE.get(), 27),
                            new ItemStack(ModItems.GREEN_PEPPER, 9),
                            8, 8, 0.02F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.GAZPACHO, 1),
                            new ItemStack(ModItems.GARLIC, 20),
                            10, 8, 0.02F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.BRAVA_POTATOES, 1),
                            new ItemStack(ModItems.RED_PEPPER, 20),
                            10, 8, 0.02F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.PIL_PIL_COD, 1),
                            new ItemStack(ModItems.RED_PEPPER, 20),
                            10, 8, 0.02F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ModItems.GARLIC, 34),
                            6, 10, 0.15F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ModItems.RED_PEPPER, 34),
                            6, 10, 0.15F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 1),
                            new ItemStack(ModItems.GREEN_PEPPER, 34),
                            6, 10, 0.15F
                    ));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 6),
                            new ItemStack(ModItems.GARLIC, 64),
                            1, 15, 0.02F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 6),
                            new ItemStack(ModItems.RED_PEPPER, 64),
                            1, 15, 0.02F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(Items.EMERALD, 6),
                            new ItemStack(ModItems.GREEN_PEPPER, 64),
                            1, 15, 0.02F
                    ));
                });


        TradeOfferHelper.registerWanderingTraderOffers(1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.GREEN_BEAN, 32),
                            new ItemStack(ModItems.GARLIC, 5),
                            10, 12, 0.1F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.GREEN_BEAN, 32),
                            new ItemStack(ModItems.RED_PEPPER, 5),
                            10, 12, 0.1F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.GREEN_BEAN, 32),
                            new ItemStack(ModItems.GREEN_PEPPER, 5),
                            10, 12, 0.1F
                    ));
                });

        TradeOfferHelper.registerWanderingTraderOffers(2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.GARLIC, 64),
                            new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
                            1, 12, 0.15F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.RED_PEPPER, 64),
                            new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
                            1, 12, 0.15F
                    ));

                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModItems.GREEN_PEPPER, 64),
                            new ItemStack(vectorwing.farmersdelight.common.registry.ModItems.DIAMOND_KNIFE.get(), 1),
                            1, 12, 0.15F
                    ));
                });


    }
}
