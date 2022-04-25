package net.immortaldevs.tabularasa.lead;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.lead.TabulaRasaLead.id;

public final class TabulaRasaLeadBlockTags {
    public static final TagKey<Block> LEAD_ORES = TagKey.of(Registry.BLOCK_KEY, id("lead_ores"));
}
