package io.github.macuguita.block;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.block.custom.GreenBeanCropBlock;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class ModBlocks {

    public static Block GREEN_BEAN_CROP = Registry.register(Registries.BLOCK, Identifier.of(SpanishDelightRefabricated.MOD_ID, "green_bean"),
            new GreenBeanCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT).nonOpaque().noCollision()));

    public static Block WILD_GARLIC = registerBlock("wild_garlic",
            new WildCropBlock(StatusEffects.HASTE, 5,
                    AbstractBlock.Settings.copy(Blocks.TALL_GRASS)));

    public static Block WILD_RED_PEPPER = registerBlock("wild_red_pepper",
            new WildCropBlock(StatusEffects.SPEED, 8,
                    AbstractBlock.Settings.copy(Blocks.TALL_GRASS)));

    public static Block WILD_GREEN_PEPPER = registerBlock("wild_green_pepper",
            new WildCropBlock(StatusEffects.JUMP_BOOST, 8,
                    AbstractBlock.Settings.copy(Blocks.TALL_GRASS)));



    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(SpanishDelightRefabricated.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(SpanishDelightRefabricated.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        SpanishDelightRefabricated.LOGGER.info("Registering Mod Blocks for " + SpanishDelightRefabricated.MOD_ID);
    }

}
