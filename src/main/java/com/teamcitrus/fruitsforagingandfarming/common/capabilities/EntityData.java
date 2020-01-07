package com.teamcitrus.fruitsforagingandfarming.common.capabilities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class EntityData implements IEntityData {

    private int type=0;
    @Override
    public int getEntityType() {
        return type;
    }

    @Override
    public void setEntityType(int type) {



        this.type=type;
    }

    @Override
    public NBTTagCompound writeNBT() {
        NBTTagCompound nbt = new NBTTagCompound();
        nbt.setInteger("type",type);

        return nbt;
    }

    @Override
    public boolean readNBT(NBTTagCompound nbt) {

            type = nbt.getInteger("type");
            return true;


    }
}
