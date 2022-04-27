package net.immortaldevs.tabularasa.tin;

import net.minecraft.structure.rule.RuleTestType;
import net.minecraft.util.registry.Registry;

public final class TabulaRasaTinRuleTestTypes {
    public static final RuleTestType<RandomTagMatchRuleTest> RANDOM_TAG_MATCH = () -> RandomTagMatchRuleTest.CODEC;

    public static void init() {
        Registry.register(Registry.RULE_TEST, TabulaRasaTin.id("random_tag_match"), RANDOM_TAG_MATCH);
    }
}
