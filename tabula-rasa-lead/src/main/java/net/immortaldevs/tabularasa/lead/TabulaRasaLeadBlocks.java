package net.immortaldevs.tabularasa.lead;

import net.minecraft.block.*;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

import static net.immortaldevs.tabularasa.lead.TabulaRasaLead.id;

public final class TabulaRasaLeadBlocks {
    public static final OreBlock LEAD_ORE = new OreBlock(Settings.of(Material.STONE).requiresTool().strength(3.0f, 3.0f));
    public static final OreBlock DEEPSLATE_LEAD_ORE = new OreBlock(Settings.copy(LEAD_ORE).mapColor(MapColor.DEEPSLATE_GRAY).strength(4.5f, 3.0f).sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block LEAD_BLOCK = new Block(AbstractBlock.Settings.of(Material.METAL, MapColor.TERRACOTTA_CYAN).requiresTool().strength(5.0f, 6.0f).sounds(BlockSoundGroup.METAL));
    public static final Block RAW_LEAD_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE, MapColor.TERRACOTTA_CYAN).requiresTool().strength(5.0f, 6.0f));

    public static void init() {
        Registry.register(Registry.BLOCK, id("lead_ore"), LEAD_ORE);
        Registry.register(Registry.BLOCK, id("deepslate_lead_ore"), DEEPSLATE_LEAD_ORE);
        Registry.register(Registry.BLOCK, id("lead_block"), LEAD_BLOCK);
        Registry.register(Registry.BLOCK, id("raw_lead_block"), RAW_LEAD_BLOCK);
    }
}
