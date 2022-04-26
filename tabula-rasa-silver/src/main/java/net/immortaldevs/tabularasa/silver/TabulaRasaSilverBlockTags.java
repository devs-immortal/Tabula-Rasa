package net.immortaldevs.tabularasa.silver;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.silver.TabulaRasaSilver.id;

public final class TabulaRasaSilverBlockTags {
    public static final TagKey<Block> SILVER_ORES = TagKey.of(Registry.BLOCK_KEY, id("silver_ores"));
}
