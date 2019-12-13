package com.teamcitrus.fruitsforagingandfarming.common.entities;

import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityCoconut extends EntityFallingBlock {

        int state;

    public EntityCoconut(World worldIn, double x, double y, double z, int state) {
        super(worldIn, x, y, z, BlockRegistration.COCONUT.getStateFromMeta(state));
        this.state=state;
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
            if (state >= 2 && state < 5) {
                this.setDead();
                EntityItem item = new EntityItem(entityIn.getEntityWorld(), this.posX, this.posY, this.posZ, new ItemStack(BlockRegistration.COCONUT, 1));
                entityIn.getEntityWorld().spawnEntity(item);
                return true;
            }
            else if (state>=5) {
                this.setDead();
                EntityItem item = new EntityItem(entityIn.getEntityWorld(), this.posX, this.posY, this.posZ, new ItemStack(ItemRegistration.CRACKED_COCONUT, 1));
                entityIn.getEntityWorld().spawnEntity(item);
                return true;

            }


        }

        return  false;
    }
}
