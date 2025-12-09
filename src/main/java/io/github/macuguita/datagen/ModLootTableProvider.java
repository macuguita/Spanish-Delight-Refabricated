package io.github.macuguita.datagen;

import java.util.concurrent.CompletableFuture;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItems;

import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PotatoBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

	public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		HolderLookup.RegistryLookup<Enchantment> impl = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
		HolderLookup.RegistryLookup<Item> impl2 = this.registries.lookupOrThrow(Registries.ITEM);
		add(ModBlocks.WILD_GARLIC, block -> wildCropDrops(block, ModItems.GARLIC, impl));
		add(ModBlocks.WILD_RED_PEPPER, block -> wildCropDrops(block, ModItems.RED_PEPPER, impl));
		add(ModBlocks.WILD_GREEN_PEPPER, block -> wildCropDrops(block, ModItems.GREEN_PEPPER, impl));

		LootItemCondition.Builder builder5 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GREEN_BEAN_CROP)
				.setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PotatoBlock.AGE, 5));
		this.add(
				ModBlocks.GREEN_BEAN_CROP,
				this.applyExplosionDecay(
						ModBlocks.GREEN_BEAN_CROP,
						LootTable.lootTable()
								.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.GREEN_BEAN)))
								.withPool(
										LootPool.lootPool()
												.when(builder5)
												.add(LootItem.lootTableItem(ModItems.GREEN_BEAN).apply(ApplyBonusCount.addBonusBinomialDistributionCount(impl.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3)))
								)
				)
		);
	}

	public LootTable.Builder wildCropDrops(Block drop, Item item, HolderLookup.RegistryLookup<Enchantment> impl) {
		return this.createSilkTouchDispatchTable(
				drop,
				this.applyExplosionDecay(
						drop,
						LootItem.lootTableItem(item)
								.apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 5.0F)))
								.apply(ApplyBonusCount.addOreBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
				)
		);
	}
}
