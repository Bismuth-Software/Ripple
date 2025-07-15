package net.ascens.ripple;

import net.ascens.ripple.block.RBlocks;
import net.ascens.ripple.entity.REntities;
import net.ascens.ripple.entity.client.BluefinTunaRenderer;
import net.ascens.ripple.entity.client.YellowfinTunaRenderer;
import net.ascens.ripple.item.RCreativeTabs;
import net.ascens.ripple.item.RItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Ripple.MOD_ID)
public class Ripple {
    public static final String MOD_ID = "ripple";

    public Ripple(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        RBlocks.register(modEventBus);
        RItems.register(modEventBus);
        RCreativeTabs.register(modEventBus);

        REntities.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(REntities.BLUEFIN_TUNA.get(), BluefinTunaRenderer::new);
            EntityRenderers.register(REntities.YELLOWFIN_TUNA.get(), YellowfinTunaRenderer::new);
        }
    }
}
