package io.github.macuguita.item;

import io.github.macuguita.SpanishDelightRefabricated;
import io.github.macuguita.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static ItemGroup SDELIGHT_TAB = Registry.register(Registries.ITEM_GROUP,
            new Identifier(SpanishDelightRefabricated.MOD_ID, "sdelight_tab"),
            FabricItemGroup.builder().displayName(Text.translatable("creativetab.sdelight_tab"))
                    .icon(() -> new ItemStack(ModItems.SPANISH_TORTILLA)).entries((displayContext, entries) -> {
                        entries.add(ModItems.PAPRIKA);
                        entries.add(ModItems.SLICED_POTATO);
                        entries.add(ModItems.SLICED_ONION);
                        entries.add(ModItems.GARLIC);
                        entries.add(ModItems.GREEN_BEAN);
                        entries.add(ModItems.RED_PEPPER);
                        entries.add(ModItems.GREEN_PEPPER);
                        entries.add(ModItems.SQUID_RING);
                        entries.add(ModItems.SPANISH_TORTILLA);
                        entries.add(ModItems.PAELLA);
                        entries.add(ModItems.PIL_PIL_COD);
                        entries.add(ModItems.CROQUETTES);
                        entries.add(ModItems.BRAVA_POTATOES);
                        entries.add(ModItems.CHURRO);
                        entries.add(ModItems.GAZPACHO);
                        entries.add(ModItems.PANTUMACA);
                        entries.add(ModItems.FRIED_SQUID_RING);
                        entries.add(ModBlocks.WILD_GARLIC.asItem());
                        entries.add(ModBlocks.WILD_RED_PEPPER.asItem());
                        entries.add(ModBlocks.WILD_GREEN_PEPPER.asItem());
                    }).build());

    public static void registerItemGroups() {
        SpanishDelightRefabricated.LOGGER.info("Registering Item Groups for" + SpanishDelightRefabricated.MOD_ID);
    }
}
