package com.teamcitrus.fruitsforagingandfarming.common.network;

import com.teamcitrus.fruitsforagingandfarming.common.capabilities.EntityDataProvider;
import com.teamcitrus.fruitsforagingandfarming.common.capabilities.EntityDataStorage;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class EntityDataMessage implements IMessage {
    int entityid;
    NBTTagCompound tag;
    public EntityDataMessage(EntityLivingBase entityLivingBase) {


        entityid=entityLivingBase.getEntityId();
   //    System.out.println("ID: " + entityid);
        tag=entityLivingBase.getCapability(EntityDataProvider.ENTITY_DATA_CAPABILITY,null).writeNBT();



    }
    public EntityDataMessage() {
    }


    @Override
    public void fromBytes(ByteBuf buf) {
        entityid=ByteBufUtils.readVarInt(buf,7);
       tag=ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeVarInt(buf,entityid,7);
        ByteBufUtils.writeTag(buf,tag);
    }
}
