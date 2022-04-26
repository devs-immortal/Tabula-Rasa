package net.immortaldevs.tabularasa.zinc;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.zinc.TabulaRasaZinc.id;

public final class TabulaRasaZincBlockTags {
    public static final TagKey<Block> ZINC_ORES = TagKey.of(Registry.BLOCK_KEY, id("zinc_ores"));
}
