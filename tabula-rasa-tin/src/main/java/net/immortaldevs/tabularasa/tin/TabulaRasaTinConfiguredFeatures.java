package net.immortaldevs.tabularasa.tin;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;

import java.util.List;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;
import static net.minecraft.world.gen.feature.OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES;
import static net.minecraft.world.gen.feature.OreConfiguredFeatures.STONE_ORE_REPLACEABLES;

public final class TabulaRasaTinConfiguredFeatures {
    public static final List<TinVeinFeatureConfig.Target> TIN_ORES = List.of(
            new TinVeinFeatureConfig.Target(STONE_ORE_REPLACEABLES,
                    TabulaRasaTinBlocks.TIN_ORE.getDefaultState()),
            new TinVeinFeatureConfig.Target(DEEPSLATE_ORE_REPLACEABLES,
                    TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));

    public static final ConfiguredFeature<TinVeinFeatureConfig, Feature<TinVeinFeatureConfig>> TIN_VEIN
            = new ConfiguredFeature<>(TabulaRasaTinFeatures.TIN_VEIN, new TinVeinFeatureConfig(TIN_ORES));

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("tin_vein"), TIN_VEIN);
    }
}
