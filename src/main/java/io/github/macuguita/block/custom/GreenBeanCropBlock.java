package io.github.macuguita.block.custom;

import com.mojang.serialization.MapCodec;
import io.github.macuguita.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class GreenBeanCropBlock extends CropBlock {

    public static final int MAX_AGE = 5;
    public static final IntProperty GREEN_BEAN_AGE = Properties.AGE_5;
    public static final MapCodec<GreenBeanCropBlock> CODEC = createCodec(GreenBeanCropBlock::new);

    public GreenBeanCropBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public MapCodec<GreenBeanCropBlock> getCodec() {
        return CODEC;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.GREEN_BEAN;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return GREEN_BEAN_AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(GREEN_BEAN_AGE);
    }
}
