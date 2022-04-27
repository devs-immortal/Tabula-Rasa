package net.immortaldevs.tabularasa.tin;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinPlacedFeatures {
//    public static final PlacedFeature TIN_VEIN = new PlacedFeature(
//            RegistryEntry.of(TabulaRasaTinConfiguredFeatures.TIN_VEIN),
//            List.of(CountPlacementModifier.of(18),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(56)),
//                    SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG,
//                            Integer.MIN_VALUE, -24),
//                    BiomePlacementModifier.of()));

    public static final PlacedFeature TIN_VEIN = new PlacedFeature(
            RegistryEntry.of(TabulaRasaTinConfiguredFeatures.TIN_VEIN),
            List.of(CountPlacementModifier.of(18),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(56)),
                    SurfaceThresholdFilterPlacementModifier.of(Heightmap.Type.OCEAN_FLOOR_WG,
                            Integer.MIN_VALUE, -24),
                    BiomePlacementModifier.of()));

    public static void init() {
        Registry.register(BuiltinRegistries.PLACED_FEATURE, id("ore_tin"), TIN_VEIN);
    }
}
