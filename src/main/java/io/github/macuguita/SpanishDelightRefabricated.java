package io.github.macuguita;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItemGroups;
import io.github.macuguita.item.ModItems;
import io.github.macuguita.utils.ModCustomTrades;
import io.github.macuguita.utils.ModFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.RandomChanceWithEnchantedBonusLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.predicate.entity.EntityEquipmentPredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vectorwing.farmersdelight.common.tag.CommonTags;

public class SpanishDelightRefabricated implements ModInitializer {

    public static final String MOD_ID = "spanishdelight";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private static final RegistryKey<LootTable> SQUID_LOOT_TABLE_ID = vanillaKey("entities/squid");
    private static final RegistryKey<LootTable> GLOW_SQUID_LOOT_TABLE_ID = vanillaKey("entities/glow_squid");

    private static RegistryKey<LootTable> vanillaKey(String path) {
        return RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.ofVanilla(path));
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
                    tableBuilder.pool(LootPool.builder().with(ItemEntry.builder(ModItems.SQUID_RING)
                                    .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.ATTACKER, EntityPredicate.Builder.create().equipment(
                                                    EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(registries.getOrThrow(RegistryKeys.ITEM), CommonTags.TOOLS_KNIFE))
                                            )).and(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(false))))
                                            .and(RandomChanceWithEnchantedBonusLootCondition.builder(registries, 0.5F, 0.1F)))))
                            .pool(LootPool.builder().with(ItemEntry.builder(ModItems.FRIED_SQUID_RING)
                                    .conditionally(EntityPropertiesLootCondition.builder(LootContext.EntityReference.ATTACKER, EntityPredicate.Builder.create().equipment(
                                            EntityEquipmentPredicate.Builder.create().mainhand(ItemPredicate.Builder.create().tag(registries.getOrThrow(RegistryKeys.ITEM), CommonTags.TOOLS_KNIFE))
                                    )).and(EntityPropertiesLootCondition.builder(LootContext.EntityReference.THIS, EntityPredicate.Builder.create().flags(EntityFlagsPredicate.Builder.create().onFire(true)))
                                            .and(RandomChanceWithEnchantedBonusLootCondition.builder(registries, 0.5F, 0.1F))))));
                }
            }
        });
    }
}
