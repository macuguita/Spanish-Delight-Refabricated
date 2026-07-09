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

import java.util.function.Function;
import java.util.function.ToIntFunction;

import com.macuguita.spanishdelight.SpanishDelightRefabricated;
import com.macuguita.spanishdelight.block.GreenBeanCropBlock;

import com.macuguita.spanishdelight.reg.id.SDBlockIds;

import com.macuguita.spanishdelight.reg.id.SDBlockItemIds;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.CandleBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

import vectorwing.farmersdelight.common.block.WildCropBlock;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public final class SDBlocks {

	public static Block GREEN_BEAN_CROP = register(SDBlockItemIds.GREEN_BEAN, GreenBeanCropBlock::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).mapColor(MapColor.COLOR_GREEN));

	public static Block WILD_GARLIC = register(SDBlockItemIds.WILD_GARLIC,
			settings -> new WildCropBlock(MobEffects.HASTE, 5, settings),
			BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

	public static Block WILD_RED_PEPPER = register(SDBlockItemIds.WILD_RED_PEPPER,
			settings -> new WildCropBlock(MobEffects.SPEED, 8, settings),
			BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

	public static Block WILD_GREEN_PEPPER = register(SDBlockItemIds.WILD_GREEN_PEPPER,
			settings -> new WildCropBlock(MobEffects.JUMP_BOOST, 8, settings),
			BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

	private SDBlocks() {}

	private static Block register(final BlockItemId id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
		return register(id.block(), factory, properties);
	}

	public static Block register(final ResourceKey<Block> id, final Function<BlockBehaviour.Properties, Block> factory, final BlockBehaviour.Properties properties) {
		Block block = factory.apply(properties.setId(id));
		return Registry.register(BuiltInRegistries.BLOCK, id, block);
	}

	private static Block register(final BlockItemId id, final BlockBehaviour.Properties properties) {
		return register(id.block(), properties);
	}

	public static Block register(final ResourceKey<Block> id, final BlockBehaviour.Properties properties) {
		return register(id, Block::new, properties);
	}

	public static void registerModBlocks() {
		SpanishDelightRefabricated.LOGGER.info("Registering Mod Blocks for " + SpanishDelightRefabricated.MOD_ID);
	}

}
