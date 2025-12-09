package io.github.macuguita.item;

import vectorwing.farmersdelight.common.FoodValues;

import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModConsumableComponents {

	private static final int BRIEF_DURATION = 600;    // 30 seconds
	private static final int SHORT_DURATION = 1200;    // 1 minute
	private static final int MEDIUM_DURATION = 3600;    // 3 minutes
	private static final int LONG_DURATION = 6000;    // 5 minutes

	public static final Consumable CROQUETTES = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(SHORT_DURATION)))
			.build();
	public static final Consumable CHURRO = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.comfort(SHORT_DURATION)))
			.build();
	public static final Consumable GAZPACHO = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(SHORT_DURATION)))
			.build();
	public static final Consumable FRIED_SQUID_RING = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.comfort(SHORT_DURATION)))
			.build();
	public static final Consumable BRAVA_POTATOES = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.comfort(MEDIUM_DURATION)))
			.build();
	public static final Consumable PANTUMACA = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(MEDIUM_DURATION)))
			.build();
	public static final Consumable SPANISH_TORTILLA = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(LONG_DURATION)))
			.build();
	public static final Consumable PAELLA = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.comfort(LONG_DURATION)))
			.build();
	public static final Consumable PIL_PIL_COD = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.comfort(LONG_DURATION)))
			.build();
}
