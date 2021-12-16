package com.ThaddeusHalifax.WendigoMod.tools;
//import com.sun.istack.internal.NotNull;
import com.ThaddeusHalifax.WendigoMod.util.RegistryHandler;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Dimension;
import net.minecraft.world.World;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.io.Console;
import java.util.Random;


public class FlayingBlade extends SwordItem
{
    // variable for storing our random numbers when we create a FlayingBlade
    private Random randomNumberClass;
    private int upperBound;
    private int upperBoundFlesh;

    // call the default constructor
    public FlayingBlade(    net.minecraft.item.IItemTier p_i48460_1_,
                            int p_i48460_2_,
                            float p_i48460_3_,
                            net.minecraft.item.Item.Properties p_i48460_4_)
    {
        super(p_i48460_1_,p_i48460_2_,p_i48460_3_,p_i48460_4_);

        this.randomNumberClass = new Random();
        this.upperBound = 100;
        this.upperBoundFlesh = 3;

    }
    // override for attacking- use base method and then check if it's an NPC and roll on loot table with each hit
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if(target.getEntity() instanceof VillagerEntity)
        {
            // ~1/3 chance for dropping flesh
            if(randomNumberClass.nextInt(upperBound) <= 34)
            {
                Vector3d villagerPosition = target.position();

                // seems this does clientside for some reason
                // ItemEntity['Rotten Flesh'/448, l='ClientLevel', x=23.70, y=67.00, z=99.07]
                //World thisWorld = Minecraft.getInstance().level;

                // this does serverside
                // ItemEntity['Rotten Flesh'/192, l='ServerLevel[Test Chamber]', x=23.70, y=67.00, z=98.91]
                World thisWorld = target.level;

                ItemEntity newItem = new ItemEntity(thisWorld, villagerPosition.x,
                        villagerPosition.y, villagerPosition.z, new ItemStack(RegistryHandler.FLESH.get(),
                        randomNumberClass.nextInt(upperBoundFlesh)));

                thisWorld.addFreshEntity(newItem);
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
