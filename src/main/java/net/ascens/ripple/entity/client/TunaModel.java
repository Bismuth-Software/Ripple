package net.ascens.ripple.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.custom.TunaEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.commands.arguments.ResourceLocationArgument;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class TunaModel<T extends TunaEntity> extends HierarchicalModel<T> {
        // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
        public static final ModelLayerLocation LAYER_LOCATION =
                new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(Ripple.MOD_ID, "gecko"), "main");
        private final ModelPart root;
        private final ModelPart root2;
        private final ModelPart head_left;
        private final ModelPart head_right;
        private final ModelPart body_left;
        private final ModelPart body_right;
        private final ModelPart left_fin;
        private final ModelPart right_fin;
        private final ModelPart back_fin_left;
        private final ModelPart back_fin_right;

        public TunaModel(ModelPart root) {
            this.root = root.getChild("root");
            this.root2 = this.root.getChild("root2");
            this.head_left = this.root2.getChild("head_left");
            this.head_right = this.head_left.getChild("head_right");
            this.body_left = this.root2.getChild("body_left");
            this.body_right = this.body_left.getChild("body_right");
            this.left_fin = this.body_right.getChild("left_fin");
            this.right_fin = this.body_right.getChild("right_fin");
            this.back_fin_left = this.body_right.getChild("back_fin_left");
            this.back_fin_right = this.back_fin_left.getChild("back_fin_right");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 14.5F, 0.0F));

            PartDefinition root2 = root.addOrReplaceChild("root2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -12.0F));

            PartDefinition head_left = root2.addOrReplaceChild("head_left", CubeListBuilder.create(), PartPose.offset(2.5F, 0.0F, 5.0F));

            PartDefinition head_right = head_left.addOrReplaceChild("head_right", CubeListBuilder.create().texOffs(22, 22).addBox(0.0F, -3.5F, -5.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

            PartDefinition body_left = root2.addOrReplaceChild("body_left", CubeListBuilder.create(), PartPose.offset(2.5F, 0.0F, 5.0F));

            PartDefinition body_right = body_left.addOrReplaceChild("body_right", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.5F, 0.0F, 7.0F, 9.0F, 13.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 22).addBox(2.5F, -8.5F, 2.0F, 0.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                    .texOffs(40, 0).mirror().addBox(5.0F, 4.5F, 2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                    .texOffs(40, 0).addBox(0.0F, 4.5F, 2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                    .texOffs(40, 6).addBox(2.5F, 4.5F, 10.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

            PartDefinition left_fin = body_right.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(10, 37).addBox(0.01F, -1.5F, 0.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 2.0F, 2.0F));

            PartDefinition right_fin = body_right.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(10, 37).mirror().addBox(-0.01F, -1.5F, 0.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 2.0F, 2.0F));

            PartDefinition back_fin_left = body_right.addOrReplaceChild("back_fin_left", CubeListBuilder.create(), PartPose.offset(5.0F, 0.0F, 13.0F));

            PartDefinition back_fin_right = back_fin_left.addOrReplaceChild("back_fin_right", CubeListBuilder.create().texOffs(22, 34).addBox(0.0F, -2.5F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 37).addBox(2.5F, -5.5F, 5.0F, 0.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 0.0F));

            return LayerDefinition.create(meshdefinition, 64, 64);
        }

    @Override
    public void setupAnim(TunaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        if (entity.isInWater()) {
            this.animateWalk(TunaAnimations.tunaAnimation.ANIM_TUNA_SWIM, limbSwing, limbSwingAmount, 2f, 2.5f);
            this.animate(entity.idleAnimationState, TunaAnimations.tunaAnimation.ANIM_TUNA_SWIM, ageInTicks, 1f);
        } else {
            this.animate(entity.flopAnimationState, TunaAnimations.tunaAnimation.ANIM_TUNA_FLOP, ageInTicks, 1f);
        }
    }

  /*  private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head_left.yRot = headYaw * ((float)Math.PI / 180f);
        this.head_right.yRot = headYaw * ((float)Math.PI / 180f);
        this.head_left.xRot = headPitch *  ((float)Math.PI / 180f);
        this.head_right.xRot = headPitch *  ((float)Math.PI / 180f);
    }*/

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
            root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        }

    @Override
    public ModelPart root() {
        return body_left;
    }
}
