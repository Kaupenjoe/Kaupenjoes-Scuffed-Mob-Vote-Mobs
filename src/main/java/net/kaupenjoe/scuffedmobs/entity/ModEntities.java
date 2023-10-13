package net.kaupenjoe.scuffedmobs.entity;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.kaupenjoe.scuffedmobs.entity.custom.ArmadilloEntity;
import net.kaupenjoe.scuffedmobs.entity.custom.CrabEntity;
import net.kaupenjoe.scuffedmobs.entity.custom.PenguinEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ScuffedMobsMod.MOD_ID);

    public static final RegistryObject<EntityType<CrabEntity>> CRAB =
            ENTITIES.register("crab", () -> EntityType.Builder.of(CrabEntity::new, MobCategory.CREATURE)
                    .sized(0.5f, 0.5f).build("crab"));

    public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN =
            ENTITIES.register("penguin", () -> EntityType.Builder.of(PenguinEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("penguin"));

    public static final RegistryObject<EntityType<ArmadilloEntity>> ARMADILLO =
            ENTITIES.register("armadillo", () -> EntityType.Builder.of(ArmadilloEntity::new, MobCategory.CREATURE)
                    .sized(1f, 1f).build("armadillo"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
