package net.charalofromage.blocopolismod;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.entity.ModEntities;
import net.charalofromage.blocopolismod.entity.client.LightningOrbProjectileModel;
import net.charalofromage.blocopolismod.entity.client.LightningOrbProjectileRenderer;
import net.charalofromage.blocopolismod.entity.client.SnakeModel;
import net.charalofromage.blocopolismod.entity.client.SnakeRenderer;
import net.charalofromage.blocopolismod.entity.custom.LightningOrbProjectileEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.indigo.renderer.render.BlockRenderInfo;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;

public class BlocopolisModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SILVER_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SILVER_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAD_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LEAD_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRONZE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRONZE_TRAPDOOR, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(SnakeModel.SNAKE, SnakeModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.SNAKE, SnakeRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(LightningOrbProjectileModel.LIGHTNING_ORB, LightningOrbProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.LIGHTNING_ORB, LightningOrbProjectileRenderer::new);

    }
}