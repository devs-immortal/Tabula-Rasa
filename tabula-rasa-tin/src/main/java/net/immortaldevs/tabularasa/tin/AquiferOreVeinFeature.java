package net.immortaldevs.tabularasa.tin;

import com.mojang.serialization.Codec;
import net.immortaldevs.tabularasa.tin.mixin.OreFeatureAccessor;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class AquiferOreVeinFeature extends Feature<AquiferOreVeinFeatureConfig> {
    public AquiferOreVeinFeature(Codec<AquiferOreVeinFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<AquiferOreVeinFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        AquiferOreVeinFeatureConfig config = context.getConfig();
        TagKey<Fluid> fluidTag = config.fluids();

        if (isNotFluid(origin, world, fluidTag)) return false;

        Random random = context.getRandom();
        int minDepth = config.minDepth().get(random);
        int maxDepth = config.maxDepth().get(random);

        BlockPos.Mutable pos = origin.mutableCopy();
        for (int i = 0; i < maxDepth; i++) {
            pos.move(Direction.DOWN);

            if (isNotFluid(pos, world, fluidTag)) {
                if (i < minDepth) return false;
                else break;
            }
        }

        boolean success = false;

        int smallVeinCount = config.smallVeinCount().get(random);
        for (int i = 0; i < smallVeinCount; i++) {
            success |= generateVeinPart(random,
                    config.smallVein(),
                    pos.add(config.smallVeinSpread().get(random),
                            2,
                            config.smallVeinSpread().get(random)),
                    world);
        }

        int largeVeinCount = config.largeVeinCount().get(random);
        for (int i = 0; i < largeVeinCount; i++) {
            BlockPos.Mutable deepPos = pos.mutableCopy();
            deepPos.move(config.largeVeinSpread().get(random),
                    0,
                    config.largeVeinSpread().get(random));

            int largeVeinDepth = config.largeVeinDepth().get(random);
            for (int j = 0; j < largeVeinDepth; j++) {
                deepPos.move(Direction.DOWN);
                if (world.getBlockState(deepPos).isAir()) break;
            }

            success |= generateVeinPart(random,
                    config.largeVein(),
                    deepPos,
                    world);
        }

        return success;
    }

    private static boolean generateVeinPart(Random random,
                                            OreFeatureConfig oreConfig,
                                            BlockPos pos,
                                            StructureWorldAccess world) {
        float shape = random.nextFloat() * MathHelper.PI;
        float size = oreConfig.size / 8f;
        int i = MathHelper.ceil((size + 1f) / 2f);

        double sin = Math.sin(shape) * size;
        double cos = Math.cos(shape) * size;

        double startX = pos.getX() + sin;
        double endX = pos.getX() - sin;
        double startZ = pos.getZ() + cos;
        double endZ = pos.getZ() - cos;
        double startY = pos.getY() + random.nextInt(3) - 2;
        double endY = pos.getY() + random.nextInt(3) - 2;

        int x = pos.getX() - MathHelper.ceil(size) - i;
        int y = pos.getY() - 2 - i;
        int z = pos.getZ() - MathHelper.ceil(size) - i;

        int horizontalSize = 2 * (MathHelper.ceil(size) + i);
        int verticalSize = 2 * (2 + i);

        return ((OreFeatureAccessor) Feature.ORE).callGenerateVeinPart(world, random, oreConfig,
                startX, endX, startZ, endZ, startY, endY, x, y, z, horizontalSize, verticalSize);
    }

    private static boolean isNotFluid(BlockPos pos, StructureWorldAccess world, TagKey<Fluid> tag) {
        FluidState state = world.getFluidState(pos);
        return !state.isStill() || !state.isIn(tag);
    }
}
