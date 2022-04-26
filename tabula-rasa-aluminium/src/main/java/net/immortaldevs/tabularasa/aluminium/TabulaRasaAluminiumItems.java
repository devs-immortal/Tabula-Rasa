package net.immortaldevs.tabularasa.aluminium;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.aluminium.TabulaRasaAluminium.id;

public final class TabulaRasaAluminiumItems {
    public static final BlockItem ALUMINIUM_ORE = new BlockItem(TabulaRasaAluminiumBlocks.ALUMINIUM_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_ALUMINIUM_ORE = new BlockItem(TabulaRasaAluminiumBlocks.DEEPSLATE_ALUMINIUM_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem RAW_ALUMINIUM_BLOCK = new BlockItem(TabulaRasaAluminiumBlocks.RAW_ALUMINIUM_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem ALUMINIUM_BLOCK = new BlockItem(TabulaRasaAluminiumBlocks.ALUMINIUM_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RAW_ALUMINIUM = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item ALUMINIUM_INGOT = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item ALUMINIUM_NUGGET = new Item(new Settings().group(ItemGroup.MATERIALS));

    public static void init() {
        Registry.register(Registry.ITEM, id("aluminium_ore"), ALUMINIUM_ORE);
        Registry.register(Registry.ITEM, id("deepslate_aluminium_ore"), DEEPSLATE_ALUMINIUM_ORE);
        Registry.register(Registry.ITEM, id("raw_aluminium_block"), RAW_ALUMINIUM_BLOCK);
        Registry.register(Registry.ITEM, id("aluminium_block"), ALUMINIUM_BLOCK);
        Registry.register(Registry.ITEM, id("raw_aluminium"), RAW_ALUMINIUM);
        Registry.register(Registry.ITEM, id("aluminium_ingot"), ALUMINIUM_INGOT);
        Registry.register(Registry.ITEM, id("aluminium_nugget"), ALUMINIUM_NUGGET);
    }
}
