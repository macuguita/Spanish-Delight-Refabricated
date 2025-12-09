package io.github.macuguita;

import com.mojang.blaze3d.platform.InputConstants;
import io.github.macuguita.block.ModBlocks;
import io.github.macuguita.item.ModItems;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.network.chat.Component;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;

public class SpanishDelightRefabricatedClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.putBlock(ModBlocks.WILD_GARLIC, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.WILD_RED_PEPPER, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.WILD_GREEN_PEPPER, ChunkSectionLayer.CUTOUT);
		BlockRenderLayerMap.putBlock(ModBlocks.GREEN_BEAN_CROP, ChunkSectionLayer.CUTOUT);

		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
			if (itemStack.is(ModItems.SQUID_RING)) {
				if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow(), InputConstants.KEY_LSHIFT)) {
					list.add(Component.translatable("tooltip.spanishdelight.squid_ring"));
				} else {
					list.add(Component.translatable("tooltip.spanishdelight.press_shift").withStyle(ChatFormatting.YELLOW));
				}
			}
			if (itemStack.is(ModItems.GREEN_BEAN)) {
				if (InputConstants.isKeyDown(Minecraft.getInstance().getWindow(), InputConstants.KEY_LSHIFT)) {
					list.add(Component.translatable("tooltip.spanishdelight.green_bean"));
				} else {
					list.add(Component.translatable("tooltip.spanishdelight.press_shift").withStyle(ChatFormatting.YELLOW));
				}
			}
		});
	}
}
