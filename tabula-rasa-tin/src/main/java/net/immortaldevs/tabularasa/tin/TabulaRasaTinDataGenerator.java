package net.immortaldevs.tabularasa.tin;

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

public final class TabulaRasaTinDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new FabricModelProvider(fabricDataGenerator) {
            @Override
            public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaTinBlocks.TIN_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaTinBlocks.TIN_BLOCK);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaTinBlocks.RAW_TIN_BLOCK);
            }

            @Override
            public void generateItemModels(ItemModelGenerator itemModelGenerator) {
                itemModelGenerator.register(TabulaRasaTinItems.RAW_TIN, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaTinItems.TIN_INGOT, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaTinItems.TIN_NUGGET, Models.GENERATED);
            }
        });

        FabricTagProvider.BlockTagProvider blockTagProvider;
        fabricDataGenerator.addProvider(blockTagProvider = new FabricTagProvider.BlockTagProvider(fabricDataGenerator) {
            @Override
            protected void generateTags() {
                this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(TabulaRasaTinBlocks.TIN_ORE);
                this.getOrCreateTagBuilder(TabulaRasaTinBlockTags.TIN_ORES)
                        .add(TabulaRasaTinBlocks.TIN_ORE, TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE);
                this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(TabulaRasaTinBlocks.TIN_ORE, TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE,
                                TabulaRasaTinBlocks.TIN_BLOCK, TabulaRasaTinBlocks.RAW_TIN_BLOCK);
                this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                        .add(TabulaRasaTinBlocks.TIN_ORE, TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE,
                                TabulaRasaTinBlocks.TIN_BLOCK, TabulaRasaTinBlocks.RAW_TIN_BLOCK);
            }
        });

        fabricDataGenerator.addProvider(new FabricTagProvider.ItemTagProvider(fabricDataGenerator, blockTagProvider) {
            @Override
            protected void generateTags() {
                this.copy(TabulaRasaTinBlockTags.TIN_ORES, TabulaRasaTinItemTags.TIN_ORES);
                this.getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(TabulaRasaTinItems.TIN_INGOT);
            }
        });

        fabricDataGenerator.addProvider(new FabricRecipeProvider(fabricDataGenerator) {
            private static final ImmutableList<ItemConvertible> TIN_ORES = ImmutableList.of(
                    TabulaRasaTinItems.TIN_ORE,
                    TabulaRasaTinItems.DEEPSLATE_TIN_ORE,
                    TabulaRasaTinItems.RAW_TIN);

            @Override
            protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
                RecipeProvider.offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter,
                        TabulaRasaTinItems.TIN_INGOT, TabulaRasaTinItems.TIN_BLOCK,
                        "tin_ingot_from_tin_block",
                        "tin_ingot");
                RecipeProvider.offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter,
                        TabulaRasaTinItems.TIN_NUGGET, TabulaRasaTinItems.TIN_INGOT,
                        "tin_ingot_from_nuggets",
                        "tin_ingot");
                RecipeProvider.offerReversibleCompactingRecipes(exporter,
                        TabulaRasaTinItems.RAW_TIN, TabulaRasaTinItems.RAW_TIN_BLOCK);
                RecipeProvider.offerSmelting(exporter, TIN_ORES, TabulaRasaTinItems.TIN_INGOT,
                        0.7f, 200, "tin_ingot");
                RecipeProvider.offerBlasting(exporter, TIN_ORES, TabulaRasaTinItems.TIN_INGOT,
                        0.7f, 100, "tin_ingot");
            }
        });

        fabricDataGenerator.addProvider(new FabricBlockLootTableProvider(fabricDataGenerator) {
            @Override
            protected void generateBlockLootTables() {
                this.addDrop(TabulaRasaTinBlocks.TIN_BLOCK);
                this.addDrop(TabulaRasaTinBlocks.RAW_TIN_BLOCK);
                this.addDrop(TabulaRasaTinBlocks.TIN_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaTinItems.RAW_TIN));
                this.addDrop(TabulaRasaTinBlocks.DEEPSLATE_TIN_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaTinItems.RAW_TIN));
            }
        });
    }
}
