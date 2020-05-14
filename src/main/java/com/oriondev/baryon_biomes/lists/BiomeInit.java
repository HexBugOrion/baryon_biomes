package com.oriondev.baryon_biomes.lists;

import com.oriondev.baryon_biomes.BaryonBiomes;
import com.oriondev.baryon_biomes.world.biomes.PineForest;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, BaryonBiomes.MOD_ID);

    public static final RegistryObject<Biome> PINE_FOREST = BIOMES.register("pine_forest", ()-> new PineForest(new Biome.Builder().precipitation(Biome.RainType.RAIN).temperature(0.25f).waterColor(4159204).waterFogColor(329011).surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())).category(Biome.Category.TAIGA).scale(0.2f).downfall(0.2f).depth(0.8f).parent(null)));


    public static void registerBiomes()
    {
        registerBiome(PINE_FOREST.get(), BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types)
    {
        BiomeDictionary.addTypes(biome,types);
        BiomeManager.addSpawnBiome(biome);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));
    }


}
