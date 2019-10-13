package com.fffteam.fruitsforagingandfarming.common.effects;

import com.fffteam.fruitsforagingandfarming.common.utilities.MobUtilities;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySilverfish;

public class Infestation extends MobEffect {

    public Infestation() {
        super(true, 192 * 192 * 192, "infested");
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {


            if (!entityLivingBaseIn.getEntityWorld().isRemote) {

                for (int i =0; i<1+amplifier;i++) {
                    MobUtilities.spawnCreature(entityLivingBaseIn.getEntityWorld(),
                            new EntitySilverfish(entityLivingBaseIn.world), entityLivingBaseIn.posX,
                            entityLivingBaseIn.posY, entityLivingBaseIn.posZ);
                }
            }


    }

    @Override

    public boolean isReady(int duration, int amplifier) {

      return duration%20==0;
    }

}
