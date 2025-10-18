package net.charalofromage.blocopolismod.entity.client;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.entity.custom.SnakeEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SnakeRenderer extends MobEntityRenderer<SnakeEntity, SnakeModel<SnakeEntity>> {
    public SnakeRenderer(EntityRendererFactory.Context context) {
        super(context, new SnakeModel<>(context.getPart(SnakeModel.SNAKE)), 0.75f);
    }

    @Override
    public Identifier getTexture(SnakeEntity entity) {
        return Identifier.of(BlocopolisMod.MOD_ID, "textures/entity/snake/snake.png");
    }

    @Override
    public void render(SnakeEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {

        if (livingEntity.isBaby()){
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        }else {
            matrixStack.scale(1f, 1f, 1f);
        }
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
