package com.teamcitrus.fruitsforagingandfarming.common.capabilities;

import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {


    public static final ResourceLocation ENTITYDATA = new ResourceLocation(FruitsForagingAndFarming.MODID, "FFFEntityData");


    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {


        if (event.getObject() instanceof EntityLivingBase && !(event.getObject() instanceof EntityPlayer)) {
            event.addCapability(ENTITYDATA, new EntityDataProvider());


        }


    }

}
