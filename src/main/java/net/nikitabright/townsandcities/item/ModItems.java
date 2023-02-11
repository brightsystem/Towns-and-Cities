package net.nikitabright.townsandcities.item;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nikitabright.townsandcities.TownsandCities;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TownsandCities.MODID);

    public static final RegistryObject<Item> PIPE = ITEMS.register("pipe",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> GATE_PIPE = ITEMS.register("gate_pipe",
            () -> new Item(new Item.Properties()));

    @SubscribeEvent
    public void buildContents(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(PIPE);
            event.accept(GATE_PIPE);
        }
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
