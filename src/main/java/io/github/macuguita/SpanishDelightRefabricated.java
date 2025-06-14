package io.github.macuguita;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItemGroups;
import io.github.macuguita.item.ModItems;
import io.github.macuguita.utils.ModCustomTrades;
import io.github.macuguita.utils.ModFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceWithLootingLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vectorwing.farmersdelight.common.tag.ModTags;

public class SpanishDelightRefabricated implements ModInitializer {
	public static final String MOD_ID = "spanishdelight";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final Identifier SQUID_LOOT_TABLE_ID = new Identifier("minecraft", "entities/squid");
	private static final Identifier GLOW_SQUID_LOOT_TABLE_ID = new Identifier("minecraft", "entities/glow_squid");

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModFeatures.init();
		ModCustomTrades.registerCustomTrades();

		LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
			if (source.isBuiltin()) {
				if (SQUID_LOOT_TABLE_ID.equals(id)) {
					tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(ModItems.SQUID_RING)
									.conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.create().equipment(
													EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(ModTags.KNIVES).build()).build()
											)).and(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(false).build())))
											.and(RandomChanceWithLootingLootCondition.builder(0.5F, 0.1F)))))
							.pool(LootPool.builder().with(ItemEntry.builder(ModItems.FRIED_SQUID_RING)
									.conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.create().equipment(
											EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(ModTags.KNIVES).build()).build()
									)).and(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true).build()))
											.and(RandomChanceWithLootingLootCondition.builder(0.5F, 0.1F))))));
				}

				if (GLOW_SQUID_LOOT_TABLE_ID.equals(id)) {
					tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(ModItems.SQUID_RING)
									.conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.create().equipment(
													EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(ModTags.KNIVES).build()).build()
											)).and(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(false).build())))
											.and(RandomChanceWithLootingLootCondition.builder(0.5F, 0.1F)))))
							.pool(LootPool.builder().with(ItemEntry.builder(ModItems.FRIED_SQUID_RING)
									.conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.KILLER, EntityPredicate.Builder.create().equipment(
											EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(ModTags.KNIVES).build()).build()
									)).and(EntityPropertiesLootCondition.builder(LootContext.EntityTarget.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true).build()))
											.and(RandomChanceWithLootingLootCondition.builder(0.5F, 0.1F))))));
				}
			}
		});
	}
}