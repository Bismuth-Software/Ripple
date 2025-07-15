package net.ascens.ripple.event;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.REntities;
import net.ascens.ripple.entity.client.BluefinTunaModel;
import net.ascens.ripple.entity.client.YellowfinTunaModel;
import net.ascens.ripple.entity.custom.BluefinTunaEntity;
import net.ascens.ripple.entity.custom.YellowfinTunaEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Ripple.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class REventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BluefinTunaModel.LAYER_LOCATION, BluefinTunaModel::createBodyLayer);
        event.registerLayerDefinition(YellowfinTunaModel.LAYER_LOCATION, YellowfinTunaModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(REntities.BLUEFIN_TUNA.get(), BluefinTunaEntity.createAttributes().build());
        event.put(REntities.YELLOWFIN_TUNA.get(), YellowfinTunaEntity.createAttributes().build());
    }
}
