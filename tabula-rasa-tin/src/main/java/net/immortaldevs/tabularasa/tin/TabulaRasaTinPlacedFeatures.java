package net.immortaldevs.tabularasa.tin;

import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinPlacedFeatures {
    public static final PlacedFeature ORE_TIN = new PlacedFeature(
            RegistryEntry.of(TabulaRasaTinConfiguredFeatures.ORE_TIN),
            List.of(CountPlacementModifier.of(200),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.trapezoid(YOffset.fixed(-24), YOffset.fixed(56)),
                    BiomePlacementModifier.of()));

    public static void init() {
        Registry.register(BuiltinRegistries.PLACED_FEATURE, id("ore_tin"), ORE_TIN);
    }
}
