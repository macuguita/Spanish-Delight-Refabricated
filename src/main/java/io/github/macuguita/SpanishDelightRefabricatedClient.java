package io.github.macuguita;

import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class SpanishDelightRefabricatedClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.WILD_GARLIC, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.WILD_RED_PEPPER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.WILD_GREEN_PEPPER, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.GREEN_BEAN_CROP, BlockRenderLayer.CUTOUT);

        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.isOf(ModItems.SQUID_RING)) {
                if (Screen.hasShiftDown()) {
                    list.add(Text.translatable("tooltip.spanishdelight.squid_ring"));
                } else {
                    list.add(Text.translatable("tooltip.spanishdelight.press_shift").formatted(Formatting.YELLOW));
                }
            }
            if (itemStack.isOf(ModItems.GREEN_BEAN)) {
                if (Screen.hasShiftDown()) {
                    list.add(Text.translatable("tooltip.spanishdelight.green_bean"));
                } else {
                    list.add(Text.translatable("tooltip.spanishdelight.press_shift").formatted(Formatting.YELLOW));
                }
            }
        });
    }
}
