package com.teamcitrus.fruitsforagingandfarming.common.entities.crabai;

import com.teamcitrus.fruitsforagingandfarming.common.entities.EntityCoconutCrab;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class ClimbTree extends EntityAIBase {

    private EntityCoconutCrab crab;
    private BlockPos coconut;
    private World world;
    public ClimbTree(EntityCoconutCrab crab) {
        super();
        this.crab=crab;
        world=crab.getEntityWorld();
    }

    @Override
    public boolean shouldExecute() {
        return !world.isRemote && !world.isDaytime() && findTree();
    }

    @Override
    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting();
    }
    private boolean findTree()
    {
        Random random = this.crab.getRNG();
        BlockPos blockpos = new BlockPos(this.crab.posX, this.crab.getEntityBoundingBox().minY, this.crab.posZ);

        for (int i = 0; i < 10; ++i)
        {
            BlockPos blockpos1 = blockpos.add(random.nextInt(20) - 10, this.crab.posY, random.nextInt(20) - 10);

            if (this.world.canSeeSky(crab.getPosition()) && this.crab.getBlockPathWeight(blockpos1) < 0.0F)
            {
                if (world.getBlockState(blockpos1).getBlock() == BlockRegistration.PALM_LOG) {

                    for (int t = 0; t <4; t++) {

                        if (world.getBlockState(blockpos1.up(t)).getBlock()==BlockRegistration.PALM_LOG) {

                            return false;
                        }
                        BlockPos palm = blockpos1.up(4);

                        int tries = 6;

                        while (tries!=0) {

                            int rx = MathHelper.getInt(random,-6,6);
                            int ry = MathHelper.getInt(random,-6,6);
                            int rz = MathHelper.getInt(random,-6,6);

                            if (world.getBlockState(palm.add(rx,ry,rz)).getBlock()==BlockRegistration.COCONUT) {
                                coconut=palm.add(rx,ry,rz);
                                return true;

                            }
                            tries--;

                        }



                    }


                }


                return true;
            }
        }

        return false;
    }
    @Override
    public boolean isInterruptible() {
        return super.isInterruptible();
    }

    @Override
    public void startExecuting() {

        crab.getNavigator().setPath(crab.getNavigator().getPathToPos(coconut),0.5);
    }

    @Override
    public void resetTask() {
        coconut=null;
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
