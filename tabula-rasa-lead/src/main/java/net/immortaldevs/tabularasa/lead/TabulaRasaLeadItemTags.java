package net.immortaldevs.tabularasa.lead;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.lead.TabulaRasaLead.id;

public final class TabulaRasaLeadItemTags {
    public static final TagKey<Item> LEAD_ORES = TagKey.of(Registry.ITEM_KEY, id("lead_ores"));
}
