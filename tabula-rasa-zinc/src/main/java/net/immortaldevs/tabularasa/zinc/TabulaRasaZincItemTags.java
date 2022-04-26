package net.immortaldevs.tabularasa.zinc;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.zinc.TabulaRasaZinc.id;

public final class TabulaRasaZincItemTags {
    public static final TagKey<Item> ZINC_ORES = TagKey.of(Registry.ITEM_KEY, id("zinc_ores"));
}
