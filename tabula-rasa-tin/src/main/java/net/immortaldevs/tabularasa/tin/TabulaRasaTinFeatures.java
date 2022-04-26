package net.immortaldevs.tabularasa.tin;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinFeatures {
    public static final Feature<TinVeinFeatureConfig> TIN_VEIN = new TinVeinFeature(TinVeinFeatureConfig.CODEC);

    public static void init() {
        Registry.register(Registry.FEATURE, id("tin_vein"), TIN_VEIN);
    }
}
