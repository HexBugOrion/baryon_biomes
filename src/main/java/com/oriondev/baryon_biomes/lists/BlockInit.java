package com.oriondev.baryon_biomes.lists;

import com.oriondev.baryon_biomes.BaryonBiomes;
import com.oriondev.baryon_biomes.world.feature.PineTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, BaryonBiomes.MOD_ID);

    public static final RegistryObject<Block> PINE_LOG = BLOCKS.register("pine_log", () -> new LogBlock(MaterialColor.WOOD, Block.Properties.create(Material.WOOD).sound(SoundType.WOOD).hardnessAndResistance(2, 2)));
    public static final RegistryObject<Block> PINE_LEAVES = BLOCKS.register("pine_leaves", () -> new LeavesBlock(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.2f, 0.2f).notSolid()));
    public static final RegistryObject<Block> PINE_SAPLING = BLOCKS.register("pine_sapling", () -> new PineSapling(() -> new PineTree(), Block.Properties.from(Blocks.SPRUCE_SAPLING)));

}
