package com.ThaddeusHalifax.WendigoMod.util;

import com.ThaddeusHalifax.WendigoMod.Wendigo;
import com.ThaddeusHalifax.WendigoMod.items.ItemBase;
import com.ThaddeusHalifax.WendigoMod.tools.FlayersTools;
import com.ThaddeusHalifax.WendigoMod.tools.FlayingBlade;
import javafx.scene.control.Tab;
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
    //public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Wendigo.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Wendigo.MOD_ID);

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> FLESH = ITEMS.register("flesh", ItemBase::new);

    // Tools
    public static final RegistryObject<FlayingBlade> FLAYING_BLADE = ITEMS.register(("flaying_blade"), () ->
            new FlayingBlade(FlayersTools.FLAYERS_TOOLS_OBSIDIAN, 1, -2.9F,  new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
}
