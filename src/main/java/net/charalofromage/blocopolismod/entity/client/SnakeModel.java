package net.charalofromage.blocopolismod.entity.client;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.entity.custom.SnakeEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class SnakeModel<T extends SnakeEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer SNAKE = new EntityModelLayer(Identifier.of(BlocopolisMod.MOD_ID, "snake"), "main");

    public SnakeModel(ModelPart root) {
        this.snake = root.getChild("snake");
        this.bone = this.snake.getChild("bone");
        this.head = this.snake.getChild("head");
        this.langue = this.head.getChild("langue");
        this.cou = this.head.getChild("cou");
    }
    private final ModelPart snake;
    private final ModelPart bone;
    private final ModelPart head;
    private final ModelPart langue;
    private final ModelPart cou;

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData snake = modelPartData.addChild("snake", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData bone = snake.addChild("bone", ModelPartBuilder.create().uv(0, 0).cuboid(-12.0F, -7.0F, 0.0F, 24.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(48, 12).cuboid(6.0F, -7.0F, -11.0F, 6.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(44, 35).cuboid(-12.0F, -7.0F, 0.0F, 6.0F, 6.0F, 16.0F, new Dilation(0.0F))
                .uv(60, 0).cuboid(-12.0F, -7.0F, 10.0F, 16.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(-1, 76).cuboid(-5.0F, -7.0F, -11.0F, 17.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(0, 35).cuboid(-2.0F, -7.0F, 10.0F, 6.0F, 6.0F, 16.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = snake.addChild("head", ModelPartBuilder.create().uv(0, 12).cuboid(-5.0F, -8.0F, -21.0F, 8.0F, 7.0F, 16.0F, new Dilation(0.0F))
                .uv(64, 76).cuboid(0.0F, -7.0F, -22.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F))
                .uv(72, 76).cuboid(-5.0F, -7.0F, -22.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData langue = head.addChild("langue", ModelPartBuilder.create().uv(44, 57).cuboid(-2.0F, -3.0F, -27.0F, 2.0F, 0.0F, 19.0F, new Dilation(0.0F))
                .uv(44, 76).cuboid(-4.0F, -3.0F, -29.0F, 2.0F, 0.0F, 3.0F, new Dilation(0.0F))
                .uv(54, 76).cuboid(0.0F, -3.0F, -29.0F, 2.0F, 0.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cou = head.addChild("cou", ModelPartBuilder.create().uv(0, 57).cuboid(-5.0F, -6.0F, -19.0F, 8.0F, 5.0F, 14.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }

    @Override
    public void setAngles(SnakeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);
        this.updateAnimation(entity.idleAnimationState, SnakeAnimations.snake_idleAnimation, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, SnakeAnimations.snake_Attack, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch){
        headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
        headPitch = MathHelper.clamp(headPitch, -25.0f, 45.0f);

        this.head.yaw = headYaw * 0.017453292f;
        this.head.pitch = headPitch * 0.017453292f;
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        snake.render(matrices, vertexConsumer, light, overlay, color);
    }
    @Override
    public ModelPart getPart() {
        return snake;
    }
}