package io.github.macuguita.block.custom;

import com.mojang.serialization.MapCodec;
import io.github.macuguita.item.ModItems;

import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class GreenBeanCropBlock extends CropBlock {

	public static final int MAX_AGE = 5;
	public static final IntegerProperty GREEN_BEAN_AGE = BlockStateProperties.AGE_5;
	public static final MapCodec<GreenBeanCropBlock> CODEC = simpleCodec(GreenBeanCropBlock::new);

	public GreenBeanCropBlock(BlockBehaviour.Properties settings) {
		super(settings);
	}

	@Override
	public MapCodec<GreenBeanCropBlock> codec() {
		return CODEC;
	}

	@Override
	protected ItemLike getBaseSeedId() {
		return ModItems.GREEN_BEAN;
	}

	@Override
	protected IntegerProperty getAgeProperty() {
		return GREEN_BEAN_AGE;
	}

	@Override
	public int getMaxAge() {
		return MAX_AGE;
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(GREEN_BEAN_AGE);
	}
}
