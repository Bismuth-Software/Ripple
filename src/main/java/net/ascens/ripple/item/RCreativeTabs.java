package net.ascens.ripple.item;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.block.RBlocks;
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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(RItems.RAW_BLUEFIN_TUNA.get()))
                    .title(Component.translatable("creativetab.ripple"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(RBlocks.BULL_KELP.asItem());
                        output.accept(RItems.DRIED_BULL_KELP);

                        //Bluefin Tuna
                        output.accept(RItems.RAW_BLUEFIN_TUNA);
                        output.accept(RItems.COOKED_BLUEFIN_TUNA);
                        output.accept(RItems.RAZORTOOTH_TUNA); //aberration
                        output.accept(RItems.BLUEFIN_TUNA_BUCKET);
                        output.accept(RItems.BLUEFIN_TUNA_SPAWN_EGG);
                        //output.accept(RItems.BLUEFIN_TUNA_BUCKET); //aberration
                        //output.accept(RItems.BLUEFIN_TUNA_SPAWN_EGG); //aberration

                        //Yellowfin Tuna
                        output.accept(RItems.RAW_YELLOWFIN_TUNA);
                        output.accept(RItems.COOKED_YELLOWFIN_TUNA);
                        output.accept(RItems.UNNAMED_ABERRATED_YELLOWFIN_TUNA); //aberration
                        output.accept(RItems.YELLOWFIN_TUNA_BUCKET);
                        output.accept(RItems.YELLOWFIN_TUNA_SPAWN_EGG);
                        //output.accept(RItems.YELLOWFIN_TUNA_BUCKET); //aberration
                        //output.accept(RItems.YELLOWFIN_TUNA_SPAWN_EGG); //aberration
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}