package com.macuguita.spanishdelight.reg.id;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;

import net.minecraft.references.BlockItemId;

public final class SDBlockItemIds {

	public static final BlockItemId GREEN_BEAN = create("green_bean_crop", "green_bean");

	public static final BlockItemId WILD_GARLIC = create("wild_garlic");
	public static final BlockItemId WILD_RED_PEPPER = create("wild_red_pepper");
	public static final BlockItemId WILD_GREEN_PEPPER = create("wild_green_pepper");
	
	private SDBlockItemIds() {}

	private static BlockItemId create(final String name) {
		return create(name, name);
	}

	private static BlockItemId create(final String blockName, final String itemName) {
		return BlockItemId.create(SpanishDelightRefabricated.id(blockName),SpanishDelightRefabricated.id(itemName));
	}
}
