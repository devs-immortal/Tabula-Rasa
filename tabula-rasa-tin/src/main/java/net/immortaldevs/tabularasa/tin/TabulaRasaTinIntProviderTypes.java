package net.immortaldevs.tabularasa.tin;

import net.minecraft.util.math.intprovider.IntProviderType;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinIntProviderTypes {
    public static final IntProviderType<BiasedIntProvider> BIASED = () -> BiasedIntProvider.CODEC;

    public static void init() {
        Registry.register(Registry.INT_PROVIDER_TYPE, id("biased"), BIASED);
    }
}
