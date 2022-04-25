package net.immortaldevs.tabularasa.lead;

import com.google.common.collect.ImmutableList;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.item.ItemConvertible;
import net.minecraft.tag.BlockTags;

import java.util.function.Consumer;

public final class TabulaRasaLeadDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new FabricModelProvider(fabricDataGenerator) {
            @Override
            public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaLeadBlocks.LEAD_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaLeadBlocks.DEEPSLATE_LEAD_ORE);
            }

            @Override
            public void generateItemModels(ItemModelGenerator itemModelGenerator) {
                itemModelGenerator.register(TabulaRasaLeadItems.RAW_LEAD, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaLeadItems.LEAD_INGOT, Models.GENERATED);
            }
        });

        FabricTagProvider.BlockTagProvider blockTagProvider;
        fabricDataGenerator.addProvider(blockTagProvider = new FabricTagProvider.BlockTagProvider(fabricDataGenerator) {
            @Override
            protected void generateTags() {
                this.getOrCreateTagBuilder(TabulaRasaLeadBlockTags.LEAD_ORES)
                        .add(TabulaRasaLeadBlocks.LEAD_ORE, TabulaRasaLeadBlocks.DEEPSLATE_LEAD_ORE);
                this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(TabulaRasaLeadBlocks.LEAD_ORE, TabulaRasaLeadBlocks.DEEPSLATE_LEAD_ORE);
                this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                        .add(TabulaRasaLeadBlocks.LEAD_ORE, TabulaRasaLeadBlocks.DEEPSLATE_LEAD_ORE);
            }
        });

        fabricDataGenerator.addProvider(new FabricTagProvider.ItemTagProvider(fabricDataGenerator, blockTagProvider) {
            @Override
            protected void generateTags() {
                this.copy(TabulaRasaLeadBlockTags.LEAD_ORES, TabulaRasaLeadItemTags.LEAD_ORES);
            }
        });

        fabricDataGenerator.addProvider(new FabricRecipeProvider(fabricDataGenerator) {
            private static final ImmutableList<ItemConvertible> LEAD_ORES = ImmutableList.of(
                    TabulaRasaLeadItems.LEAD_ORE,
                    TabulaRasaLeadItems.DEEPSLATE_LEAD_ORE,
                    TabulaRasaLeadItems.RAW_LEAD);

            @Override
            protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
                RecipeProvider.offerSmelting(exporter, LEAD_ORES, TabulaRasaLeadItems.LEAD_INGOT,
                        0.7f, 200, "lead_ingot");
                RecipeProvider.offerBlasting(exporter, LEAD_ORES, TabulaRasaLeadItems.LEAD_INGOT,
                        0.7f, 100, "lead_ingot");
            }
        });

        fabricDataGenerator.addProvider(new FabricBlockLootTableProvider(fabricDataGenerator) {
            @Override
            protected void generateBlockLootTables() {
                this.addDrop(TabulaRasaLeadBlocks.LEAD_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaLeadItems.RAW_LEAD));
                this.addDrop(TabulaRasaLeadBlocks.DEEPSLATE_LEAD_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaLeadItems.RAW_LEAD));
            }
        });
    }
}
