package net.immortaldevs.tabularasa.zinc;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.zinc.TabulaRasaZinc.id;

public final class TabulaRasaZincItems {
    public static final BlockItem ZINC_ORE = new BlockItem(TabulaRasaZincBlocks.ZINC_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_ZINC_ORE = new BlockItem(TabulaRasaZincBlocks.DEEPSLATE_ZINC_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem RAW_ZINC_BLOCK = new BlockItem(TabulaRasaZincBlocks.RAW_ZINC_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem ZINC_BLOCK = new BlockItem(TabulaRasaZincBlocks.ZINC_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RAW_ZINC = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item ZINC_INGOT = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item ZINC_NUGGET = new Item(new Settings().group(ItemGroup.MATERIALS));

    public static void init() {
        Registry.register(Registry.ITEM, id("zinc_ore"), ZINC_ORE);
        Registry.register(Registry.ITEM, id("deepslate_zinc_ore"), DEEPSLATE_ZINC_ORE);
        Registry.register(Registry.ITEM, id("raw_zinc_block"), RAW_ZINC_BLOCK);
        Registry.register(Registry.ITEM, id("zinc_block"), ZINC_BLOCK);
        Registry.register(Registry.ITEM, id("raw_zinc"), RAW_ZINC);
        Registry.register(Registry.ITEM, id("zinc_ingot"), ZINC_INGOT);
        Registry.register(Registry.ITEM, id("zinc_nugget"), ZINC_NUGGET);
    }
}
