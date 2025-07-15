package net.ascens.ripple.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.custom.TunaEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TunaRenderer extends MobRenderer<TunaEntity, TunaModel<TunaEntity>> {
    public TunaRenderer(EntityRendererProvider.Context context) {
        super(context, new TunaModel<>(context.bakeLayer(TunaModel.LAYER_LOCATION)), 0.25f);
    }

    @Override
    public ResourceLocation getTextureLocation(TunaEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(Ripple.MOD_ID, "textures/entity/tuna/tuna.png");
    }

    @Override
    public void render(TunaEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}