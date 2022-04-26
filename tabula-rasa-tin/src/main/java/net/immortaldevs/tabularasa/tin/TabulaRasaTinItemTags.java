package net.immortaldevs.tabularasa.tin;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinItemTags {
    public static final TagKey<Item> TIN_ORES = TagKey.of(Registry.ITEM_KEY, id("tin_ores"));
}
