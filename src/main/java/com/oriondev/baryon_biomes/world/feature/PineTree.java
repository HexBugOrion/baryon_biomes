package com.oriondev.baryon_biomes.world.feature;

import com.oriondev.baryon_biomes.lists.BlockInit;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;


public class PineTree extends Tree {

    public static final TreeFeatureConfig PINE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(BlockInit.PINE_LOG.get().getDefaultState()), new SimpleBlockStateProvider(BlockInit.PINE_LEAVES.get().getDefaultState()), new BlobFoliagePlacer(2, 0))).baseHeight(7).heightRandA(5).foliageHeight(7).ignoreVines().setSapling((IPlantable) BlockInit.PINE_SAPLING.get()).build();

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean tre) {
        return Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG);
    }
}
