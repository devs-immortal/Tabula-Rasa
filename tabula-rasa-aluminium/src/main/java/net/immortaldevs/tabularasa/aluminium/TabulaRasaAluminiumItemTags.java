package net.immortaldevs.tabularasa.aluminium;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.aluminium.TabulaRasaAluminium.id;

public final class TabulaRasaAluminiumItemTags {
    public static final TagKey<Item> ALUMINIUM_ORES = TagKey.of(Registry.ITEM_KEY, id("aluminium_ores"));
}
