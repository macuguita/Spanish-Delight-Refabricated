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

package io.github.macuguita.item;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.block.ModBlocks;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

public class ModItemGroups {

	public static CreativeModeTab SDELIGHT_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
			Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, "sdelight_tab"),
			FabricItemGroup.builder().title(Component.translatable("creativetab.sdelight_tab"))
					.icon(() -> new ItemStack(ModItems.SPANISH_TORTILLA)).displayItems((displayContext, entries) -> {
						entries.accept(ModItems.PAPRIKA);
						entries.accept(ModItems.SLICED_POTATO);
						entries.accept(ModItems.SLICED_ONION);
						entries.accept(ModItems.GARLIC);
						entries.accept(ModItems.GREEN_BEAN);
						entries.accept(ModItems.RED_PEPPER);
						entries.accept(ModItems.GREEN_PEPPER);
						entries.accept(ModItems.SQUID_RING);
						entries.accept(ModItems.SPANISH_TORTILLA);
						entries.accept(ModItems.PAELLA);
						entries.accept(ModItems.PIL_PIL_COD);
						entries.accept(ModItems.CROQUETTES);
						entries.accept(ModItems.BRAVA_POTATOES);
						entries.accept(ModItems.CHURRO);
						entries.accept(ModItems.GAZPACHO);
						entries.accept(ModItems.PANTUMACA);
						entries.accept(ModItems.FRIED_SQUID_RING);
						entries.accept(ModBlocks.WILD_GARLIC.asItem());
						entries.accept(ModBlocks.WILD_RED_PEPPER.asItem());
						entries.accept(ModBlocks.WILD_GREEN_PEPPER.asItem());
					}).build());

	public static void registerItemGroups() {
		SpanishDelightRefabricated.LOGGER.info("Registering Item Groups for" + SpanishDelightRefabricated.MOD_ID);
	}
}
