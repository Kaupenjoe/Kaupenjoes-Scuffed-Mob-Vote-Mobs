package net.kaupenjoe.scuffedmobs.entity.client;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.kaupenjoe.scuffedmobs.entity.custom.PenguinEntity;
import net.kaupenjoe.scuffedmobs.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PenguinRenderer extends MobRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
    public PenguinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PenguinModel<>(pContext.bakeLayer(ModModelLayers.PENGUIN_LAYER)), 0.75f);
    }

    @Override
    public ResourceLocation getTextureLocation(PenguinEntity pEntity) {
        return new ResourceLocation(ScuffedMobsMod.MOD_ID, "textures/entities/penguin.png");
    }
}
