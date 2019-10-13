package com.fffteam.fruitsforagingandfarming.common.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SilverfishEgg extends ItemFoodBase {
    public SilverfishEgg() {
        super("silverfishegg",1);
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
         //
        }
    }
}
