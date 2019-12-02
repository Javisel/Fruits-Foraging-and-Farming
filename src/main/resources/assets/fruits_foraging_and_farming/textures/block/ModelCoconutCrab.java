package f;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelCoconutCrab - Coda
 * Created using Tabula 7.1.0
 */
public class ModelCoconutCrab extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer armLeft;
    public ModelRenderer armRight;
    public ModelRenderer legLeft1;
    public ModelRenderer legLeft2;
    public ModelRenderer legLeft3;
    public ModelRenderer legRight3;
    public ModelRenderer legRight2;
    public ModelRenderer legRight1;
    public ModelRenderer head;
    public ModelRenderer clawLeft;
    public ModelRenderer clawLeft_1;
    public ModelRenderer antenna;

    public ModelCoconutCrab() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.armLeft = new ModelRenderer(this, 20, 7);
        this.armLeft.mirror = true;
        this.armLeft.setRotationPoint(2.0F, 0.0F, -2.0F);
        this.armLeft.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(armLeft, 0.0F, -0.5235987755982988F, 0.17453292519943295F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, 20.0F, 1.0F);
        this.body.addBox(-3.5F, -2.0F, -3.0F, 7, 4, 6, 0.0F);
        this.legLeft1 = new ModelRenderer(this, 30, 8);
        this.legLeft1.mirror = true;
        this.legLeft1.setRotationPoint(2.5F, 0.0F, -1.5F);
        this.legLeft1.addBox(0.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legLeft1, 0.0F, 0.6981317007977318F, 0.6981317007977318F);
        this.legRight1 = new ModelRenderer(this, 30, 8);
        this.legRight1.setRotationPoint(-2.5F, 0.0F, -1.5F);
        this.legRight1.addBox(-7.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legRight1, 0.0F, -0.6981317007977318F, -0.6981317007977318F);
        this.legRight2 = new ModelRenderer(this, 0, 10);
        this.legRight2.setRotationPoint(-2.5F, 0.0F, 0.2F);
        this.legRight2.addBox(-7.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legRight2, 0.0F, 0.0F, -0.6981317007977318F);
        this.legLeft3 = new ModelRenderer(this, 46, 10);
        this.legLeft3.mirror = true;
        this.legLeft3.setRotationPoint(2.5F, 0.0F, 1.5F);
        this.legLeft3.addBox(0.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
        this.setRotateAngle(legLeft3, 0.0F, -0.6108652381980153F, 1.0471975511965976F);
        this.clawLeft_1 = new ModelRenderer(this, 30, 18);
        this.clawLeft_1.setRotationPoint(0.0F, 0.0F, -5.5F);
        this.clawLeft_1.addBox(-1.5F, -0.5F, -4.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(clawLeft_1, 0.0F, -0.2617993877991494F, 0.0F);
        this.antenna = new ModelRenderer(this, 47, 14);
        this.antenna.setRotationPoint(0.0F, -1.0F, -3.5F);
        this.antenna.addBox(-1.0F, -0.5F, -5.0F, 2, 1, 5, 0.0F);
        this.setRotateAngle(antenna, -0.2617993877991494F, 0.0F, 0.0F);
        this.armRight = new ModelRenderer(this, 20, 7);
        this.armRight.setRotationPoint(-2.0F, 0.0F, -2.0F);
        this.armRight.addBox(-1.0F, -1.0F, -6.0F, 2, 2, 6, 0.0F);
        this.setRotateAngle(armRight, 0.0F, 0.5235987755982988F, -0.17453292519943295F);
        this.legRight3 = new ModelRenderer(this, 46, 10);
        this.legRight3.setRotationPoint(-2.5F, 0.0F, 1.5F);
        this.legRight3.addBox(-6.0F, -1.0F, -1.0F, 6, 2, 2, 0.0F);
        this.setRotateAngle(legRight3, 0.0F, 0.6108652381980153F, -1.0471975511965976F);
        this.legLeft2 = new ModelRenderer(this, 0, 10);
        this.legLeft2.mirror = true;
        this.legLeft2.setRotationPoint(2.5F, 0.0F, 0.2F);
        this.legLeft2.addBox(0.0F, -1.0F, -1.0F, 7, 2, 2, 0.0F);
        this.setRotateAngle(legLeft2, 0.0F, 0.0F, 0.6981317007977318F);
        this.head = new ModelRenderer(this, 26, 0);
        this.head.setRotationPoint(0.0F, -0.5F, -3.0F);
        this.head.addBox(-1.5F, -1.5F, -4.0F, 3, 3, 4, 0.0F);
        this.clawLeft = new ModelRenderer(this, 30, 18);
        this.clawLeft.mirror = true;
        this.clawLeft.setRotationPoint(0.0F, 0.0F, -5.5F);
        this.clawLeft.addBox(-1.5F, -0.5F, -4.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(clawLeft, 0.0F, 0.2617993877991494F, 0.0F);
        this.body.addChild(this.armLeft);
        this.body.addChild(this.legLeft1);
        this.body.addChild(this.legRight1);
        this.body.addChild(this.legRight2);
        this.body.addChild(this.legLeft3);
        this.armRight.addChild(this.clawLeft_1);
        this.head.addChild(this.antenna);
        this.body.addChild(this.armRight);
        this.body.addChild(this.legRight3);
        this.body.addChild(this.legLeft2);
        this.body.addChild(this.head);
        this.armLeft.addChild(this.clawLeft);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
