package net.immortaldevs.tabularasa.silver;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.silver.TabulaRasaSilver.id;

public final class TabulaRasaSilverItemTags {
    public static final TagKey<Item> SILVER_ORES = TagKey.of(Registry.ITEM_KEY, id("silver_ores"));
}
