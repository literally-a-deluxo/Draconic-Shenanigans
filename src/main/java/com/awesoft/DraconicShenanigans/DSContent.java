package com.awesoft.DraconicShenanigans;

import com.awesoft.DraconicShenanigans.items.armor.*;
import com.awesoft.DraconicShenanigans.items.curios.ModularBackpack;
import com.brandon3055.draconicevolution.init.DEContent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DSContent {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DraconicShenanigans.MODID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DraconicShenanigans.MODID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name,() -> new BlockItem(block.get(),new Item.Properties()));
    }


    //items
    public static final RegistryObject<ModularBackpack> backpackWyvern  = ITEMS.register("wyvern_backpack",  () -> new ModularBackpack(DEContent.WYVERN_TOOLS));
    public static final RegistryObject<ModularBackpack> backpackDraconic = ITEMS.register("draconic_backpack", () -> new ModularBackpack(DEContent.DRACONIC_TOOLS));

    public static final RegistryObject<ModularHelmet> helmetWyvern  = ITEMS.register("wyvern_helmet",  () -> new ModularHelmet(DEContent.WYVERN_TOOLS));
    public static final RegistryObject<ModularHelmet> helmetDraconic  = ITEMS.register("draconic_helmet",  () -> new ModularHelmet(DEContent.DRACONIC_TOOLS));

    public static final RegistryObject<ModularDenseChestpiece> denseChestpieceWyvern  = ITEMS.register("wyvern_dense_chestpiece",  () -> new ModularDenseChestpiece(DEContent.WYVERN_TOOLS));
    public static final RegistryObject<CrashMaGameChestpiece> crashMaGameChestpiece  = ITEMS.register("crash_chestpiece",  () -> new CrashMaGameChestpiece(DEContent.CHAOTIC_TOOLS));

    public static final RegistryObject<ModularLeggings> leggingsWyvern  = ITEMS.register("wyvern_leggings",  () -> new ModularLeggings(DEContent.WYVERN_TOOLS));
    public static final RegistryObject<ModularLeggings> leggingsDraconic  = ITEMS.register("draconic_leggings",  () -> new ModularLeggings(DEContent.DRACONIC_TOOLS));

    public static final RegistryObject<ModularBoots> bootsWyvern  = ITEMS.register("wyvern_boots",  () -> new ModularBoots(DEContent.WYVERN_TOOLS));
    public static final RegistryObject<ModularBoots> bootsDraconic  = ITEMS.register("draconic_boots",  () -> new ModularBoots(DEContent.DRACONIC_TOOLS));

    //blocks
    public static final RegistryObject<Block> BONER_BLOCK = registerBlock("boner_block",() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.WOOL)));

    public static void init() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }

}
