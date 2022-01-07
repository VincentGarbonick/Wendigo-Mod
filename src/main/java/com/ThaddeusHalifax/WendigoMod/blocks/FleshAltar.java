package com.ThaddeusHalifax.WendigoMod.blocks;

import com.ThaddeusHalifax.WendigoMod.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class FleshAltar extends Block
{
    public FleshAltar() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.NETHER_BRICKS)
                .strength(3.0F, 3.0F)); //test strength
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world)
    {
        return RegistryHandler.FLESH_ALTAR_TILE.get().create();
    }

    @Override
    public boolean hasTileEntity(BlockState state)
    {
        return true;
    }
}
