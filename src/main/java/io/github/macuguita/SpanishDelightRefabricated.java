package io.github.macuguita;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItemGroups;
import io.github.macuguita.item.ModItems;
import io.github.macuguita.utils.ModCustomTrades;
import io.github.macuguita.utils.ModFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vectorwing.farmersdelight.common.tag.CommonTags;

import net.minecraft.advancements.criterion.EntityEquipmentPredicate;
import net.minecraft.advancements.criterion.EntityFlagsPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;

public class SpanishDelightRefabricated implements ModInitializer {

	public static final String MOD_ID = "spanishdelight";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private static final ResourceKey<LootTable> SQUID_LOOT_TABLE_ID = vanillaKey("entities/squid");
	private static final ResourceKey<LootTable> GLOW_SQUID_LOOT_TABLE_ID = vanillaKey("entities/glow_squid");

	private static ResourceKey<LootTable> vanillaKey(String path) {
		return ResourceKey.create(Registries.LOOT_TABLE, Identifier.withDefaultNamespace(path));
	}

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModFeatures.init();
		ModCustomTrades.registerCustomTrades();

		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (source.isBuiltin()) {
				if (SQUID_LOOT_TABLE_ID == key || GLOW_SQUID_LOOT_TABLE_ID == key) {
					tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.SQUID_RING)
									.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
													EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM), CommonTags.TOOLS_KNIFE))
											)).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(false))))
											.and(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.5F, 0.1F)))))
							.withPool(LootPool.lootPool().add(LootItem.lootTableItem(ModItems.FRIED_SQUID_RING)
									.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
											EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM), CommonTags.TOOLS_KNIFE))
									)).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true)))
											.and(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.5F, 0.1F))))));
				}
			}
		});
	}
}
