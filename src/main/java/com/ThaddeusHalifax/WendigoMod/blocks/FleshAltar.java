package com.ThaddeusHalifax.WendigoMod.blocks;

import com.ThaddeusHalifax.WendigoMod.TileEntity.CowEngineTile;
import com.ThaddeusHalifax.WendigoMod.TileEntity.FleshAltarTile;
import com.ThaddeusHalifax.WendigoMod.container.FleshAltarContainer;
import com.ThaddeusHalifax.WendigoMod.util.RegistryHandler;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;
import javax.swing.*;

public class FleshAltar extends Block
{
    public FleshAltar() {
        super(AbstractBlock.Properties.of(Material.STONE)
                .harvestLevel(1)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.NETHER_BRICKS)
                .strength(3.0F, 3.0F)); //test strength
    }

    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        TileEntity tileEntity = worldIn.getBlockEntity(pos);

        if(!worldIn.isClientSide())
        {
            if(tileEntity instanceof FleshAltarTile)
            {
                INamedContainerProvider containerProvider = createContainerProvier(worldIn, pos);

                NetworkHooks.openGui((ServerPlayerEntity) player, containerProvider, tileEntity.getBlockPos());
            }
            else
            {
                throw new IllegalStateException("Tile entity for flesh altar is missing.");
            }
        }
        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvier(World worldIn, BlockPos pos)
    {
        return new INamedContainerProvider()
        {
            @Override
            public ITextComponent getDisplayName()
            {
                return new TranslationTextComponent(("screen.wendigo.flesh_altar"));
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity)
            {
                return new FleshAltarContainer(i, worldIn, pos, playerInventory, playerEntity);
            }
        };
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
