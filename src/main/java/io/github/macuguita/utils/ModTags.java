package io.github.macuguita.utils;

import io.github.macuguita.SpanishDelightRefabricated;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModTags {

	public static class Blocks {

		private static TagKey<Block> createTag(String name) {
			return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, name));
		}
	}

	public static class Items {

		public static TagKey<Item> GARLIC = createCommonTag("crops/garlic");

		private static TagKey<Item> createTag(String name) {
			return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, name));
		}

		private static TagKey<Item> createCommonTag(String name) {
			return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("c", name));
		}

		private static TagKey<Item> createVanillaTag(String name) {
			return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("minecraft", name));
		}
	}

	public static class Biomes {

		public static TagKey<Biome> IS_PLAINS = createCommonTag("is_plains");
		public static TagKey<Biome> IS_SAVANNA = createVanillaTag("is_savanna");
		public static TagKey<Biome> IS_TAIGA = createVanillaTag("is_taiga");


		private static TagKey<Biome> createVanillaTag(String name) {
			return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("minecraft", name));
		}

		private static TagKey<Biome> createCommonTag(String name) {
			return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", name));
		}
	}
}
