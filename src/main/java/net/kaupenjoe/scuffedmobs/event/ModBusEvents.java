package net.kaupenjoe.scuffedmobs.event;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.kaupenjoe.scuffedmobs.entity.ModEntities;
import net.kaupenjoe.scuffedmobs.entity.custom.ArmadilloEntity;
import net.kaupenjoe.scuffedmobs.entity.custom.CrabEntity;
import net.kaupenjoe.scuffedmobs.entity.custom.PenguinEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ScuffedMobsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModBusEvents {
    @SubscribeEvent
    public static void registerAttribute(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CRAB.get(), CrabEntity.createLivingAttributes().build());
        event.put(ModEntities.PENGUIN.get(), PenguinEntity.createLivingAttributes().build());
        event.put(ModEntities.ARMADILLO.get(), ArmadilloEntity.createLivingAttributes().build());
    }
}
