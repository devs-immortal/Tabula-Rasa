package net.immortaldevs.tabularasa.zinc;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.zinc.TabulaRasaZinc.id;

public final class TabulaRasaZincBlocks {
    public static final OreBlock ZINC_ORE = new OreBlock(Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f));
    public static final OreBlock DEEPSLATE_ZINC_ORE = new OreBlock(Settings.copy(ZINC_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block ZINC_BLOCK = new Block(Settings.of(Material.METAL, MapColor.TERRACOTTA_CYAN).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_ZINC_BLOCK = new Block(Settings.of(Material.STONE, MapColor.TERRACOTTA_CYAN).requiresTool().strength(5.0f, 6.0f));

    public static void init() {
        Registry.register(Registry.BLOCK, id("zinc_ore"), ZINC_ORE);
        Registry.register(Registry.BLOCK, id("deepslate_zinc_ore"), DEEPSLATE_ZINC_ORE);
        Registry.register(Registry.BLOCK, id("zinc_block"), ZINC_BLOCK);
        Registry.register(Registry.BLOCK, id("deepslate_zinc_block"), RAW_ZINC_BLOCK);
    }
}
