package net.kaupenjoe.scuffedmobs.entity.layers;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {
    public static final ModelLayerLocation CRAB_LAYER =
            new ModelLayerLocation(new ResourceLocation(ScuffedMobsMod.MOD_ID, "crab"), "main");

    public static final ModelLayerLocation PENGUIN_LAYER =
            new ModelLayerLocation(new ResourceLocation(ScuffedMobsMod.MOD_ID, "penguin"), "main");

    public static final ModelLayerLocation ARMADILLO_LAYER =
            new ModelLayerLocation(new ResourceLocation(ScuffedMobsMod.MOD_ID, "armadillo"), "main");
}
