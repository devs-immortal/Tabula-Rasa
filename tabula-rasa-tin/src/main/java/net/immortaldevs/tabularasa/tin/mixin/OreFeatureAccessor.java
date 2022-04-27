package net.immortaldevs.tabularasa.tin.mixin;

import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.Random;

@Mixin(OreFeature.class)
public interface OreFeatureAccessor {
    @Invoker
    boolean callGenerateVeinPart(StructureWorldAccess world, Random random, OreFeatureConfig config, double startX, double endX, double startZ, double endZ, double startY, double endY, int x, int y, int z, int horizontalSize, int verticalSize);
}
