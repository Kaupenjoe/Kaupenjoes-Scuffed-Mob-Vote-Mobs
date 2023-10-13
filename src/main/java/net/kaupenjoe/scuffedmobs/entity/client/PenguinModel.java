package net.kaupenjoe.scuffedmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kaupenjoe.scuffedmobs.entity.animations.ModAnimations;
import net.kaupenjoe.scuffedmobs.entity.custom.PenguinEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PenguinModel<T extends PenguinEntity> extends HierarchicalModel<T> {
    private final ModelPart penguin;

    public PenguinModel(ModelPart root) {
        this.penguin = root.getChild("penguin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition penguin = partdefinition.addOrReplaceChild("penguin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = penguin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -15.0F, -3.0F, 10.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 21).addBox(-4.0F, -6.3F, -2.4F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(7, 32).addBox(-1.0F, -3.3F, -4.4F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -2.3F, -4.4F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.7F, 0.4F));

        PartDefinition right_eye = head.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(27, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -3.3F, -1.9F));

        PartDefinition left_eye = head.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(19, 33).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -3.3F, -1.9F));

        PartDefinition left_eyebrow = head.addOrReplaceChild("left_eyebrow", CubeListBuilder.create().texOffs(32, 28).addBox(-1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(32, 22).addBox(2.0F, -3.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 5).addBox(1.0F, -2.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 0).addBox(2.0F, -2.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -5.3F, -2.4F));

        PartDefinition right_eyebrow = head.addOrReplaceChild("right_eyebrow", CubeListBuilder.create().texOffs(21, 22).addBox(-2.0F, -1.0F, -6.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-2.0F, -2.0F, -6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(27, 0).addBox(-2.0F, -3.0F, -6.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(21, 24).addBox(-2.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 23).addBox(-2.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -5.3F, 2.6F));

        PartDefinition right_fin = body.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(12, 32).addBox(-0.5F, -1.0F, -2.5F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, -13.0F, 0.5F));

        PartDefinition left_fin = body.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -1.0F, -2.5F, 1.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(5.5F, -13.0F, 0.5F));

        PartDefinition right_foot = body.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(27, 14).addBox(-1.5F, -0.5F, -6.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -0.5F, 1.0F));

        PartDefinition left_foot = body.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(19, 25).addBox(-1.5F, -0.6F, -6.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -0.4F, 1.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(PenguinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.animateWalk(ModAnimations.PENGUIN_WADDLE, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleState, ModAnimations.PENGUIN_IDLE, ageInTicks, 1f);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        penguin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return penguin;
    }
}
