package com.awesoft.DraconicShenanigans;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import com.brandon3055.draconicevolution.init.DEContent;

public class DraconicShenanigansTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DraconicShenanigans.MODID);

    public static final RegistryObject<CreativeModeTab> DS_TAB = CREATIVE_MODE_TABS.register("ds_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(DEContent.CHESTPIECE_WYVERN.get()))
                    .title(Component.translatable("tab.draconicshenanigans.main"))
                    .displayItems(((itemDisplayParameters, output) -> {
                        output.accept(DSContent.helmetWyvern.get());
                        output.accept(DEContent.CHESTPIECE_WYVERN.get());
                        output.accept(DSContent.leggingsWyvern.get());
                        output.accept(DSContent.bootsWyvern.get());
                        //output.accept(DSContent.backpackWyvern.get());

                        //draconic
                        output.accept(DSContent.helmetDraconic.get());
                        output.accept(DEContent.CHESTPIECE_DRACONIC.get());
                        output.accept(DSContent.leggingsDraconic.get());
                        output.accept(DSContent.bootsDraconic.get());
                        //output.accept(DSContent.backpackDraconic.get());
                    }))
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
