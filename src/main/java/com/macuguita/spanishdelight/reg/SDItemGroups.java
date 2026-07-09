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

package com.macuguita.spanishdelight.reg;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;

public final class SDItemGroups {

	public static CreativeModeTab SDELIGHT_TAB = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
			Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, "sdelight_tab"),
			FabricCreativeModeTab.builder().title(Component.translatable("creativetab.sdelight_tab"))
					.icon(() -> new ItemStack(SDItems.SPANISH_TORTILLA)).displayItems((displayContext, entries) -> {
						entries.accept(SDItems.PAPRIKA);
						entries.accept(SDItems.SLICED_POTATO);
						entries.accept(SDItems.SLICED_ONION);
						entries.accept(SDItems.GARLIC);
						entries.accept(SDItems.GREEN_BEAN);
						entries.accept(SDItems.RED_PEPPER);
						entries.accept(SDItems.GREEN_PEPPER);
						entries.accept(SDItems.SQUID_RING);
						entries.accept(SDItems.SPANISH_TORTILLA);
						entries.accept(SDItems.PAELLA);
						entries.accept(SDItems.PIL_PIL_COD);
						entries.accept(SDItems.CROQUETTES);
						entries.accept(SDItems.BRAVA_POTATOES);
						entries.accept(SDItems.CHURRO);
						entries.accept(SDItems.GAZPACHO);
						entries.accept(SDItems.PANTUMACA);
						entries.accept(SDItems.FRIED_SQUID_RING);
						entries.accept(SDItems.WILD_GARLIC);
						entries.accept(SDItems.WILD_RED_PEPPER);
						entries.accept(SDItems.WILD_GREEN_PEPPER);
					}).build());

	private SDItemGroups() {}

	public static void registerItemGroups() {
		SpanishDelightRefabricated.LOGGER.info("Registering Item Groups for" + SpanishDelightRefabricated.MOD_ID);
	}
}
