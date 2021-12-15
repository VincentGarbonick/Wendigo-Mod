package com.ThaddeusHalifax.WendigoMod.tools;
//import com.sun.istack.internal.NotNull;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;


public class FlayingBlade extends SwordItem
{

    // call the default constructor
    /*
    public FlayingBlade(    @NotNull net.minecraft.item.IItemTier p_i48460_1_,
                            int p_i48460_2_,
                            float p_i48460_3_,
                            @NotNull net.minecraft.item.Item.Properties p_i48460_4_)
    {
        super(p_i48460_1_,p_i48460_2_,p_i48460_3_,p_i48460_4_);
    }
    */
    // call the default constructor
    public FlayingBlade(    net.minecraft.item.IItemTier p_i48460_1_,
                            int p_i48460_2_,
                            float p_i48460_3_,
                            net.minecraft.item.Item.Properties p_i48460_4_)
    {
        super(p_i48460_1_,p_i48460_2_,p_i48460_3_,p_i48460_4_);
    }
    // override for attacking- use base method and then check if it's an NPC and roll on loot table with each hit
}
