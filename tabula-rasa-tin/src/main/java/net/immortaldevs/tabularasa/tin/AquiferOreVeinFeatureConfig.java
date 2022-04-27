package net.immortaldevs.tabularasa.tin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.fluid.Fluid;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public record AquiferOreVeinFeatureConfig(TagKey<Fluid> fluids,
                                          IntProvider minDepth,
                                          IntProvider maxDepth,
                                          IntProvider smallVeinSpread,
                                          IntProvider smallVeinCount,
                                          OreFeatureConfig smallVein,
                                          IntProvider largeVeinDepth,
                                          IntProvider largeVeinSpread,
                                          IntProvider largeVeinCount,
                                          OreFeatureConfig largeVein) implements FeatureConfig {
    public static final Codec<AquiferOreVeinFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    TagKey.stringCodec(Registry.FLUID_KEY).fieldOf("fluids")
                            .forGetter(AquiferOreVeinFeatureConfig::fluids),
                    IntProvider.createValidatingCodec(0, 24).fieldOf("min_depth")
                            .forGetter(AquiferOreVeinFeatureConfig::minDepth),
                    IntProvider.createValidatingCodec(0, 48).fieldOf("max_depth")
                            .forGetter(AquiferOreVeinFeatureConfig::maxDepth),
                    IntProvider.createValidatingCodec(-24, 24).fieldOf("small_vein_spread")
                            .forGetter(AquiferOreVeinFeatureConfig::smallVeinSpread),
                    IntProvider.createValidatingCodec(0, 24).fieldOf("small_vein_count")
                            .forGetter(AquiferOreVeinFeatureConfig::smallVeinCount),
                    OreFeatureConfig.CODEC.fieldOf("small_vein")
                            .forGetter(AquiferOreVeinFeatureConfig::smallVein),
                    IntProvider.createValidatingCodec(1, 24).fieldOf("large_vein_depth")
                            .forGetter(AquiferOreVeinFeatureConfig::largeVeinDepth),
                    IntProvider.createValidatingCodec(-24, 24).fieldOf("large_vein_spread")
                            .forGetter(AquiferOreVeinFeatureConfig::largeVeinSpread),
                    IntProvider.createValidatingCodec(0, 3).fieldOf("large_vein_count")
                            .forGetter(AquiferOreVeinFeatureConfig::largeVeinCount),
                    OreFeatureConfig.CODEC.fieldOf("large_vein")
                            .forGetter(AquiferOreVeinFeatureConfig::largeVein))
            .apply(instance, AquiferOreVeinFeatureConfig::new));
}
