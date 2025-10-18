package net.charalofromage.blocopolismod.block.custom;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.util.math.random.Random;

public class ModSpawner extends Block {
EntityType entityType;
int delay;
    public ModSpawner(Settings settings, EntityType entityType, int delay) {
        super(settings);
        this.entityType = entityType;
        this.delay = delay;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.isClient()) {
            BlockPos above = pos.up();
            while (!world.getBlockState(above).isAir() && above.getY() < world.getTopY()) {
                above = above.up();
            }

            Entity entity = entityType.create(world);
            if (entity instanceof MobEntity mob) {
                if (mob != null) {
                    mob.refreshPositionAndAngles(above, 0.0F, 0.0F);
                    mob.setAiDisabled(true);
                    mob.setPersistent();
                    world.spawnEntity(entity);
                } else if (entity instanceof AnimalEntity animalEntity) {
                    if (animalEntity != null) {
                        animalEntity.refreshPositionAndAngles(above, 0.0F, 0.0F);
                        animalEntity.setAiDisabled(true);
                        animalEntity.setPersistent();
                        world.spawnEntity(entity);
                    }
                }
                world.scheduleBlockTick(pos, this, delay);
            }
        }
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        super.onBlockAdded(state, world, pos, oldState, notify);
        if (!world.isClient()) {
            world.scheduleBlockTick(pos, this, 300);
        }
    }
}
