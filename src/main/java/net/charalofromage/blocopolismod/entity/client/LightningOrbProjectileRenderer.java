package net.charalofromage.blocopolismod.entity.client;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.entity.custom.LightningOrbProjectileEntity;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class LightningOrbProjectileRenderer extends EntityRenderer<LightningOrbProjectileEntity> {
    protected LightningOrbProjectileModel model;

    @Override
    public void render(LightningOrbProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        if (!entity.isOnGround()) {
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw())));
        }
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    public LightningOrbProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new LightningOrbProjectileModel(ctx.getPart(LightningOrbProjectileModel.LIGHTNING_ORB));
    }

    @Override
    public Identifier getTexture(LightningOrbProjectileEntity entity) {
        return Identifier.of(BlocopolisMod.MOD_ID, "textures/entity/lightning_orb/lightning_orb.png");
    }
}
