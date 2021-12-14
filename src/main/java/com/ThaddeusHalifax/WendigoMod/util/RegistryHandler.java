package com.ThaddeusHalifax.WendigoMod.util;

import com.ThaddeusHalifax.WendigoMod.Wendigo;
import com.ThaddeusHalifax.WendigoMod.items.ItemBase;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegistryHandler
{
    //public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Wendigo.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Wendigo.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // Items
    public static final RegistryObject<Item> FLESH = ITEMS.register("flesh", ItemBase::new);
}
