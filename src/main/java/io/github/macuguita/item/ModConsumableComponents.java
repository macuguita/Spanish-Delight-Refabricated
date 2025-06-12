package io.github.macuguita.item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModConsumableComponents {

    private static final int BRIEF_DURATION = 600;    // 30 seconds
    private static final int SHORT_DURATION = 1200;    // 1 minute
    private static final int MEDIUM_DURATION = 3600;    // 3 minutes
    private static final int LONG_DURATION = 6000;    // 5 minutes

    public static final ConsumableComponent SPANISH_TORTILLA = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.NOURISHMENT, LONG_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent PAELLA = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.COMFORT, LONG_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent PIL_PIL_COD = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.COMFORT, LONG_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent CROQUETTES = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.NOURISHMENT, SHORT_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent BRAVA_POTATOES = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.COMFORT, MEDIUM_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent CHURRO = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.COMFORT, SHORT_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent GAZPACHO = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.NOURISHMENT, SHORT_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent PANTUMACA = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.NOURISHMENT, MEDIUM_DURATION), 1.0f))
            .build();
    public static final ConsumableComponent FRIED_SQUID_RING = ConsumableComponents.food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(ModEffects.COMFORT, SHORT_DURATION), 1.0f))
            .build();
}
