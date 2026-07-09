package com.macuguita.spanishdelight.reg.id;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;

import net.minecraft.core.registries.Registries;
import net.minecraft.references.BlockIds;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;

public final class SDBlockIds {

	private SDBlockIds() {}

	private static ResourceKey<Block> create(final String name) {
		return ResourceKey.create(Registries.BLOCK, SpanishDelightRefabricated.id(name));
	}
}
