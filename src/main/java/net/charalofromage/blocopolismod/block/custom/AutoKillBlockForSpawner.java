package net.charalofromage.blocopolismod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class AutoKillBlockForSpawner extends Block {

    public AutoKillBlockForSpawner(Settings settings) {
        super(settings);
    }


    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.isClient) {
            world.scheduleBlockTick(pos, this, 10); // déclenchement initial
        }
        super.onBlockAdded(state, world, pos, oldState, notify);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        List<Entity> entities = world.getOtherEntities(null, VoxelShapes.fullCube().getBoundingBox().offset(pos.up(1)),
                entity -> entity instanceof MobEntity);

        for (Entity entity : entities) {
            MobEntity mob = (MobEntity) entity;
            if (mob.isAiDisabled()) {
                mob.kill();
            }
        }

        // reprogrammer pour continuer à vérifier
        world.scheduleBlockTick(pos, this, 10);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.fullCube();
    }
}
