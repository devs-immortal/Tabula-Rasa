package net.immortaldevs.tabularasa.tin;

import net.minecraft.block.Blocks;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
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
    public static final ConfiguredFeature<AquiferOreVeinFeatureConfig, Feature<AquiferOreVeinFeatureConfig>> TIN_VEIN
            = new ConfiguredFeature<>(TabulaRasaTinFeatures.AQUIFER_ORE_VEIN, new AquiferOreVeinFeatureConfig(
                    FluidTags.WATER,
                    BiasedIntProvider.create(2, 4),
                    ConstantIntProvider.create(12),
                    UniformIntProvider.create(-7, 7),
                    UniformIntProvider.create(2, 7),
                    new OreFeatureConfig(
                            List.of(OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES,
                                            Blocks.PINK_STAINED_GLASS.getDefaultState()),
                                    OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES,
                                            Blocks.PINK_STAINED_GLASS.getDefaultState())),
                            7),
                    BiasedIntProvider.create(1, 3),
                    BiasedIntProvider.create(-3, 3),
                    BiasedIntProvider.create(0, 2),
                    new OreFeatureConfig(
                            List.of(OreFeatureConfig.createTarget(STONE_ORE_REPLACEABLES,
                                            Blocks.MAGENTA_STAINED_GLASS.getDefaultState()),
                                    OreFeatureConfig.createTarget(DEEPSLATE_ORE_REPLACEABLES,
                                            Blocks.MAGENTA_STAINED_GLASS.getDefaultState())),
                            33)));

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("tin_vein"), TIN_VEIN);
    }
}
