package net.kaupenjoe.scuffedmobs;

import com.mojang.logging.LogUtils;
import net.kaupenjoe.scuffedmobs.entity.ModEntities;
import net.kaupenjoe.scuffedmobs.entity.client.ArmadilloRenderer;
import net.kaupenjoe.scuffedmobs.entity.client.CrabRenderer;
import net.kaupenjoe.scuffedmobs.entity.client.PenguinModel;
import net.kaupenjoe.scuffedmobs.entity.client.PenguinRenderer;
import net.kaupenjoe.scuffedmobs.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ScuffedMobsMod.MOD_ID)
public class ScuffedMobsMod {
    public static final String MOD_ID = "kj_scuffed_mobs";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ScuffedMobsMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CRAB_CLAW);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntities.CRAB.get(), CrabRenderer::new);
            EntityRenderers.register(ModEntities.PENGUIN.get(), PenguinRenderer::new);
            EntityRenderers.register(ModEntities.ARMADILLO.get(), ArmadilloRenderer::new);
        }
    }
}
