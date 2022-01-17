package com.ThaddeusHalifax.WendigoMod.util;

import com.ThaddeusHalifax.WendigoMod.TileEntity.CowEngineTile;
import com.ThaddeusHalifax.WendigoMod.TileEntity.FleshAltarTile;
import com.ThaddeusHalifax.WendigoMod.Wendigo;
import com.ThaddeusHalifax.WendigoMod.blocks.CowEngine;
import com.ThaddeusHalifax.WendigoMod.blocks.FleshAltar;
import com.ThaddeusHalifax.WendigoMod.container.FleshAltarContainer;
import com.ThaddeusHalifax.WendigoMod.items.ItemBase;
import com.ThaddeusHalifax.WendigoMod.tools.FlayersTools;
import com.ThaddeusHalifax.WendigoMod.tools.FlayingBlade;
import javafx.scene.control.Tab;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModContainer;
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
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Wendigo.MOD_ID);
    public static DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, Wendigo.MOD_ID);

    public static void init()
    {
        // TODO: replace the long function call in each register method with evenBus and see if it works
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
        CONTAINERS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
    // TODO: Get custom tabs working
    // Items
    public static final RegistryObject<Item> FLESH = ITEMS.register("flesh", ItemBase::new);
    // TODO: Make coagulated blood edible
    public static final RegistryObject<Item> COAGULATED_BLOOD = ITEMS.register("coagulated_blood", ItemBase::new);
    // TODO: Make blood bottle drinkable potion
    // TODO: Make blood bucket a bucket that doesn't stack lol
    public static final RegistryObject<Item> BLOOD_BUCKET = ITEMS.register("blood_bucket", ItemBase::new);
    public static final RegistryObject<Item> BLOOD_BOTTLE = ITEMS.register("blood_bottle", ItemBase::new);
    // public static final RegistryObject<Item> AWOKEN_FLESH = ITEMS.register("awoken_flesh", ItemBase::new);

    // Tools
    public static final RegistryObject<FlayingBlade> FLAYING_BLADE = ITEMS.register(("flaying_blade"), () ->
            new FlayingBlade(FlayersTools.FLAYERS_TOOLS_OBSIDIAN, 1, -2.9F, new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    // Block
    public static final RegistryObject<Block> COW_ENGINE = BLOCKS.register(("cow_engine"), CowEngine::new);
    public static final RegistryObject<Block> FLESH_ALTAR = BLOCKS.register(("flesh_altar"), FleshAltar::new);

    // Block Items
    public static final RegistryObject<Item> COW_ENGINE_ITEM = ITEMS.register("cow_engine", () -> new BlockItemBase(COW_ENGINE.get()));
    public static final RegistryObject<Item> FLESH_ALTAR_ITEM = ITEMS.register("flesh_altar", () -> new BlockItemBase(FLESH_ALTAR.get()));

    // Tile Entities
    public static RegistryObject<TileEntityType<CowEngineTile>> COW_ENGINE_TILE = TILE_ENTITIES.register("cow_engine_tile", () -> TileEntityType.Builder.of(
            ()->new CowEngineTile(RegistryHandler.COW_ENGINE_TILE.get()), RegistryHandler.COW_ENGINE.get()).build(null));

    public static RegistryObject<TileEntityType<FleshAltarTile>> FLESH_ALTAR_TILE = TILE_ENTITIES.register("flesh_altar_tile", () -> TileEntityType.Builder.of(
            ()->new FleshAltarTile(RegistryHandler.FLESH_ALTAR_TILE.get()), RegistryHandler.FLESH_ALTAR.get()).build(null));
    // https://chocobo.cosiestdevil.uk/minecraft/MetalsAndSouls/src/branch/1.16.x/src/main/java/uk/tldcode/minecraft/metalsandsouls/tileentities/ModTileEntities.java
    // public final  RegistryObject<TileEntityType<InfuserTileEntity>> INFUSER = MetalsMod.TILE_ENTITIES.register("infuser", () -> TileEntityType.Builder.create(
    // () -> new InfuserTileEntity(TechTier.beginner), MetalsMod.ModBlocks.INFUSER.get()).build(null));

    // Containers
    public static final RegistryObject<ContainerType<FleshAltarContainer>> FLESH_ALTAR_CONTAINER
            = CONTAINERS.register("flesh_altar_container",
            () -> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getCommandSenderWorld();
                return new FleshAltarContainer(windowId, world, pos, inv, inv.player);
            })));

}





