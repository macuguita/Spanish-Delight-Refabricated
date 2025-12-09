package io.github.macuguita.block;

import java.util.function.Function;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.block.custom.GreenBeanCropBlock;
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

public class ModBlocks {

	public static Block GREEN_BEAN_CROP = registerBlock("green_bean_crop", GreenBeanCropBlock::new,
			BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT).mapColor(MapColor.COLOR_GREEN), false);

	public static Block WILD_GARLIC = registerBlock("wild_garlic",
			settings -> new WildCropBlock(MobEffects.HASTE, 5, settings),
			BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

	public static Block WILD_RED_PEPPER = registerBlock("wild_red_pepper",
			settings -> new WildCropBlock(MobEffects.SPEED, 8, settings),
			BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

	public static Block WILD_GREEN_PEPPER = registerBlock("wild_green_pepper",
			settings -> new WildCropBlock(MobEffects.JUMP_BOOST, 8, settings),
			BlockBehaviour.Properties.ofFullCopy(Blocks.TALL_GRASS));

	private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings) {
		return registerBlock(name, blockFactory, settings, true);
	}

	private static Block registerBlock(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
		ResourceKey<Block> blockKey = keyOfBlock(name);
		Block block = blockFactory.apply(settings.setId(blockKey));

		if (shouldRegisterItem) {
			ResourceKey<Item> itemKey = keyOfItem(name);

			BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey));
			Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
		}

		return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
	}

	private static ResourceKey<Block> keyOfBlock(String name) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, name));
	}

	private static ResourceKey<Item> keyOfItem(String name) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SpanishDelightRefabricated.MOD_ID, name));
	}

	public static void registerModBlocks() {
		SpanishDelightRefabricated.LOGGER.info("Registering Mod Blocks for " + SpanishDelightRefabricated.MOD_ID);
	}

}
