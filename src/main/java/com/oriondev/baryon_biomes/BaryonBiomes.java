package com.oriondev.baryon_biomes;


import com.oriondev.baryon_biomes.lists.BiomeInit;
import com.oriondev.baryon_biomes.lists.BlockInit;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("baryon_biomes")
@Mod.EventBusSubscriber(modid = BaryonBiomes.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaryonBiomes
{

    public static BaryonBiomes instance;
    public static final String MOD_ID = "baryon_biomes";
    public static final Logger LOGGER = LogManager.getLogger();

    public BaryonBiomes()
    {
        instance = this;

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::Setup);
        modEventBus.addListener(this::ClientSetup);

        BlockInit.BLOCKS.register(modEventBus);
        BiomeInit.BIOMES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();

        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {

            final Item.Properties properties = new Item.Properties().group(BaryonBiomesGroup.instance);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);

        });
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event)
    {
        BiomeInit.registerBiomes();

    }

        private void Setup ( final FMLCommonSetupEvent event)
        {

        }

        private void ClientSetup ( final FMLClientSetupEvent event)
        {

        }

        public void onServerStarting (FMLServerStartingEvent event)
        {

        }

        public static class BaryonBiomesGroup extends ItemGroup{

            public static final BaryonBiomesGroup instance = new BaryonBiomesGroup(ItemGroup.GROUPS.length, "baryon_biomes_group");
            private BaryonBiomesGroup(int index, String label)
            {

                super(index, label);

            }

            @Override
            public ItemStack createIcon() {
                return new ItemStack(Blocks.SPRUCE_SAPLING);
            }

        }

    }

