package net.ascens.ripple.entity;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.custom.BluefinTunaEntity;
import net.ascens.ripple.entity.custom.YellowfinTunaEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class REntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Ripple.MOD_ID);

    //Bluefin Tuna
    public static final Supplier<EntityType<BluefinTunaEntity>> BLUEFIN_TUNA =
            ENTITY_TYPES.register("bluefin_tuna", () -> EntityType.Builder.of(BluefinTunaEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.75f, 0.4f).build("bluefin_tuna"));

    //Yellowfin Tuna
    public static final Supplier<EntityType<YellowfinTunaEntity>> YELLOWFIN_TUNA =
            ENTITY_TYPES.register("yellowfin_tuna", () -> EntityType.Builder.of(YellowfinTunaEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.75f, 0.4f).build("yellowfin_tuna"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
