package com.ThaddeusHalifax.WendigoMod.TileEntity;

import com.ThaddeusHalifax.WendigoMod.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;


public class FleshAltarTile extends TileEntity
{
    // responsible for the inventory of the entity
    private final ItemStackHandler itemHandler = createHandler(2);
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);


    public FleshAltarTile(TileEntityType<?> p_i48289_1_)
    {
        super(p_i48289_1_);
    }

    public FleshAltarTile()
    {
        this(RegistryHandler.FLESH_ALTAR_TILE.get());
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
                switch (slot) {
                    case 0: return stack.getItem() == Items.GLASS_PANE;
                    case 1: return stack.getItem() == Items.IRON_BLOCK;
                    default:
                        return false;
                }
            }

        };
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }

        return super.getCapability(cap, side);
    }
    // TODO: get shift clicking working
}
