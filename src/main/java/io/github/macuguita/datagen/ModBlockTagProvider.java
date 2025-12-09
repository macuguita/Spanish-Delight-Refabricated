package io.github.macuguita.datagen;

import java.util.concurrent.CompletableFuture;

import io.github.macuguita.block.ModBlocks;
import vectorwing.farmersdelight.common.tag.ModTags;

import net.minecraft.core.HolderLookup;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

	public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void addTags(HolderLookup.Provider wrapperLookup) {
		valueLookupBuilder(ModTags.WILD_CROPS)
				.add(ModBlocks.WILD_GARLIC)
				.add(ModBlocks.WILD_GREEN_PEPPER)
				.add(ModBlocks.WILD_RED_PEPPER);
	}
}
