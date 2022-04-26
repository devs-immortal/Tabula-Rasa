package net.immortaldevs.tabularasa.tin;

import com.mojang.serialization.Codec;
import net.immortaldevs.tabularasa.tin.TinVeinFeatureConfig.Target;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.tag.FluidTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class TinVeinFeature extends Feature<TinVeinFeatureConfig> {
    public TinVeinFeature(Codec<TinVeinFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<TinVeinFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        Random random = context.getRandom();
        TinVeinFeatureConfig config = context.getConfig();
        TagKey<Fluid> fluidTag = FluidTags.WATER;
        int fluidDistance = 3;

        if (isNotFluid(origin, world, fluidTag)) return false;

        BlockPos.Mutable pos = origin.mutableCopy();
        for (int i = 0; i < 12; i++) {
            pos.move(Direction.DOWN);

            if (isNotFluid(pos, world, fluidTag)) {
                if (i < fluidDistance) return false;
                else break;
            }
        }

        int reachDistance = random.nextInt(3);

        for (int i = -5; i < reachDistance; i++) {
            pos.move(Direction.DOWN);
            if (world.getBlockState(pos).isAir()) break;
        }

        pos.move(random.nextInt(11) - 5, 4, random.nextInt(11) - 5);

        BlockState state = world.getBlockState(pos);
        test: {
            for (Target target : config.targets()) {
                if (target.target().test(state, random)) break test;
            }

            return false;
        }

        world.setBlockState(pos, Blocks.CAMPFIRE.getDefaultState(), Block.NOTIFY_LISTENERS);
        return true;
    }

    private static boolean isNotFluid(BlockPos pos, StructureWorldAccess world, TagKey<Fluid> tag) {
        FluidState state = world.getFluidState(pos);
        return !state.isStill() || !state.isIn(tag);
    }
}
