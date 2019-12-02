package com.teamcitrus.fruitsforagingandfarming.common.entities;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCoconut extends EntityFallingBlock {


    public EntityCoconut(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z, BlockRegistration.COCONUT.getStateFromMeta(4));
        this.setHurtEntities(true);
    }


    public EntityCoconut(World worldIn) {
        super(worldIn);
    }
    public boolean canBeAttackedWithItem()
    {
        return true;
    }

    public boolean canBeCollidedWith()
    {
        return true;
    }

    @Override
    public boolean hitByEntity(Entity entityIn) {

        if (!entityIn.getEntityWorld().isRemote) {
            this.setDead();
            EntityItem item = new EntityItem(entityIn.getEntityWorld(),this.posX,this.posY,this.posZ,new ItemStack(BlockRegistration.COCONUT,1));
            entityIn.getEntityWorld().spawnEntity(item);
            return true;
        }
        return  false;
    }
}
