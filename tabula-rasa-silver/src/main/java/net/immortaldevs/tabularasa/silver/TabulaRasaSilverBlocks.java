package net.immortaldevs.tabularasa.silver;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.silver.TabulaRasaSilver.id;

public final class TabulaRasaSilverBlocks {
    public static final OreBlock SILVER_ORE = new OreBlock(Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f));
    public static final OreBlock DEEPSLATE_SILVER_ORE = new OreBlock(Settings.copy(SILVER_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block SILVER_BLOCK = new Block(Settings.of(Material.METAL, MapColor.WHITE).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_SILVER_BLOCK = new Block(Settings.of(Material.STONE, MapColor.TERRACOTTA_CYAN).requiresTool().strength(5.0f, 6.0f));

    public static void init() {
        Registry.register(Registry.BLOCK, id("silver_ore"), SILVER_ORE);
        Registry.register(Registry.BLOCK, id("deepslate_silver_ore"), DEEPSLATE_SILVER_ORE);
        Registry.register(Registry.BLOCK, id("silver_block"), SILVER_BLOCK);
        Registry.register(Registry.BLOCK, id("raw_silver_block"), RAW_SILVER_BLOCK);
    }
}
