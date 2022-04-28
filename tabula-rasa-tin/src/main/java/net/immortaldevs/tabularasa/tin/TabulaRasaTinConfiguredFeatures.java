package net.immortaldevs.tabularasa.tin;

import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinConfiguredFeatures {
    public static final ConfiguredFeature<AquiferOreVeinFeatureConfig, Feature<AquiferOreVeinFeatureConfig>> TIN_VEIN
            = new ConfiguredFeature<>(TabulaRasaTinFeatures.AQUIFER_ORE_VEIN, new AquiferOreVeinFeatureConfig(
                    FluidTags.WATER,
                    BiasedIntProvider.create(2, 4),
                    ConstantIntProvider.create(12),
                    UniformIntProvider.create(-9, 9),
                    UniformIntProvider.create(2, 7),
                    new OreFeatureConfig(
                            List.of(OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES,
                                            TabulaRasaTinBlocks.TIN_ORE.getDefaultState()),
                                    OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
                                            TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE.getDefaultState())),
                            7),
                    BiasedIntProvider.create(1, 3),
                    BiasedIntProvider.create(-3, 3),
                    BiasedIntProvider.create(0, 2),
                    new OreFeatureConfig(
                            List.of(OreFeatureConfig.createTarget(new RandomTagMatchRuleTest(
                                                    BlockTags.STONE_ORE_REPLACEABLES,
                                                    0.7f),
                                            TabulaRasaTinBlocks.TIN_ORE.getDefaultState()),
                                    OreFeatureConfig.createTarget(new RandomTagMatchRuleTest(
                                                    BlockTags.DEEPSLATE_ORE_REPLACEABLES,
                                                    0.7f),
                                            TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE.getDefaultState()),
                                    OreFeatureConfig.createTarget(new RandomTagMatchRuleTest(
                                                    BlockTags.STONE_ORE_REPLACEABLES,
                                                    0.2f),
                                            TabulaRasaTinBlocks.RAW_TIN_BLOCK.getDefaultState()),
                                    OreFeatureConfig.createTarget(new RandomTagMatchRuleTest(
                                                    BlockTags.DEEPSLATE_ORE_REPLACEABLES,
                                                    0.2f),
                                            TabulaRasaTinBlocks.RAW_TIN_BLOCK.getDefaultState())),
                            42)));

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, id("tin_vein"), TIN_VEIN);
    }
}
