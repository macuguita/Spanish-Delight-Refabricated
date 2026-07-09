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

package com.macuguita.spanishdelight;

import com.macuguita.spanishdelight.reg.SDBlocks;
import com.macuguita.spanishdelight.reg.SDItemGroups;
import com.macuguita.spanishdelight.reg.SDItems;
import com.macuguita.spanishdelight.worldgen.SDWorldgen;

import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.entity.EntityEquipmentPredicate;

import net.minecraft.advancements.predicates.entity.EntityFlagsPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vectorwing.farmersdelight.common.tag.CommonTags;

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

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		SDBlocks.registerModBlocks();
		SDItems.registerModItems();
		SDItemGroups.registerItemGroups();
		SDWorldgen.init();

		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (source.isBuiltin()) {
				if (SQUID_LOOT_TABLE_ID == key || GLOW_SQUID_LOOT_TABLE_ID == key) {
					tableBuilder.withPool(LootPool.lootPool().add(LootItem.lootTableItem(SDItems.SQUID_RING)
									.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
													EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM), CommonTags.Items.TOOLS_KNIFE))
											)).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(false))))
											.and(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.5F, 0.1F)))))
							.withPool(LootPool.lootPool().add(LootItem.lootTableItem(SDItems.FRIED_SQUID_RING)
									.when(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.ATTACKER, EntityPredicate.Builder.entity().equipment(
											EntityEquipmentPredicate.Builder.equipment().mainhand(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM), CommonTags.Items.TOOLS_KNIFE))
									)).and(LootItemEntityPropertyCondition.hasProperties(LootContext.EntityTarget.THIS, EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true)))
											.and(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(registries, 0.5F, 0.1F))))));
				}
			}
		});
	}
}
