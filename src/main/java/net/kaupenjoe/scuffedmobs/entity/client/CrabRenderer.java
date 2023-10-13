package net.kaupenjoe.scuffedmobs.entity.client;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.kaupenjoe.scuffedmobs.entity.custom.CrabEntity;
import net.kaupenjoe.scuffedmobs.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrabRenderer extends MobRenderer<CrabEntity, CrabModel<CrabEntity>> {
    public CrabRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new CrabModel<>(pContext.bakeLayer(ModModelLayers.CRAB_LAYER)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(CrabEntity pEntity) {
        return new ResourceLocation(ScuffedMobsMod.MOD_ID, "textures/entities/crab.png");
    }
}
