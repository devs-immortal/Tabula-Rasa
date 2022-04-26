package net.immortaldevs.tabularasa.tin;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinItems {
    public static final BlockItem TIN_ORE = new BlockItem(TabulaRasaTinBlocks.TIN_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_TIN_ORE = new BlockItem(TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem RAW_TIN_BLOCK = new BlockItem(TabulaRasaTinBlocks.RAW_TIN_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem TIN_BLOCK = new BlockItem(TabulaRasaTinBlocks.TIN_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RAW_TIN = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item TIN_INGOT = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item TIN_NUGGET = new Item(new Settings().group(ItemGroup.MATERIALS));

    public static void init() {
        Registry.register(Registry.ITEM, id("tin_ore"), TIN_ORE);
        Registry.register(Registry.ITEM, id("deepslate_tin_ore"), DEEPSLATE_TIN_ORE);
        Registry.register(Registry.ITEM, id("raw_tin_block"), RAW_TIN_BLOCK);
        Registry.register(Registry.ITEM, id("tin_block"), TIN_BLOCK);
        Registry.register(Registry.ITEM, id("raw_tin"), RAW_TIN);
        Registry.register(Registry.ITEM, id("tin_ingot"), TIN_INGOT);
        Registry.register(Registry.ITEM, id("tin_nugget"), TIN_NUGGET);
    }
}
