package net.immortaldevs.tabularasa.tin;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;
import static net.minecraft.world.gen.feature.OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES;
import static net.minecraft.world.gen.feature.OreConfiguredFeatures.STONE_ORE_REPLACEABLES;

public final class TabulaRasaTinConfiguredFeatures {
    public static final List<OreFeatureConfig.Target> TIN_ORES = List.of(
            OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES,
                    TabulaRasaTinBlocks.TIN_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES,
                    TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE.getDefaultState()));

    public static final ConfiguredFeature<OreFeatureConfig, ?> ORE_TIN
            = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(TIN_ORES, 9));

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("ore_tin"), ORE_TIN);
    }
}
