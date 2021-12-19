package com.ThaddeusHalifax.WendigoMod.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


public class CowEngine extends Block
{
    // for those big milkers
    public boolean milkTruck = false;
    public int coagulatedBloodCount = 0;
    public int bloodCount = 0;

    public CowEngine() {
        super(AbstractBlock.Properties.of(Material.WOOL)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
                .sound(SoundType.WART_BLOCK)
                .strength(2.0F, 2.0F));
    }
}
