package com.teamcitrus.fruitsforagingandfarming.common.effects;

import com.teamcitrus.fruitsforagingandfarming.common.utilities.MobUtilities;
import com.teamcitrus.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.world.EnumDifficulty;


public class Infestation extends MobEffect {

    public Infestation() {
        super(true, 0x7F7F7F, "infestation");
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {

        if (!entityLivingBaseIn.getEntityWorld().isRemote) {

            if (entityLivingBaseIn.getEntityWorld().getDifficulty() == EnumDifficulty.PEACEFUL) {
                entityLivingBaseIn.removePotionEffect(this);
                return;
            }
            for (int i = 0; i < 1 + amplifier; i++) {
                entityLivingBaseIn.attackEntityFrom(FruitsForagingAndFarming.silverfishAlien, 1f);

                MobUtilities.spawnCreature(entityLivingBaseIn.getEntityWorld(),
                        new EntitySilverfish(entityLivingBaseIn.world), entityLivingBaseIn.posX,
                        entityLivingBaseIn.posY + (entityLivingBaseIn.height * 0.5), entityLivingBaseIn.posZ);
            }
        }


    }

    @Override

    public boolean isReady(int duration, int amplifier) {

        return duration % 20 == 0;
    }

}
