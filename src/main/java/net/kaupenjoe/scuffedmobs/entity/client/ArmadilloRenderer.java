package net.kaupenjoe.scuffedmobs.entity.client;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.kaupenjoe.scuffedmobs.entity.custom.ArmadilloEntity;
import net.kaupenjoe.scuffedmobs.entity.layers.ModModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ArmadilloRenderer extends MobRenderer<ArmadilloEntity, ArmadilloModel<ArmadilloEntity>> {
    public ArmadilloRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new ArmadilloModel<>(pContext.bakeLayer(ModModelLayers.ARMADILLO_LAYER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(ArmadilloEntity pEntity) {
        return new ResourceLocation(ScuffedMobsMod.MOD_ID, "textures/entities/armadillo.png");
    }
}
