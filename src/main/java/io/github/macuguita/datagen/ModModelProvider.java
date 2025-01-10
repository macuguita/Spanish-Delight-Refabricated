package io.github.macuguita.datagen;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.block.custom.GreenBeanCropBlock;
import io.github.macuguita.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) { super(output); }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerTintableCross(ModBlocks.WILD_GARLIC, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WILD_RED_PEPPER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerTintableCross(ModBlocks.WILD_GREEN_PEPPER, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerCrop(ModBlocks.GREEN_BEAN_CROP, GreenBeanCropBlock.AGE, 0, 1, 2, 3, 4, 5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PAPRIKA, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLICED_POTATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLICED_ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.GARLIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.RED_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.GREEN_PEPPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SQUID_RING, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPANISH_TORTILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PAELLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIL_PIL_COD, Models.GENERATED);
        itemModelGenerator.register(ModItems.CROQUETTES, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRAVA_POTATOES, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHURRO, Models.GENERATED);
        itemModelGenerator.register(ModItems.GAZPACHO, Models.GENERATED);
        itemModelGenerator.register(ModItems.PANTUMACA, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_SQUID_RING, Models.GENERATED);
    }
}
