/*
 * Copyright (c) 2026 macuguita
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.macuguita.spanishdelight.item;

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
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(SHORT_DURATION)))
			.build();
	public static final Consumable GAZPACHO = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(SHORT_DURATION)))
			.build();
	public static final Consumable FRIED_SQUID_RING = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(SHORT_DURATION)))
			.build();
	public static final Consumable BRAVA_POTATOES = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(MEDIUM_DURATION)))
			.build();
	public static final Consumable PANTUMACA = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(MEDIUM_DURATION)))
			.build();
	public static final Consumable SPANISH_TORTILLA = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(LONG_DURATION)))
			.build();
	public static final Consumable PAELLA = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(LONG_DURATION)))
			.build();
	public static final Consumable PIL_PIL_COD = Consumables.defaultFood()
			.onConsume(new ApplyStatusEffectsConsumeEffect(FoodValues.nourishment(LONG_DURATION)))
			.build();
}
