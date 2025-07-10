package net.ascens.ripple.event;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.REntities;
import net.ascens.ripple.entity.client.TunaModel;
import net.ascens.ripple.entity.custom.TunaEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = Ripple.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class REventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TunaModel.LAYER_LOCATION, TunaModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(REntities.TUNA.get(), TunaEntity.createAttributes().build());
    }
}
