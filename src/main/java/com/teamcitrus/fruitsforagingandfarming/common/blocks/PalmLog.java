package com.teamcitrus.fruitsforagingandfarming.common.blocks;

import com.teamcitrus.fruitsforagingandfarming.common.blocks.BlockLogBase;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PalmLog extends BlockLogBase {
    public PalmLog() {
        super("palm_log");
    }

    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {


        if (!worldIn.isRemote) {

            for (int y = 0; y <= 7; y++) {

                for (int x = -4; x <= 4; x++) {

                    for (int z = -4; z <= 4; z++) {
                        BlockPos newpos = new BlockPos(pos.getX()+x, pos.getY()+y, pos.getZ()+z);
                        if (worldIn.getBlockState(newpos).getBlock()==BlockRegistration.COCONUT && worldIn.getBlockState(newpos.up()).getBlock()==BlockRegistration.PALM_LEAVES && BlockRegistration.COCONUT.getMetaFromState(worldIn.getBlockState(newpos))>=2) {


                            EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double) newpos.getX() + 0.5D, (double) newpos.getY(), (double) newpos.getZ() + 0.5D, BlockRegistration.COCONUT.getStateFromMeta(4));
                            entityfallingblock.setHurtEntities(true);
                            worldIn.spawnEntity(entityfallingblock);


                        }


                    }

                }

            }


        }
    }

}

