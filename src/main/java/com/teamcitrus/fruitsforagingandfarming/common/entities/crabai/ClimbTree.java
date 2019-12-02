package com.teamcitrus.fruitsforagingandfarming.common.entities.crabai;

import net.minecraft.entity.ai.EntityAIBase;

public class ClimbTree extends EntityAIBase {
    public ClimbTree() {
        super();
    }

    @Override
    public boolean shouldExecute() {
        return false;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting();
    }

    @Override
    public boolean isInterruptible() {
        return super.isInterruptible();
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }

    @Override
    public void updateTask() {
        super.updateTask();
    }

    @Override
    public void setMutexBits(int mutexBitsIn) {
        super.setMutexBits(mutexBitsIn);
    }

    @Override
    public int getMutexBits() {
        return super.getMutexBits();
    }
}
