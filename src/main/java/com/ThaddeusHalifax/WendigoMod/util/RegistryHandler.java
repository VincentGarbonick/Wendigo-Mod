package com.ThaddeusHalifax.WendigoMod.util;

import com.ThaddeusHalifax.WendigoMod.TileEntity.CowEngineTile;
import com.ThaddeusHalifax.WendigoMod.Wendigo;
import com.ThaddeusHalifax.WendigoMod.blocks.CowEngine;
import com.ThaddeusHalifax.WendigoMod.items.ItemBase;
import com.ThaddeusHalifax.WendigoMod.tools.FlayersTools;
import com.ThaddeusHalifax.WendigoMod.tools.FlayingBlade;
import javafx.scene.control.Tab;
import net.minecraft.block.Block;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.tools.Tool;

public class RegistryHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Wendigo.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Wendigo.MOD_ID);
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Wendigo.MOD_ID);

    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    // Items
    public static final RegistryObject<Item> FLESH = ITEMS.register("flesh", ItemBase::new);
    // TODO: Make coagulated blood edible
    public static final RegistryObject<Item> COAGULATED_BLOOD = ITEMS.register("coagulated_blood", ItemBase::new);
    // TODO: Make blood bottle drinkable potion
    public static final RegistryObject<Item> BLOOD_BUCKET = ITEMS.register("blood_bucket", ItemBase::new);
    public static final RegistryObject<Item> BLOOD_BOTTLE = ITEMS.register("blood_bottle", ItemBase::new);
    // public static final RegistryObject<Item> AWOKEN_FLESH = ITEMS.register("awoken_flesh", ItemBase::new);

    // Tools
    public static final RegistryObject<FlayingBlade> FLAYING_BLADE = ITEMS.register(("flaying_blade"), () ->
            new FlayingBlade(FlayersTools.FLAYERS_TOOLS_OBSIDIAN, 1, -2.9F, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    // Block
    public static final RegistryObject<Block> COW_ENGINE = BLOCKS.register(("cow_engine"), CowEngine::new);

    // Block Items
    public static final RegistryObject<Item> COW_ENGINE_ITEM = ITEMS.register("cow_engine", () -> new BlockItemBase(COW_ENGINE.get()));

    // Tile Entities
    public static RegistryObject<TileEntityType<CowEngineTile>> COW_ENGINE_TILE = TILE_ENTITIES.register("cow_engine_tile", () -> TileEntityType.Builder.of(
            ()->new CowEngineTile(RegistryHandler.COW_ENGINE_TILE.get()), RegistryHandler.COW_ENGINE.get()).build(null));

    // https://chocobo.cosiestdevil.uk/minecraft/MetalsAndSouls/src/branch/1.16.x/src/main/java/uk/tldcode/minecraft/metalsandsouls/tileentities/ModTileEntities.java
    // public final  RegistryObject<TileEntityType<InfuserTileEntity>> INFUSER = MetalsMod.TILE_ENTITIES.register("infuser", () -> TileEntityType.Builder.create(
    // () -> new InfuserTileEntity(TechTier.beginner), MetalsMod.ModBlocks.INFUSER.get()).build(null));


}





