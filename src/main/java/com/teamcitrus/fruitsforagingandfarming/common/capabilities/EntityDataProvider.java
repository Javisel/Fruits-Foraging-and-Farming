package com.teamcitrus.fruitsforagingandfarming.common.capabilities;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EntityDataProvider implements ICapabilitySerializable<NBTBase> {
    @CapabilityInject(IEntityData.class)
    public static final Capability<IEntityData> ENTITY_DATA_CAPABILITY = null;

    private IEntityData instance = ENTITY_DATA_CAPABILITY.getDefaultInstance();

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return capability == ENTITY_DATA_CAPABILITY;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        return capability == ENTITY_DATA_CAPABILITY ? ENTITY_DATA_CAPABILITY.cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return ENTITY_DATA_CAPABILITY.getStorage().writeNBT(ENTITY_DATA_CAPABILITY, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        ENTITY_DATA_CAPABILITY.getStorage().readNBT(ENTITY_DATA_CAPABILITY, this.instance, null, nbt);
    }
}