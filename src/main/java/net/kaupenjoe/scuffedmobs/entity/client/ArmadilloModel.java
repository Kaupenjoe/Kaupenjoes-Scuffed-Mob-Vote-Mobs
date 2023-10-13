package net.kaupenjoe.scuffedmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kaupenjoe.scuffedmobs.entity.animations.ModAnimations;
import net.kaupenjoe.scuffedmobs.entity.custom.ArmadilloEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ArmadilloModel<T extends ArmadilloEntity> extends HierarchicalModel<T> {
	private final ModelPart armadillo;

	public ArmadilloModel(ModelPart root) {
		this.armadillo = root.getChild("armadillo");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition armadillo = partdefinition.addOrReplaceChild("armadillo", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = armadillo.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -7.5F, -3.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 4).addBox(-0.35F, -1.0F, 0.0F, 0.7F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -7.0F, -3.7F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-0.375F, -1.1F, 0.0F, 0.75F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.825F, -6.9F, -3.7F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r3 = head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, -3.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition left_eye = head.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(0, 30).addBox(-0.375F, -0.4682F, -0.375F, 0.75F, 0.75F, 0.75F, new CubeDeformation(0.0F)), PartPose.offset(-0.775F, -5.2818F, -4.625F));

		PartDefinition right_eye = head.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(0, 30).addBox(-0.375F, -0.4004F, -0.375F, 0.75F, 0.75F, 0.75F, new CubeDeformation(0.0F)), PartPose.offset(0.825F, -5.3496F, -4.625F));

		PartDefinition front_left_foot = body.addOrReplaceChild("front_left_foot", CubeListBuilder.create().texOffs(8, 14).addBox(1.0F, -1.5F, -2.0F, 1.5F, 1.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front_right_foot = body.addOrReplaceChild("front_right_foot", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -1.5F, -2.0F, 1.5F, 1.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition back_right_foot = body.addOrReplaceChild("back_right_foot", CubeListBuilder.create().texOffs(14, 16).addBox(-2.5F, -1.5F, 2.0F, 1.5F, 1.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition back_left_foot = body.addOrReplaceChild("back_left_foot", CubeListBuilder.create().texOffs(0, 4).addBox(1.0F, -1.5F, 2.0F, 1.5F, 1.5F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail_r1 = tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, -0.3F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7F, 5.0F, 0.2182F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(ArmadilloEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(entity.idleState, ModAnimations.ARMADILLO_IDLE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		armadillo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return armadillo;
	}
}