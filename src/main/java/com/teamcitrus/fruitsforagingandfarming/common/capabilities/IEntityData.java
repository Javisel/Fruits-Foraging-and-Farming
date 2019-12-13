package com.teamcitrus.fruitsforagingandfarming.common.capabilities;

import net.minecraft.nbt.NBTTagCompound;

public interface IEntityData {

    int getEntityType();
    void setEntityType(int type);
    NBTTagCompound writeNBT();
    boolean readNBT(NBTTagCompound nbt);

}
