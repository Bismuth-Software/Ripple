package net.ascens.ripple.item;

import net.ascens.ripple.Ripple;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class RCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Ripple.MOD_ID);

    public static final Supplier<CreativeModeTab> RIPPLE_TAB = CREATIVE_MODE_TAB.register("ripple_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(RItems.RAW_TUNA.get()))
                    .title(Component.translatable("creativetab.ripple"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(RItems.DRIED_BULL_KELP);
                        output.accept(RItems.RAW_TUNA);
                        output.accept(RItems.COOKED_TUNA);
                        output.accept(RItems.RAZORTOOTH_TUNA);
                        output.accept(RItems.TUNA_BUCKET);
                        output.accept(RItems.TUNA_SPAWN_EGG);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}