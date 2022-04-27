package net.immortaldevs.tabularasa.tin;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;

public final class TabulaRasaTin implements ModInitializer {
    public static final String TABULA_RASA_TIN = "tabula_rasa_tin";

    @Override
    public void onInitialize() {
        TabulaRasaTinBlocks.init();
        TabulaRasaTinItems.init();
        TabulaRasaTinRuleTestTypes.init();
        TabulaRasaTinIntProviderTypes.init();
        TabulaRasaTinFeatures.init();
        TabulaRasaTinConfiguredFeatures.init();
        TabulaRasaTinPlacedFeatures.init();

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(Registry.PLACED_FEATURE_KEY, id("ore_tin")));
    }

    public static Identifier id(String path) {
        return new Identifier(TABULA_RASA_TIN, path);
    }
}
