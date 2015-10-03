// Template version 1.1
// Java generated by Techne

package com.andrewlray.mcmods.dessertcraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBarrel extends ModelBase {
	// fields
	ModelRenderer barrel;
	ModelRenderer wall1;
	ModelRenderer wall2;
	ModelRenderer wall3;
	ModelRenderer wall4;

	public ModelBarrel() {
		textureWidth = 64;
		textureHeight = 64;

		barrel = new ModelRenderer(this, 0, 0);
		barrel.addBox(0F, 0F, 0F, 14, 14, 14);
		barrel.setRotationPoint(-7F, 10F, -7F);
		barrel.setTextureSize(64, 64);
		barrel.mirror = true;
		setRotation(barrel, 0F, 0F, 0F);
		wall1 = new ModelRenderer(this, 0, 28);
		wall1.addBox(0F, 0F, 0F, 12, 2, 2);
		wall1.setRotationPoint(-7F, 8F, 5F);
		wall1.setTextureSize(64, 64);
		wall1.mirror = true;
		setRotation(wall1, 0F, 0F, 0F);
		wall2 = new ModelRenderer(this, 28, 28);
		wall2.addBox(0F, 0F, 0F, 12, 2, 2);
		wall2.setRotationPoint(-5F, 8F, -7F);
		wall2.setTextureSize(64, 64);
		wall2.mirror = true;
		setRotation(wall2, 0F, 0F, 0F);
		wall3 = new ModelRenderer(this, 0, 32);
		wall3.addBox(0F, 0F, 0F, 2, 2, 12);
		wall3.setRotationPoint(5F, 8F, -5F);
		wall3.setTextureSize(64, 64);
		wall3.mirror = true;
		setRotation(wall3, 0F, 0F, 0F);
		wall4 = new ModelRenderer(this, 28, 32);
		wall4.addBox(0F, 0F, 0F, 2, 2, 12);
		wall4.setRotationPoint(-7F, 8F, -7F);
		wall4.setTextureSize(64, 64);
		wall4.mirror = true;
		setRotation(wall4, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		barrel.render(f5);
		wall1.render(f5);
		wall2.render(f5);
		wall3.render(f5);
		wall4.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	public void renderModel(float f) {
		barrel.render(f);
		wall1.render(f);
		wall2.render(f);
		wall3.render(f);
		wall4.render(f);
	}

}