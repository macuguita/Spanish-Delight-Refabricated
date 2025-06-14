package io.github.macuguita.item.custom;

import net.minecraft.block.Block;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class GreenBeanItem extends AliasedBlockItem {

    public GreenBeanItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.spanishdelight.green_bean"));
        } else {
            tooltip.add(Text.translatable("tooltip.spanishdelight.press_shift").formatted(Formatting.YELLOW));
        }
    }
}
