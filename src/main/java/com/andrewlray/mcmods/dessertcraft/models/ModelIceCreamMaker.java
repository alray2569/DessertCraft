package com.andrewlray.mcmods.dessertcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelIceCreamMaker extends ModelBase
{
  //fields
    ModelRenderer base;
    ModelRenderer handle1;
    ModelRenderer handle2;
    ModelRenderer border1;
    ModelRenderer border2;
    ModelRenderer border3;
    ModelRenderer border4;
  
  public ModelIceCreamMaker()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      base = new ModelRenderer(this, 0, 0);
      base.addBox(0F, 0F, 0F, 12, 10, 12);
      base.setRotationPoint(-6F, 14F, -6F);
      base.setTextureSize(64, 32);
      base.mirror = true;
      setRotation(base, 0F, 0F, 0F);
      handle1 = new ModelRenderer(this, 48, 0);
      handle1.addBox(0F, 0F, 0F, 2, 4, 2);
      handle1.setRotationPoint(-1F, 10F, -1F);
      handle1.setTextureSize(64, 32);
      handle1.mirror = true;
      setRotation(handle1, 0F, 0F, 0F);
      handle2 = new ModelRenderer(this, 48, 6);
      handle2.addBox(0F, 0F, 0F, 2, 2, 6);
      handle2.setRotationPoint(-1F, 8F, -1F);
      handle2.setTextureSize(64, 32);
      handle2.mirror = true;
      setRotation(handle2, 0F, 0F, 0F);
      border1 = new ModelRenderer(this, 14, 2);
      border1.addBox(0F, 0F, 0F, 2, 2, 10);
      border1.setRotationPoint(-6F, 12F, -6F);
      border1.setTextureSize(64, 32);
      border1.mirror = true;
      setRotation(border1, 0F, 0F, 0F);
      border2 = new ModelRenderer(this, 14, 2);
      border2.addBox(0F, 0F, 0F, 2, 2, 10);
      border2.setRotationPoint(6F, 12F, 6F);
      border2.setTextureSize(64, 32);
      border2.mirror = true;
      setRotation(border2, 0F, 3.141593F, 0F);
      border3 = new ModelRenderer(this, 14, 2);
      border3.addBox(0F, 0F, 0F, 2, 2, 10);
      border3.setRotationPoint(6F, 12F, -6F);
      border3.setTextureSize(64, 32);
      border3.mirror = true;
      setRotation(border3, 0F, -1.570796F, 0F);
      border4 = new ModelRenderer(this, 14, 2);
      border4.addBox(0F, 0F, 0F, 2, 2, 10);
      border4.setRotationPoint(-6F, 12F, 6F);
      border4.setTextureSize(64, 32);
      border4.mirror = true;
      setRotation(border4, 0F, 1.570796F, 0F);
  }
  
  @Override
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    base.render(f5);
    handle1.render(f5);
    handle2.render(f5);
    border1.render(f5);
    border2.render(f5);
    border3.render(f5);
    border4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  @Override
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  public void renderModel(float f) {
	    base.render(f);
	    handle1.render(f);
	    handle2.render(f);
	    border1.render(f);
	    border2.render(f);
	    border3.render(f);
	    border4.render(f);
  }

}
