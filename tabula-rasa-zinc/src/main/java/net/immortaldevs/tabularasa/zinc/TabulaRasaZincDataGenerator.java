package net.immortaldevs.tabularasa.zinc;

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

public final class TabulaRasaZincDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(new FabricModelProvider(fabricDataGenerator) {
            @Override
            public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaZincBlocks.ZINC_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaZincBlocks.DEEPSLATE_ZINC_ORE);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaZincBlocks.ZINC_BLOCK);
                blockStateModelGenerator.registerSimpleCubeAll(TabulaRasaZincBlocks.RAW_ZINC_BLOCK);
            }

            @Override
            public void generateItemModels(ItemModelGenerator itemModelGenerator) {
                itemModelGenerator.register(TabulaRasaZincItems.RAW_ZINC, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaZincItems.ZINC_INGOT, Models.GENERATED);
                itemModelGenerator.register(TabulaRasaZincItems.ZINC_NUGGET, Models.GENERATED);
            }
        });

        FabricTagProvider.BlockTagProvider blockTagProvider;
        fabricDataGenerator.addProvider(blockTagProvider = new FabricTagProvider.BlockTagProvider(fabricDataGenerator) {
            @Override
            protected void generateTags() {
                this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS).add(TabulaRasaZincBlocks.ZINC_ORE);
                this.getOrCreateTagBuilder(TabulaRasaZincBlockTags.ZINC_ORES)
                        .add(TabulaRasaZincBlocks.ZINC_ORE, TabulaRasaZincBlocks.DEEPSLATE_ZINC_ORE);
                this.getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                        .add(TabulaRasaZincBlocks.ZINC_ORE, TabulaRasaZincBlocks.DEEPSLATE_ZINC_ORE,
                                TabulaRasaZincBlocks.ZINC_BLOCK, TabulaRasaZincBlocks.RAW_ZINC_BLOCK);
                this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                        .add(TabulaRasaZincBlocks.ZINC_ORE, TabulaRasaZincBlocks.DEEPSLATE_ZINC_ORE,
                                TabulaRasaZincBlocks.ZINC_BLOCK, TabulaRasaZincBlocks.RAW_ZINC_BLOCK);
            }
        });

        fabricDataGenerator.addProvider(new FabricTagProvider.ItemTagProvider(fabricDataGenerator, blockTagProvider) {
            @Override
            protected void generateTags() {
                this.copy(TabulaRasaZincBlockTags.ZINC_ORES, TabulaRasaZincItemTags.ZINC_ORES);
                this.getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(TabulaRasaZincItems.ZINC_INGOT);
            }
        });

        fabricDataGenerator.addProvider(new FabricRecipeProvider(fabricDataGenerator) {
            private static final ImmutableList<ItemConvertible> ZINC_ORES = ImmutableList.of(
                    TabulaRasaZincItems.ZINC_ORE,
                    TabulaRasaZincItems.DEEPSLATE_ZINC_ORE,
                    TabulaRasaZincItems.RAW_ZINC);

            @Override
            protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
                RecipeProvider.offerReversibleCompactingRecipesWithReverseRecipeGroup(exporter,
                        TabulaRasaZincItems.ZINC_INGOT, TabulaRasaZincItems.ZINC_BLOCK,
                        "zinc_ingot_from_zinc_block",
                        "zinc_ingot");
                RecipeProvider.offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter,
                        TabulaRasaZincItems.ZINC_NUGGET, TabulaRasaZincItems.ZINC_INGOT,
                        "zinc_ingot_from_nuggets",
                        "zinc_ingot");
                RecipeProvider.offerReversibleCompactingRecipes(exporter,
                        TabulaRasaZincItems.RAW_ZINC, TabulaRasaZincItems.RAW_ZINC_BLOCK);
                RecipeProvider.offerSmelting(exporter, ZINC_ORES, TabulaRasaZincItems.ZINC_INGOT,
                        0.7f, 200, "zinc_ingot");
                RecipeProvider.offerBlasting(exporter, ZINC_ORES, TabulaRasaZincItems.ZINC_INGOT,
                        0.7f, 100, "zinc_ingot");
            }
        });

        fabricDataGenerator.addProvider(new FabricBlockLootTableProvider(fabricDataGenerator) {
            @Override
            protected void generateBlockLootTables() {
                this.addDrop(TabulaRasaZincBlocks.ZINC_BLOCK);
                this.addDrop(TabulaRasaZincBlocks.RAW_ZINC_BLOCK);
                this.addDrop(TabulaRasaZincBlocks.ZINC_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaZincItems.RAW_ZINC));
                this.addDrop(TabulaRasaZincBlocks.DEEPSLATE_ZINC_ORE, block ->
                        BlockLootTableGenerator.oreDrops(block, TabulaRasaZincItems.RAW_ZINC));
            }
        });
    }
}
