package com.macuguita.spanishdelight.reg.id;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class SDItemIds {

	public static final ResourceKey<Item> PAPRIKA = create("paprika");
	public static final ResourceKey<Item> SLICED_POTATO = create("sliced_potato");
	public static final ResourceKey<Item> SLICED_ONION = create("sliced_onion");
	public static final ResourceKey<Item> GARLIC = create("garlic");
	public static final ResourceKey<Item> RED_PEPPER = create("red_pepper");
	public static final ResourceKey<Item> GREEN_PEPPER = create("green_pepper");
	public static final ResourceKey<Item> SQUID_RING = create("squid_ring");

	public static final ResourceKey<Item> SPANISH_TORTILLA = create("spanish_tortilla");
	public static final ResourceKey<Item> PAELLA = create("paella");
	public static final ResourceKey<Item> PIL_PIL_COD = create("pil_pil_cod");
	public static final ResourceKey<Item> CROQUETTES = create("croquettes");
	public static final ResourceKey<Item> BRAVA_POTATOES = create("brava_potatoes");
	public static final ResourceKey<Item> CHURRO = create("churro");
	public static final ResourceKey<Item> GAZPACHO = create("gazpacho");
	public static final ResourceKey<Item> PANTUMACA = create("pantumaca");
	public static final ResourceKey<Item> FRIED_SQUID_RING = create("fried_squid_ring");

	private SDItemIds() {}

	private static ResourceKey<Item> create(final String name) {
		return ResourceKey.create(Registries.ITEM, SpanishDelightRefabricated.id(name));
	}
}
