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

package com.macuguita.spanishdelight.utils;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;

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

		public static TagKey<Biome> IS_PLAINS = createTag("is_plains");
		public static TagKey<Biome> IS_SAVANNA = createTag("is_savanna");
		public static TagKey<Biome> IS_TAIGA = createTag("is_taiga");

		private static TagKey<Biome> createTag(String name) {
			return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, name));
		}

		private static TagKey<Biome> createVanillaTag(String name) {
			return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("minecraft", name));
		}

		private static TagKey<Biome> createCommonTag(String name) {
			return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", name));
		}
	}
}
