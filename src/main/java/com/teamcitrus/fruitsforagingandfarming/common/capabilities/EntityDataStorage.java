package com.teamcitrus.fruitsforagingandfarming.common.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class EntityDataStorage implements Capability.IStorage<IEntityData> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IEntityData> capability, IEntityData instance, EnumFacing side) {
        return instance.writeNBT();
    }

    @Override
    public void readNBT(Capability<IEntityData> capability, IEntityData instance, EnumFacing side, NBTBase nbt) {
        if (nbt instanceof NBTTagCompound)
            instance.readNBT((NBTTagCompound) nbt);
    }
}
