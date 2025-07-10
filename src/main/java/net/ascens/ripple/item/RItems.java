package net.ascens.ripple.item;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.REntities;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;

public class RItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ripple.MOD_ID);

    public static final DeferredItem<Item> DRIED_BULL_KELP = ITEMS.register("dried_bull_kelp",
            () -> new Item(new Item.Properties()));

    //food
    public static final DeferredItem<Item> RAW_TUNA = ITEMS.register("raw_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.25f)
                    .build())));
    public static final DeferredItem<Item> COOKED_TUNA = ITEMS.register("cooked_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(0.45f)
                    .build())));
    public static final DeferredItem<Item> RAZORTOOTH_TUNA = ITEMS.register("razortooth_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.2f)
                    .build())));

    public static final DeferredItem<Item> TUNA_SPAWN_EGG = ITEMS.register("tuna_spawn_egg",
            () -> new DeferredSpawnEggItem(REntities.TUNA, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}