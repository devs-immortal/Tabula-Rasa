package net.immortaldevs.tabularasa.tin;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.RuleTestType;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import java.util.Random;

public final class RandomTagMatchRuleTest extends RuleTest {
    public static final Codec<RandomTagMatchRuleTest> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.identifierCodec(Registry.BLOCK_KEY).fieldOf("tag")
                    .forGetter(randomTagMatchRuleTest -> randomTagMatchRuleTest.tag),
            Codec.FLOAT.fieldOf("probability")
                    .forGetter(randomBlockMatchRuleTest -> randomBlockMatchRuleTest.probability))
            .apply(instance, RandomTagMatchRuleTest::new));

    private final TagKey<Block> tag;
    private final float probability;

    public RandomTagMatchRuleTest(TagKey<Block> tag, float probability) {
        this.tag = tag;
        this.probability = probability;
    }

    @Override
    public boolean test(BlockState state, Random random) {
        return state.isIn(this.tag) && random.nextFloat() < this.probability;
    }

    @Override
    protected RuleTestType<?> getType() {
        return TabulaRasaTinRuleTestTypes.RANDOM_TAG_MATCH;
    }
}
