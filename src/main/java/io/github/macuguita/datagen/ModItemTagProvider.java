package io.github.macuguita.datagen;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItems;
import io.github.macuguita.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import vectorwing.farmersdelight.common.tag.CommonTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(vectorwing.farmersdelight.common.tag.ModTags.WILD_CROPS_ITEM)
                .add(ModBlocks.WILD_GARLIC.asItem())
                .add(ModBlocks.WILD_GREEN_PEPPER.asItem())
                .add(ModBlocks.WILD_RED_PEPPER.asItem());
        getOrCreateTagBuilder(vectorwing.farmersdelight.common.tag.ModTags.MEALS)
                .add(ModItems.PAELLA)
                .add(ModItems.PIL_PIL_COD)
                .add(ModItems.BRAVA_POTATOES)
                .add(ModItems.GAZPACHO);
        getOrCreateTagBuilder(CommonTags.CROPS_ONION)
                .add(ModItems.SLICED_ONION);
        getOrCreateTagBuilder(ConventionalItemTags.POTATO_CROPS)
                .add(ModItems.SLICED_POTATO);
        getOrCreateTagBuilder(ConventionalItemTags.BREAD_FOODS)
                .add(ModItems.PANTUMACA);
        getOrCreateTagBuilder(ModTags.Items.GARLIC)
                .add(ModItems.GARLIC);
    }
}
