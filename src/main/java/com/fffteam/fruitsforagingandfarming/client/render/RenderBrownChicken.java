package com.fffteam.fruitsforagingandfarming.client.render;

import com.fffteam.fruitsforagingandfarming.common.entities.EntityBrownChicken;
import com.fffteam.fruitsforagingandfarming.main.FruitsForagingAndFarming;
import net.minecraft.client.model.ModelChicken;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)

public class RenderBrownChicken extends RenderLiving<EntityBrownChicken>
{
    private static final ResourceLocation BROWN_CHICKEN_TEXTURES = new ResourceLocation(FruitsForagingAndFarming.MODID + ":" +"textures/entity/brown_chicken.png");

    public RenderBrownChicken(RenderManager p_i47211_1_)
    {
        super(p_i47211_1_, new ModelChicken(), 0.3F);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityBrownChicken entity)
    {
        return BROWN_CHICKEN_TEXTURES;
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityBrownChicken livingBase, float partialTicks)
    {
        float f = livingBase.oFlap + (livingBase.wingRotation - livingBase.oFlap) * partialTicks;
        float f1 = livingBase.oFlapSpeed + (livingBase.destPos - livingBase.oFlapSpeed) * partialTicks;
        return (MathHelper.sin(f) + 1.0F) * f1;
    }


}