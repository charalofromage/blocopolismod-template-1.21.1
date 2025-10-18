package net.charalofromage.blocopolismod.entity.client;

import com.ibm.icu.impl.locale.BaseLocale;
import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.entity.custom.LightningOrbProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class LightningOrbProjectileModel extends EntityModel<LightningOrbProjectileEntity> {
    public static final EntityModelLayer LIGHTNING_ORB = new EntityModelLayer(Identifier.of(BlocopolisMod.MOD_ID, "lightning_orb"), "main");
    private final ModelPart bone;

    public LightningOrbProjectileModel(ModelPart root) {
        this.bone = root.getChild("bone");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(-5.0F, -6.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 12).cuboid(-4.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 12).cuboid(-3.0F, -4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(0, 16).cuboid(-2.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 20.0F, 0.0F, -1.5708F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(LightningOrbProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        bone.render(matrices, vertexConsumer, light, overlay, color);
    }


}
