package net.immortaldevs.tabularasa.tin;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.tin.TabulaRasaTin.id;

public final class TabulaRasaTinBlocks {
    public static final OreBlock TIN_ORE = new OreBlock(Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f));
    public static final OreBlock DEEPSLATE_TIN_ORE = new OreBlock(Settings.copy(TIN_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block TIN_BLOCK = new Block(Settings.of(Material.METAL, MapColor.WHITE_GRAY).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_TIN_BLOCK = new Block(Settings.of(Material.STONE, MapColor.GRAY).requiresTool().strength(5.0f, 6.0f));

    public static void init() {
        Registry.register(Registry.BLOCK, id("tin_ore"), TIN_ORE);
        Registry.register(Registry.BLOCK, id("deepslate_tin_ore"), DEEPSLATE_TIN_ORE);
        Registry.register(Registry.BLOCK, id("tin_block"), TIN_BLOCK);
        Registry.register(Registry.BLOCK, id("raw_tin_block"), RAW_TIN_BLOCK);
    }
}
