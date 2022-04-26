package net.immortaldevs.tabularasa.aluminium;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.aluminium.TabulaRasaAluminium.id;

public final class TabulaRasaAluminiumBlockTags {
    public static final TagKey<Block> ALUMINIUM_ORES = TagKey.of(Registry.BLOCK_KEY, id("aluminium_ores"));
}
