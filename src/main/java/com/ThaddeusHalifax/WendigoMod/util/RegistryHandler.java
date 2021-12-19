package com.ThaddeusHalifax.WendigoMod.util;

import com.ThaddeusHalifax.WendigoMod.Wendigo;
import com.ThaddeusHalifax.WendigoMod.blocks.CowEngine;
import com.ThaddeusHalifax.WendigoMod.items.ItemBase;
import com.ThaddeusHalifax.WendigoMod.tools.FlayersTools;
import com.ThaddeusHalifax.WendigoMod.tools.FlayingBlade;
import javafx.scene.control.Tab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.tools.Tool;

public class RegistryHandler
{
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Wendigo.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Wendigo.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> FLESH = ITEMS.register("flesh", ItemBase::new);
    // Higher tier repair material for flesh gear
    // Have animation that makes it look around
    // public static final RegistryObject<Item> AWOKEN_FLESH = ITEMS.register("awoken_flesh", ItemBase::new);

    // Tools
    public static final RegistryObject<FlayingBlade> FLAYING_BLADE = ITEMS.register(("flaying_blade"), () ->
            new FlayingBlade(FlayersTools.FLAYERS_TOOLS_OBSIDIAN, 1, -2.9F,  new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    // Block
    public static final RegistryObject<Block> COW_ENGINE = BLOCKS.register(("cow_engine"), CowEngine::new);

    // Block Items
    public static final RegistryObject<Item> COW_ENGINE_ITEM = ITEMS.register("cow_engine", () -> new BlockItemBase(COW_ENGINE.get()));
}





