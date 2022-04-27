package net.immortaldevs.tabularasa.tin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.IntProviderType;

import java.util.Random;

public class BiasedIntProvider extends IntProvider {
    public static final Codec<BiasedIntProvider> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                    Codec.INT.fieldOf("min")
                            .forGetter(BiasedIntProvider::getMin),
                    Codec.INT.fieldOf("max")
                            .forGetter(BiasedIntProvider::getMax))
            .apply(instance, BiasedIntProvider::new));

    private final int min;
    private final int max;

    private BiasedIntProvider(int min, int max) {
        this.min = min;
        this.max = max + 1;
    }

    public static BiasedIntProvider create(int min, int max) {
        return new BiasedIntProvider(min, max);
    }

    @Override
    public int get(Random random) {
        return (random.nextInt(min, max) + random.nextInt(min, max)) >> 1;
    }

    @Override
    public int getMin() {
        return this.min;
    }

    @Override
    public int getMax() {
        return this.max - 1;
    }

    @Override
    public IntProviderType<?> getType() {
        return TabulaRasaTinIntProviderTypes.BIASED;
    }
}
