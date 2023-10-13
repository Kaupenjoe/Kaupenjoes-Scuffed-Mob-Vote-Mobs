package net.kaupenjoe.scuffedmobs.item;

import net.kaupenjoe.scuffedmobs.ScuffedMobsMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ScuffedMobsMod.MOD_ID);

    public static final RegistryObject<Item> CRAB_CLAW = ITEMS.register("crab_claw",
            () -> new CrabClawItem(new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
