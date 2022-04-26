package net.immortaldevs.tabularasa.tin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public record TinVeinFeatureConfig(List<Target> targets) implements FeatureConfig {
    public static final Codec<TinVeinFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.list(Target.CODEC).fieldOf("targets")
                    .forGetter(TinVeinFeatureConfig::targets))
            .apply(instance, TinVeinFeatureConfig::new));

    public record Target(RuleTest target, BlockState state) {
        public static final Codec<Target> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                RuleTest.TYPE_CODEC.fieldOf("target")
                        .forGetter(Target::target),
                BlockState.CODEC.fieldOf("state")
                        .forGetter(Target::state))
                .apply(instance, Target::new));
    }
}
