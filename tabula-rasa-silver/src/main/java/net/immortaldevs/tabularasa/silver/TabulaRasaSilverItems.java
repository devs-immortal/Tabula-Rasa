package net.immortaldevs.tabularasa.silver;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Settings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.silver.TabulaRasaSilver.id;

public final class TabulaRasaSilverItems {
    public static final BlockItem SILVER_ORE = new BlockItem(TabulaRasaSilverBlocks.SILVER_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem DEEPSLATE_SILVER_ORE = new BlockItem(TabulaRasaSilverBlocks.DEEPSLATE_SILVER_ORE, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem RAW_SILVER_BLOCK = new BlockItem(TabulaRasaSilverBlocks.RAW_SILVER_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final BlockItem SILVER_BLOCK = new BlockItem(TabulaRasaSilverBlocks.SILVER_BLOCK, new Settings().group(ItemGroup.BUILDING_BLOCKS));
    public static final Item RAW_SILVER = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item SILVER_INGOT = new Item(new Settings().group(ItemGroup.MATERIALS));
    public static final Item SILVER_NUGGET = new Item(new Settings().group(ItemGroup.MATERIALS));

    public static void init() {
        Registry.register(Registry.ITEM, id("silver_ore"), SILVER_ORE);
        Registry.register(Registry.ITEM, id("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE);
        Registry.register(Registry.ITEM, id("raw_silver_block"), RAW_SILVER_BLOCK);
        Registry.register(Registry.ITEM, id("silver_block"), SILVER_BLOCK);
        Registry.register(Registry.ITEM, id("raw_silver"), RAW_SILVER);
        Registry.register(Registry.ITEM, id("silver_ingot"), SILVER_INGOT);
        Registry.register(Registry.ITEM, id("silver_nugget"), SILVER_NUGGET);
    }
}
