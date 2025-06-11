package io.github.macuguita.block;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.block.custom.GreenBeanCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Function;

public class ModBlocks {

    public static Block GREEN_BEAN_CROP = registerBlock("green_bean_crop", GreenBeanCropBlock::new,
            AbstractBlock.Settings.copy(Blocks.WHEAT).mapColor(MapColor.GREEN), false);

    public static Block WILD_GARLIC = registerBlock("wild_garlic",
            settings -> new WildCropBlock(StatusEffects.HASTE, 5, settings),
            AbstractBlock.Settings.copy(Blocks.TALL_GRASS));

    public static Block WILD_RED_PEPPER = registerBlock("wild_red_pepper",
            settings -> new WildCropBlock(StatusEffects.SPEED, 8, settings),
            AbstractBlock.Settings.copy(Blocks.TALL_GRASS));

    public static Block WILD_GREEN_PEPPER = registerBlock("wild_green_pepper",
            settings -> new WildCropBlock(StatusEffects.JUMP_BOOST, 8, settings),
            AbstractBlock.Settings.copy(Blocks.TALL_GRASS));

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings) {
        return registerBlock(name, blockFactory, settings, true);
    }

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SpanishDelightRefabricated.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SpanishDelightRefabricated.MOD_ID, name));
    }

    public static void registerModBlocks() {
        SpanishDelightRefabricated.LOGGER.info("Registering Mod Blocks for " + SpanishDelightRefabricated.MOD_ID);
    }

}
