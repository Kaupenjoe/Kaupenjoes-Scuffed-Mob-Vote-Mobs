package net.kaupenjoe.scuffedmobs.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kaupenjoe.scuffedmobs.entity.animations.ModAnimations;
import net.kaupenjoe.scuffedmobs.entity.custom.CrabEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class CrabModel<T extends CrabEntity> extends HierarchicalModel<T> {
	private final ModelPart crab;

	public CrabModel(ModelPart root) {
		this.crab = root.getChild("crab");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition crab = partdefinition.addOrReplaceChild("crab", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = crab.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition legs = body.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, 1.0F));

		PartDefinition leg_1 = legs.addOrReplaceChild("leg_1", CubeListBuilder.create(), PartPose.offset(3.0F, -0.5F, 1.5F));

		PartDefinition cube_r1 = leg_1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leg_2 = legs.addOrReplaceChild("leg_2", CubeListBuilder.create(), PartPose.offset(-3.0F, -0.5F, 1.5F));

		PartDefinition cube_r2 = leg_2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(9, 5).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leg_3 = legs.addOrReplaceChild("leg_3", CubeListBuilder.create().texOffs(2, 2).addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -0.5F, 0.5F));

		PartDefinition leg_4 = legs.addOrReplaceChild("leg_4", CubeListBuilder.create().texOffs(3, 10).addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -0.5F, 0.5F));

		PartDefinition leg_5 = legs.addOrReplaceChild("leg_5", CubeListBuilder.create(), PartPose.offset(-3.0F, -0.5F, -0.5F));

		PartDefinition cube_r3 = leg_5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(7, 10).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leg_6 = legs.addOrReplaceChild("leg_6", CubeListBuilder.create(), PartPose.offset(3.0F, -0.5F, -0.5F));

		PartDefinition cube_r4 = leg_6.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 11).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leg_7 = legs.addOrReplaceChild("leg_7", CubeListBuilder.create(), PartPose.offset(-2.0F, -0.5F, -1.5F));

		PartDefinition cube_r5 = leg_7.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(4, 12).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition leg_8 = legs.addOrReplaceChild("leg_8", CubeListBuilder.create(), PartPose.offset(2.0F, -0.5F, -1.5F));

		PartDefinition cube_r6 = leg_8.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(10, 11).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition non_legs = body.addOrReplaceChild("non_legs", CubeListBuilder.create().texOffs(6, 0).addBox(0.15F, -3.3F, -1.4F, 0.4F, 1.0F, 0.4F, new CubeDeformation(0.0F))
		.texOffs(7, 2).addBox(-0.65F, -3.3F, -1.4F, 0.4F, 1.0F, 0.4F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_eye = non_legs.addOrReplaceChild("right_eye", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -3.0F, -0.6F));

		PartDefinition big_claw = non_legs.addOrReplaceChild("big_claw", CubeListBuilder.create().texOffs(9, 8).addBox(0.0F, -0.5F, -0.7F, 2.0F, 1.0F, 1.5F, new CubeDeformation(0.0F))
		.texOffs(0, 8).addBox(1.0F, 0.5F, -0.7F, 4.0F, 1.0F, 1.5F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(1.0F, -2.5F, -0.7F, 4.0F, 2.0F, 1.5F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -3.0F, 0.2F));

		PartDefinition small_claw = non_legs.addOrReplaceChild("small_claw", CubeListBuilder.create().texOffs(4, 11).addBox(0.8333F, 0.0F, -0.5F, 1.0F, 0.5F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 10).addBox(-0.6667F, -0.75F, -0.5F, 2.0F, 0.75F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 6).addBox(-0.4167F, 0.45F, -0.5F, 2.0F, 0.75F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.8333F, -3.0F, 0.0F));

		PartDefinition left_eye = non_legs.addOrReplaceChild("left_eye", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -3.0F, -0.7F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(CrabEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);

		this.animate(entity.wavingState, ModAnimations.CRAB_WAVE, ageInTicks, 1f);
		this.animate(entity.idleState, ModAnimations.CRAB_IDLE, ageInTicks, 1f);
		this.animate(entity.raveState, ModAnimations.CRAB_RAVE, ageInTicks, 1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		crab.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return crab;
	}
}