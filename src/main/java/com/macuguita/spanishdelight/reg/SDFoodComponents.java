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

package com.macuguita.spanishdelight.reg;

import net.minecraft.world.food.FoodProperties;

public final class SDFoodComponents {

	public static final FoodProperties SLICED_POTATO = new FoodProperties.Builder().nutrition(1).saturationModifier(0.5f).build();
	public static final FoodProperties SLICED_ONION = new FoodProperties.Builder().nutrition(2).saturationModifier(0.2f).build();
	public static final FoodProperties GARLIC = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).build();
	public static final FoodProperties GREEN_BEAN = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f).build();
	public static final FoodProperties PEPPER = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build();
	public static final FoodProperties SQUID_RING = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build();

	public static final FoodProperties SPANISH_TORTILLA = new FoodProperties.Builder()
			.nutrition(7).saturationModifier(0.8f).build();
	public static final FoodProperties PAELLA = new FoodProperties.Builder()
			.nutrition(8).saturationModifier(0.8f).build();
	public static final FoodProperties PIL_PIL_COD = new FoodProperties.Builder()
			.nutrition(8).saturationModifier(0.7f).build();
	public static final FoodProperties CROQUETTES = new FoodProperties.Builder()
			.nutrition(6).saturationModifier(0.6f).build();
	public static final FoodProperties BRAVA_POTATOES = new FoodProperties.Builder()
			.nutrition(6).saturationModifier(0.6f).build();
	public static final FoodProperties CHURRO = new FoodProperties.Builder()
			.nutrition(5).saturationModifier(0.6f).build();
	public static final FoodProperties GAZPACHO = new FoodProperties.Builder()
			.nutrition(6).saturationModifier(0.7f).build();
	public static final FoodProperties PANTUMACA = new FoodProperties.Builder()
			.nutrition(6).saturationModifier(0.7f).build();
	public static final FoodProperties FRIED_SQUID_RING = new FoodProperties.Builder()
			.nutrition(6).saturationModifier(0.5f).build();

	private SDFoodComponents() {}
}
