package net.immortaldevs.tabularasa.silver;

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

public final class TabulaRasaSilverDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new FabricModelProvider(fabricDataGenerator) {
            @Override
            public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaSilverBlocks.SILVER_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaSilverBlocks.DEEPSLATE_SILVER_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaSilverBlocks.SILVER_BLOCK);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaSilverBlocks.RAW_SILVER_BLOCK);
            }

            @Override
            public void generateItemModels(ItemModelGenerator itemModelGenerator) {
                itemModelGenerator.register(TabulaRasaSilverItems.RAW_SILVER, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaSilverItems.SILVER_INGOT, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaSilverItems.SILVER_NUGGET, Models.GENERATED);
            }
        });

        FabricTagProvider.BlockTagProvider blockTagProvider;
        fabricDataGenerator.addProvider(blockTagProvider = new FabricTagProvider.BlockTagProvider(fabricDataGenerator) {
            @Override
            protected void generateTags() {
                this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(TabulaRasaSilverBlocks.SILVER_ORE);
                this.getOrCreateTagBuilder(TabulaRasaSilverBlockTags.SILVER_ORES)
                        .add(TabulaRasaSilverBlocks.SILVER_ORE, TabulaRasaSilverBlocks.DEEPSLATE_SILVER_ORE);
                this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(TabulaRasaSilverBlocks.SILVER_ORE, TabulaRasaSilverBlocks.DEEPSLATE_SILVER_ORE,
                                TabulaRasaSilverBlocks.SILVER_BLOCK, TabulaRasaSilverBlocks.RAW_SILVER_BLOCK);
                this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                        .add(TabulaRasaSilverBlocks.SILVER_ORE, TabulaRasaSilverBlocks.DEEPSLATE_SILVER_ORE,
                                TabulaRasaSilverBlocks.SILVER_BLOCK, TabulaRasaSilverBlocks.RAW_SILVER_BLOCK);
            }
        });

        fabricDataGenerator.addProvider(new FabricTagProvider.ItemTagProvider(fabricDataGenerator, blockTagProvider) {
            @Override
            protected void generateTags() {
                this.copy(TabulaRasaSilverBlockTags.SILVER_ORES, TabulaRasaSilverItemTags.SILVER_ORES);
                this.getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(TabulaRasaSilverItems.SILVER_INGOT);
            }
        });

        fabricDataGenerator.addProvider(new FabricRecipeProvider(fabricDataGenerator) {
            private static final ImmutableList<ItemConvertible> SILVER_ORES = ImmutableList.of(
                    TabulaRasaSilverItems.SILVER_ORE,
                    TabulaRasaSilverItems.DEEPSLATE_SILVER_ORE,
                    TabulaRasaSilverItems.RAW_SILVER);

            @Override
            protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
                RecipeProvider.offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter,
                        TabulaRasaSilverItems.SILVER_INGOT, TabulaRasaSilverItems.SILVER_BLOCK,
                        "silver_ingot_from_silver_block",
                        "silver_ingot");
                RecipeProvider.offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter,
                        TabulaRasaSilverItems.SILVER_NUGGET, TabulaRasaSilverItems.SILVER_INGOT,
                        "silver_ingot_from_nuggets",
                        "silver_ingot");
                RecipeProvider.offerReversibleCompactingRecipes(exporter,
                        TabulaRasaSilverItems.RAW_SILVER, TabulaRasaSilverItems.RAW_SILVER_BLOCK);
                RecipeProvider.offerSmelting(exporter, SILVER_ORES, TabulaRasaSilverItems.SILVER_INGOT,
                        0.7f, 200, "silver_ingot");
                RecipeProvider.offerBlasting(exporter, SILVER_ORES, TabulaRasaSilverItems.SILVER_INGOT,
                        0.7f, 100, "silver_ingot");
            }
        });

        fabricDataGenerator.addProvider(new FabricBlockLootTableProvider(fabricDataGenerator) {
            @Override
            protected void generateBlockLootTables() {
                this.addDrop(TabulaRasaSilverBlocks.SILVER_BLOCK);
                this.addDrop(TabulaRasaSilverBlocks.RAW_SILVER_BLOCK);
                this.addDrop(TabulaRasaSilverBlocks.SILVER_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaSilverItems.RAW_SILVER));
                this.addDrop(TabulaRasaSilverBlocks.DEEPSLATE_SILVER_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaSilverItems.RAW_SILVER));
            }
        });
    }
}
