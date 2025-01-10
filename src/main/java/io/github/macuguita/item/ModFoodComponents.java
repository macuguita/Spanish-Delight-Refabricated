package io.github.macuguita.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoodComponents {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes

    public static final FoodComponent SLICED_POTATO = new FoodComponent.Builder().hunger(1).saturationModifier(0.5f).build();
    public static final FoodComponent SLICED_ONION = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent GARLIC = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build();
    public static final FoodComponent GREEN_BEAN = new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).build();
    public static final FoodComponent PEPPER = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build();
    public static final FoodComponent SQUID_RING = new FoodComponent.Builder().hunger(1).saturationModifier(0.1f).build();

    public static final FoodComponent SPANISH_TORTILLA = new FoodComponent.Builder()
            .hunger(7).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION), 1.0f).build();
    public static final FoodComponent PAELLA = new FoodComponent.Builder()
            .hunger(8).saturationModifier(0.8f).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION), 1.0f).build();
    public static final FoodComponent PIL_PIL_COD = new FoodComponent.Builder()
            .hunger(8).saturationModifier(0.7f).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION), 1.0f).build();
    public static final FoodComponent CROQUETTES = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION), 1.0f).build();
    public static final FoodComponent BRAVA_POTATOES = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION), 1.0f).build();
    public static final FoodComponent CHURRO = new FoodComponent.Builder()
            .hunger(5).saturationModifier(0.6f).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION), 1.0f).build();
    public static final FoodComponent GAZPACHO = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.7f).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION), 1.0f).build();
    public static final FoodComponent PANTUMACA = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.7f).statusEffect(new StatusEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION), 1.0f).build();
    public static final FoodComponent FRIED_SQUID_RING = new FoodComponent.Builder()
            .hunger(6).saturationModifier(0.5f).statusEffect(new StatusEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION), 1.0f).build();

}
