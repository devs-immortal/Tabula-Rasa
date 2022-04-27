package net.immortaldevs.tabularasa.tin;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinFeatures {
    public static final Feature<AquiferOreVeinFeatureConfig> AQUIFER_ORE_VEIN
            = new AquiferOreVeinFeature(AquiferOreVeinFeatureConfig.CODEC);

    public static void init() {
        Registry.register(Registry.FEATURE, id("aquifer_ore_vein"), AQUIFER_ORE_VEIN);
    }
}
