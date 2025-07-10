package net.ascens.ripple.entity;

import net.ascens.ripple.Ripple;
import net.ascens.ripple.entity.custom.TunaEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class REntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Ripple.MOD_ID);

    public static final Supplier<EntityType<TunaEntity>> TUNA =
            ENTITY_TYPES.register("tuna", () -> EntityType.Builder.of(TunaEntity::new, MobCategory.WATER_CREATURE)
                    .sized(0.75f, 0.4f).build("tuna"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
