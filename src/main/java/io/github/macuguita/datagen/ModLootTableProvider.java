package io.github.macuguita.datagen;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.PotatoesBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.WILD_GARLIC, block -> wildCropDrops(block, ModItems.GARLIC));
        addDrop(ModBlocks.WILD_RED_PEPPER, block -> wildCropDrops(block, ModItems.RED_PEPPER));
        addDrop(ModBlocks.WILD_GREEN_PEPPER, block -> wildCropDrops(block, ModItems.GREEN_PEPPER));

        LootCondition.Builder builder5 = BlockStatePropertyLootCondition.builder(ModBlocks.GREEN_BEAN_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(PotatoesBlock.AGE, 5));
        this.addDrop(
                ModBlocks.GREEN_BEAN_CROP,
                this.applyExplosionDecay(
                        ModBlocks.GREEN_BEAN_CROP,
                        LootTable.builder()
                                .pool(LootPool.builder().with(ItemEntry.builder(ModItems.GREEN_BEAN)))
                                .pool(
                                        LootPool.builder()
                                                .conditionally(builder5)
                                                .with(ItemEntry.builder(ModItems.GREEN_BEAN).apply(ApplyBonusLootFunction.binomialWithBonusCount(impl.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3)))
                                )
                )
        );
    }

    public LootTable.Builder wildCropDrops(Block drop, Item item) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

}
