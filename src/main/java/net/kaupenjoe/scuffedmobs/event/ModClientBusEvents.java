package net.kaupenjoe.scuffedmobs.event;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.kaupenjoe.scuffedmobs.entity.client.ArmadilloModel;
import net.kaupenjoe.scuffedmobs.entity.client.CrabModel;
import net.kaupenjoe.scuffedmobs.entity.client.PenguinModel;
import net.kaupenjoe.scuffedmobs.entity.layers.ModModelLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ScuffedMobsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.CRAB_LAYER, CrabModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.PENGUIN_LAYER, PenguinModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.ARMADILLO_LAYER, ArmadilloModel::createBodyLayer);
    }
}
