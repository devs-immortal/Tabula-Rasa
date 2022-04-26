package net.immortaldevs.tabularasa.tin;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinBlockTags {
    public static final TagKey<Block> TIN_ORES = TagKey.of(Registry.BLOCK_KEY, id("tin_ores"));
}
