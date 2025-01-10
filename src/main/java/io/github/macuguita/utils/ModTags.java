package io.github.macuguita.utils;

import io.github.macuguita.SpanishDelightRefabricated;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SpanishDelightRefabricated.MOD_ID, name));
        }
    }

    public static class Items {

        public static TagKey<Item> WATER_INGREDIENT = createTag("water_ingredient");

        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SpanishDelightRefabricated.MOD_ID, name));
        }
        private static TagKey<Item> createVanillaTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", name));
        }
    }

    public static class Biomes {

        public static TagKey<Biome> IS_PLAINS = createCommonTag("is_plains");
        public static TagKey<Biome> IS_SAVANNA = createVanillaTag("is_savanna");
        public static TagKey<Biome> IS_TAIGA = createVanillaTag("is_taiga");


        private static TagKey<Biome> createVanillaTag(String name){
            return TagKey.of(RegistryKeys.BIOME, Identifier.of("minecraft", name));
        }

        private static TagKey<Biome> createCommonTag(String name){
            return TagKey.of(RegistryKeys.BIOME, Identifier.of("c", name));
        }
    }


}
