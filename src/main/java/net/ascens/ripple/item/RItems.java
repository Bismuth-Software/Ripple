package net.ascens.ripple.item;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.REntities;
import net.ascens.ripple.item.custom.TunaBucket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class RItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ripple.MOD_ID);

    public static final DeferredItem<Item> DRIED_BULL_KELP = ITEMS.register("dried_bull_kelp",
            () -> new Item(new Item.Properties()));

    //Bluefin Tuna
    public static final DeferredItem<Item> RAW_BLUEFIN_TUNA = ITEMS.register("raw_bluefin_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.25f)
                    .build())));
    public static final DeferredItem<Item> COOKED_BLUEFIN_TUNA = ITEMS.register("cooked_bluefin_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(0.45f)
                    .build())));
    public static final DeferredItem<Item> RAZORTOOTH_TUNA = ITEMS.register("razortooth_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.2f)
                    .build())));
    public static final DeferredItem<Item> BLUEFIN_TUNA_BUCKET = ITEMS.register("bluefin_tuna_bucket",
            () -> new TunaBucket(REntities.BLUEFIN_TUNA.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH,
                    new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BLUEFIN_TUNA_SPAWN_EGG = ITEMS.register("bluefin_tuna_spawn_egg",
            () -> new DeferredSpawnEggItem(REntities.BLUEFIN_TUNA, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    //Yellowfin Tuna
    public static final DeferredItem<Item> RAW_YELLOWFIN_TUNA = ITEMS.register("raw_yellowfin_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.25f)
                    .build())));
    public static final DeferredItem<Item> COOKED_YELLOWFIN_TUNA = ITEMS.register("cooked_yellowfin_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(7)
                    .saturationModifier(0.45f)
                    .build())));
    public static final DeferredItem<Item> UNNAMED_ABERRATED_YELLOWFIN_TUNA = ITEMS.register("temp_tuna",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.2f)
                    .build())));
    public static final DeferredItem<Item> YELLOWFIN_TUNA_BUCKET = ITEMS.register("yellowfin_tuna_bucket",
            () -> new TunaBucket(REntities.YELLOWFIN_TUNA.get(), Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH,
                    new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> YELLOWFIN_TUNA_SPAWN_EGG = ITEMS.register("yellowfin_tuna_spawn_egg",
            () -> new DeferredSpawnEggItem(REntities.YELLOWFIN_TUNA, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}