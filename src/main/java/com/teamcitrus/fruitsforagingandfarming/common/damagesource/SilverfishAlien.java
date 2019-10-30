package com.teamcitrus.fruitsforagingandfarming.common.damagesource;

import net.minecraft.util.DamageSource;

public class SilverfishAlien extends DamageSource {
    public SilverfishAlien() {
        super("fruits_foraging_and_farming.silverfishalien");
    }

    @Override
    public boolean isUnblockable() {
        return true;
    }

    @Override
    public DamageSource setDamageBypassesArmor() {
        return super.setDamageBypassesArmor();
    }
}
