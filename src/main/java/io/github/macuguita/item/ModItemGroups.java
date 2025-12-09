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
