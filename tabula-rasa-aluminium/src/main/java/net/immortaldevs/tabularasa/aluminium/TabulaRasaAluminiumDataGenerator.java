package net.immortaldevs.tabularasa.aluminium;

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
import net.minecraft.tag.ItemTags;

import java.util.function.Consumer;

public final class TabulaRasaAluminiumDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new FabricModelProvider(fabricDataGenerator) {
            @Override
            public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaAluminiumBlocks.ALUMINIUM_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaAluminiumBlocks.DEEPSLATE_ALUMINIUM_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaAluminiumBlocks.ALUMINIUM_BLOCK);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaAluminiumBlocks.RAW_ALUMINIUM_BLOCK);
            }

            @Override
            public void generateItemModels(ItemModelGenerator itemModelGenerator) {
                itemModelGenerator.register(TabulaRasaAluminiumItems.RAW_ALUMINIUM, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaAluminiumItems.ALUMINIUM_INGOT, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaAluminiumItems.ALUMINIUM_NUGGET, Models.GENERATED);
            }
        });

        FabricTagProvider.BlockTagProvider blockTagProvider;
        fabricDataGenerator.addProvider(blockTagProvider = new FabricTagProvider.BlockTagProvider(fabricDataGenerator) {
            @Override
            protected void generateTags() {
                this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(TabulaRasaAluminiumBlocks.ALUMINIUM_ORE);
                this.getOrCreateTagBuilder(TabulaRasaAluminiumBlockTags.ALUMINIUM_ORES)
                        .add(TabulaRasaAluminiumBlocks.ALUMINIUM_ORE, TabulaRasaAluminiumBlocks.DEEPSLATE_ALUMINIUM_ORE);
                this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(TabulaRasaAluminiumBlocks.ALUMINIUM_ORE, TabulaRasaAluminiumBlocks.DEEPSLATE_ALUMINIUM_ORE,
                                TabulaRasaAluminiumBlocks.ALUMINIUM_BLOCK, TabulaRasaAluminiumBlocks.RAW_ALUMINIUM_BLOCK);
                this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                        .add(TabulaRasaAluminiumBlocks.ALUMINIUM_ORE, TabulaRasaAluminiumBlocks.DEEPSLATE_ALUMINIUM_ORE,
                                TabulaRasaAluminiumBlocks.ALUMINIUM_BLOCK, TabulaRasaAluminiumBlocks.RAW_ALUMINIUM_BLOCK);
            }
        });

        fabricDataGenerator.addProvider(new FabricTagProvider.ItemTagProvider(fabricDataGenerator, blockTagProvider) {
            @Override
            protected void generateTags() {
                this.copy(TabulaRasaAluminiumBlockTags.ALUMINIUM_ORES, TabulaRasaAluminiumItemTags.ALUMINIUM_ORES);
                this.getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(TabulaRasaAluminiumItems.ALUMINIUM_INGOT);
            }
        });

        fabricDataGenerator.addProvider(new FabricRecipeProvider(fabricDataGenerator) {
            private static final ImmutableList<ItemConvertible> ALUMINIUM_ORES = ImmutableList.of(
                    TabulaRasaAluminiumItems.ALUMINIUM_ORE,
                    TabulaRasaAluminiumItems.DEEPSLATE_ALUMINIUM_ORE,
                    TabulaRasaAluminiumItems.RAW_ALUMINIUM);

            @Override
            protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
                RecipeProvider.offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter,
                        TabulaRasaAluminiumItems.ALUMINIUM_INGOT, TabulaRasaAluminiumItems.ALUMINIUM_BLOCK,
                        "aluminium_ingot_from_aluminium_block",
                        "aluminium_ingot");
                RecipeProvider.offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter,
                        TabulaRasaAluminiumItems.ALUMINIUM_NUGGET, TabulaRasaAluminiumItems.ALUMINIUM_INGOT,
                        "aluminium_ingot_from_nuggets",
                        "aluminium_ingot");
                RecipeProvider.offerReversibleCompactingRecipes(exporter,
                        TabulaRasaAluminiumItems.RAW_ALUMINIUM, TabulaRasaAluminiumItems.RAW_ALUMINIUM_BLOCK);
                RecipeProvider.offerSmelting(exporter, ALUMINIUM_ORES, TabulaRasaAluminiumItems.ALUMINIUM_INGOT,
                        0.7f, 200, "aluminium_ingot");
                RecipeProvider.offerBlasting(exporter, ALUMINIUM_ORES, TabulaRasaAluminiumItems.ALUMINIUM_INGOT,
                        0.7f, 100, "aluminium_ingot");
            }
        });

        fabricDataGenerator.addProvider(new FabricBlockLootTableProvider(fabricDataGenerator) {
            @Override
            protected void generateBlockLootTables() {
                this.addDrop(TabulaRasaAluminiumBlocks.ALUMINIUM_BLOCK);
                this.addDrop(TabulaRasaAluminiumBlocks.RAW_ALUMINIUM_BLOCK);
                this.addDrop(TabulaRasaAluminiumBlocks.ALUMINIUM_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaAluminiumItems.RAW_ALUMINIUM));
                this.addDrop(TabulaRasaAluminiumBlocks.DEEPSLATE_ALUMINIUM_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaAluminiumItems.RAW_ALUMINIUM));
            }
        });
    }
}
