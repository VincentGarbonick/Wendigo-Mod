package com.ThaddeusHalifax.WendigoMod.tools;
import com.ThaddeusHalifax.WendigoMod.util.RegistryHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;


import java.io.Console;
import java.util.Random;


public class FlayingBlade extends SwordItem
{
    // variable for storing our random numbers when we create a FlayingBlade
    private Random randomNumberClass;
    private int upperBoundDrop;
    private int upperBoundFleshCount;

    // call the default constructor
    public FlayingBlade(    net.minecraft.item.IItemTier p_i48460_1_,
                            int p_i48460_2_,
                            float p_i48460_3_,
                            net.minecraft.item.Item.Properties p_i48460_4_)
    {
        super(p_i48460_1_,p_i48460_2_,p_i48460_3_,p_i48460_4_);

        this.randomNumberClass = new Random();
        this.upperBoundDrop = 100;
        this.upperBoundFleshCount = 3;

    }
    // override for attacking- use base method and then check if it's an NPC and roll with each hit
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if(target.getEntity() instanceof VillagerEntity)
        {
            // ~1/3 chance for dropping flesh
            if(randomNumberClass.nextInt(upperBoundDrop) <= 34)
            {
                Vector3d villagerPosition = target.position();

                World thisWorld = target.level; // serverside world

                ItemEntity newItem = new ItemEntity(thisWorld, villagerPosition.x,
                        villagerPosition.y, villagerPosition.z, new ItemStack(RegistryHandler.FLESH.get(),
                        randomNumberClass.nextInt(upperBoundFleshCount)));

                thisWorld.addFreshEntity(newItem);
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
