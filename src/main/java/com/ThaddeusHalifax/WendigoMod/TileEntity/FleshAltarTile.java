package com.ThaddeusHalifax.WendigoMod.TileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.ItemStackHandler;

import net.minecraft.item.ItemStack;


public class FleshAltarTile extends TileEntity
{
    // responsible for the inventory of the entity
    private final ItemStackHandler itemHandler = new ItemStackHandler(2);

    public FleshAltarTile(TileEntityType<?> p_i48289_1_)
    {
        super(p_i48289_1_);
    }


    @Override
    public CompoundNBT save(CompoundNBT nbt)
    {
        nbt.put("inv", itemHandler.serializeNBT());
        return super.save(nbt);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt)
    {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.load(state, nbt);
    }

    private ItemStackHandler createHandler(int size)
    {
        return new ItemStackHandler(size)
        {
            @Override
            protected void onContentsChanged(int slot)
            {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, ItemStack stack)
            {
                // this is where you add the code for handling the proper items being put in
                return super.isItemValid(slot, stack);
            }
            // getSlotLimit and insertItem are also put here...worry about that later
        };
    }
}
