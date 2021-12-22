package com.ThaddeusHalifax.WendigoMod.blocks;

import com.ThaddeusHalifax.WendigoMod.TileEntity.CowEngineTile;
import com.ThaddeusHalifax.WendigoMod.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;


public class CowEngine extends Block
{
    // for those big milkers
    public boolean milkTruck = false;
    public int coagulatedBloodCount = 0;
    public int wetBloodCount = 0;

    // I don't know how to get checking for the enums here to work, so I am just going to go with the inefficient method of if-else statements for now
    /*
    public enum cowStates
    {
        DEBUG(Items.STICK, true || false, true || false, true||false, true||false),
        COAGULATED_BLOOD_READY(RegistryHandler.COAGULATED_BLOOD.get(), false, true||false, true||false,true||false),
        MILK_BUCKET_READY(Items.MILK_BUCKET, true||false, true||false, true||false,false),
        GLASS_BOTTLE_READY(Items.GLASS_BOTTLE, true||false, true, true||false,true||false),
        BUCKET_READY(Items.BUCKET, true||false, true||false, true, true||false);

        private Item heldItem = Items.BUCKET;
        private boolean coagulatedFull = false;
        private boolean wetBloodFilled = false;
        private boolean wetBloodFull = false;
        private boolean milkTruck;

        private cowStates(Item heldItem, boolean coagulatedFull, boolean wetBloodFilled, boolean wetBloodFull, boolean milkTruck)
        {
            this.heldItem = heldItem ;
            this.wetBloodFilled = wetBloodFilled;
            this.wetBloodFull = wetBloodFull;
            this.coagulatedFull = coagulatedFull;
            this.milkTruck = milkTruck;
        }
    }
    */
    public CowEngine()
    {
        super(AbstractBlock.Properties.of(Material.WOOL)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
                .sound(SoundType.WART_BLOCK)
                .strength(2.0F, 2.0F));

    }
    // this is the function that handles the operation of the cow engine
    // first, if we click with milk and the milk tank is empty, we fill the milk tank
    // every time we click with a coagulated blood item, the coagulated blood count ticks up. we cannot go past 3 coagulated blood
    // once we are at 3 coagulated blood and a full milktruck, set wetBloodCount to 3

    // when we click with an empty bucket, it absorbs 3 blood if there is 3 blood
    // if we click with a glass, it absorbs 1 blood and decrements wetBloodCount
    // TODO: ANIMATIONS FOR EVERYTHING
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        //TileEntity tileEntity = worldIn.getTileEntity(pos);

        /*
        TileEntity tileEntity = worldIn.getBlockEntity(pos);
        System.out.println(tileEntity);

        if(tileEntity instanceof CowEngineTile)
        {
            System.out.print("test");
        }
        */
        // check item in players hand
        Item playerItem = player.getMainHandItem().getItem();

        if(!worldIn.isClientSide() && handIn.equals(Hand.MAIN_HAND)) {
            /*
            // for interacting with
            if (playerItem == RegistryHandler.COAGULATED_BLOOD.get() && coagulatedBloodCount < 3) {
                coagulatedBloodCount++;
                worldIn.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundCategory.BLOCKS, 1, 1);

                // decrement the item in their hand by one
                ItemStack playerItemStack = player.getMainHandItem().getStack();
                playerItemStack.shrink(1);

                if (coagulatedBloodCount == 3 && milkTruck == true)
                {
                    milkTruck = false;
                    coagulatedBloodCount = 0;
                    wetBloodCount = 3;
                }
            }
            else if (playerItem == Items.MILK_BUCKET && milkTruck == false)
            {
                milkTruck = true;
                worldIn.playSound(null, pos, SoundEvents.BUCKET_EMPTY, SoundCategory.BLOCKS, 1, 1);

                player.setItemInHand(handIn, new ItemStack(Items.BUCKET, 1));

                if (coagulatedBloodCount == 3)
                {
                    milkTruck = false;
                    coagulatedBloodCount = 0;
                    wetBloodCount = 3;
                }
            }
            else if (playerItem == Items.GLASS_BOTTLE && wetBloodCount > 0)
            {
                //check if inventory and hotbar are full
                // decrement the item in their hand by one
                ItemStack playerItemStack = player.getMainHandItem().getStack();
                playerItemStack.shrink(1);

                playerItemStack = new ItemStack(RegistryHandler.BLOOD_BOTTLE.get(), 1);
                player.addItem(playerItemStack);

                wetBloodCount--;
            }
            else if (playerItem == Items.BUCKET && wetBloodCount == 3)
            {
                worldIn.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundCategory.BLOCKS, 1, 1);
                player.setItemInHand(handIn, new ItemStack(RegistryHandler.BLOOD_BUCKET.get(), 1));

                // get rid of all the wet blood
                wetBloodCount -= 3;
            }
            else if(playerItem == Items.STICK)
            {
                String dataString = String.format("\nMilktruck is: %b\ncoagBlood is: %d\nwetBlood is: %d\n==========",
                        milkTruck, coagulatedBloodCount, wetBloodCount);
                System.out.println(dataString);
            }
            */

            // https://boson-english.v2mcdev.com/tileentity/first-tileentity-and-data-storage.html
            CowEngineTile cowEngineTile = (CowEngineTile) worldIn.getBlockEntity(pos);
            if (playerItem == RegistryHandler.COAGULATED_BLOOD.get())
            {
                cowEngineTile.incrementCoagulatedBlood();
            }
            else
            {
                System.out.println(cowEngineTile.getCoagulatedBloodCount());
            }
        }
        return super.use(state, worldIn, pos, player, handIn, hit);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return RegistryHandler.COW_ENGINE_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }
}
