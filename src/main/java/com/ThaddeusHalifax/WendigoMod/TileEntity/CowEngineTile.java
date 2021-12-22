
package com.ThaddeusHalifax.WendigoMod.TileEntity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;


public class CowEngineTile extends TileEntity {
    public CowEngineTile(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }
    //https://chocobo.cosiestdevil.uk/minecraft/MetalsAndSouls/src/branch/1.16.x/src/main/java/uk/tldcode/minecraft/metalsandsouls/SimpleMachineTileEntity.java

    // for those big milkers
    protected boolean milkTruck = false;
    protected int coagulatedBloodCount = 0;
    protected int wetBloodCount = 0;

    public void fillMilk()
    {
        this.milkTruck = true;
    }
    public void emptyMilk()
    {
        this.milkTruck = false;
    }
    public void incrementCoagulatedBlood()
    {
        this.coagulatedBloodCount++;
    }
    public void decrementCoagulatedBlood()
    {
        this.coagulatedBloodCount--;
    }
    public void incrementWetBlood()
    {
        wetBloodCount++;
    }
    public void decrementWetBlood()
    {
        wetBloodCount--;
    }
    public int getCoagulatedBloodCount()
    {
        return coagulatedBloodCount;
    }
    public void setCoagulatedBloodCount(int coagulatedBloodCount)
    {
        this.coagulatedBloodCount = coagulatedBloodCount;
    }
    public int getWetBloodCount()
    {
        return wetBloodCount;
    }
    public void setWetBloodCount(int wetBloodCount)
    {
        this.wetBloodCount = wetBloodCount;
    }
    public boolean isMilkTruck()
    {
        return milkTruck;
    }
    public void setMilkTruck(boolean milkTruck)
    {
        this.milkTruck = milkTruck;
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt)
    {
        nbt.putBoolean("milkTruck", this.milkTruck);
        nbt.putInt("coagulatedBloodCount",this.coagulatedBloodCount);
        nbt.putInt("wetBloodCount", this.wetBloodCount);
        return super.save(nbt);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt)
    {
        super.load(state, nbt);
        this.milkTruck = nbt.getBoolean("milkTruck");
        this.coagulatedBloodCount = nbt.getInt("coagulatedBloodCount");
        this.wetBloodCount = nbt.getInt("wetBloodCount");
    }
}