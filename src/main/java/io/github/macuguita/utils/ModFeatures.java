package io.github.macuguita.utils;

import io.github.macuguita.SpanishDelightRefabricated;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class ModFeatures {

    private static final RegistryKey<PlacedFeature> WILD_GARLIC = modFeature("wild_garlic_placement");
    private static final RegistryKey<PlacedFeature> WILD_RED_PEPPER = modFeature("wild_red_pepper_placement");
    private static final RegistryKey<PlacedFeature> WILD_GREEN_PEPPER = modFeature("wild_green_pepper_placement");

    @NotNull
    private static RegistryKey<PlacedFeature> modFeature(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SpanishDelightRefabricated.MOD_ID, name));
    }

    public static void init() {
        BiomeModifications.addFeature(new FDBiomeSelector(ModTags.Biomes.IS_PLAINS),
                GenerationStep.Feature.VEGETAL_DECORATION, WILD_GARLIC);
        BiomeModifications.addFeature(new FDBiomeSelector(ModTags.Biomes.IS_SAVANNA),
                GenerationStep.Feature.VEGETAL_DECORATION, WILD_RED_PEPPER);
        BiomeModifications.addFeature(new FDBiomeSelector(ModTags.Biomes.IS_TAIGA),
                GenerationStep.Feature.VEGETAL_DECORATION, WILD_GREEN_PEPPER);
    }

    public record FDBiomeSelector(float minTemperature, float maxTemperature, TagKey<Biome> allowed,
                                  @Nullable TagKey<Biome> denied) implements Predicate<BiomeSelectionContext> {

        public FDBiomeSelector(TagKey<Biome> tagKey) {
            this(-4f, 4f, tagKey, null);
        }

        @Override
        public boolean test(BiomeSelectionContext biomeSelectionContext) {
            RegistryEntry<Biome> biome = biomeSelectionContext.getBiomeRegistryEntry();
            float temp = biome.value().getTemperature();
            if (denied != null && biome.isIn(denied)) return false;
            return biome.isIn(allowed) && temp >= minTemperature && temp <= maxTemperature;
        }
    }
}