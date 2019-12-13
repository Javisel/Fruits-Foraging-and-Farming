package com.teamcitrus.fruitsforagingandfarming.common.network;

import com.teamcitrus.fruitsforagingandfarming.common.capabilities.EntityDataProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.Sys;
import scala.collection.parallel.ParIterableLike;

import java.util.List;

@SideOnly(Side.CLIENT)
public class EntityDataMessageHandler implements IMessageHandler<EntityDataMessage, IMessage> {



    @SideOnly(Side.CLIENT)
    @Override
    public IMessage onMessage(EntityDataMessage message, MessageContext ctx) {


        if (Minecraft.getMinecraft().world.getEntityByID(message.entityid) !=null) {
            System.out.println("THE ID HAS BEEN FOUND!");




        }



        return null;
    }
}
