package net.immortaldevs.tabularasa.lead;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.lead.TabulaRasaLead.id;

public final class TabulaRasaLeadItems {
    public static final BlockItem LEAD_ORE = new BlockItem(TabulaRasaLeadBlocks.LEAD_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_LEAD_ORE = new BlockItem(TabulaRasaLeadBlocks.DEEPSLATE_LEAD_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RAW_LEAD = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item LEAD_INGOT = new Item(new Settings().group(ItemGroup.MATERIALS));

    public static void init() {
        Registry.register(Registry.ITEM, id("lead_ore"), LEAD_ORE);
        Registry.register(Registry.ITEM, id("deepslate_lead_ore"), DEEPSLATE_LEAD_ORE);
        Registry.register(Registry.ITEM, id("raw_lead"), RAW_LEAD);
        Registry.register(Registry.ITEM, id("lead_ingot"), LEAD_INGOT);
    }
}
