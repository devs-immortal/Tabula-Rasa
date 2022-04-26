package net.immortaldevs.tabularasa.aluminium;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.aluminium.TabulaRasaAluminium.id;

public final class TabulaRasaAluminiumBlocks {
    public static final OreBlock ALUMINIUM_ORE = new OreBlock(Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f));
    public static final OreBlock DEEPSLATE_ALUMINIUM_ORE = new OreBlock(Settings.copy(ALUMINIUM_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block ALUMINIUM_BLOCK = new Block(Settings.of(Material.METAL, MapColor.WHITE_GRAY).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_ALUMINIUM_BLOCK = new Block(Settings.of(Material.STONE, MapColor.TERRACOTTA_ORANGE).requiresTool().strength(5.0f, 6.0f));

    public static void init() {
        Registry.register(Registry.BLOCK, id("aluminium_ore"), ALUMINIUM_ORE);
        Registry.register(Registry.BLOCK, id("deepslate_aluminium_ore"), DEEPSLATE_ALUMINIUM_ORE);
        Registry.register(Registry.BLOCK, id("aluminium_block"), ALUMINIUM_BLOCK);
        Registry.register(Registry.BLOCK, id("deepslate_aluminium_block"), RAW_ALUMINIUM_BLOCK);
    }
}
