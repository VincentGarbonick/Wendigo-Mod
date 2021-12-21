package com.ThaddeusHalifax.WendigoMod.events;

import com.ThaddeusHalifax.WendigoMod.Wendigo;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Wendigo.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents
{
    /*
    @SubscribeEvent
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event)
    {
        LivingEntity player = event.getEntityLiving();
        if(player.getMainHandItem().getItem() != null && player.getMainHandItem().getItem() == Items.IRON_BLOCK)
        {
            System.out.print("Jumped with iron block");
        }
    }
     */
}
