package net.charalofromage.blocopolismod.entity.custom;

import net.charalofromage.blocopolismod.entity.ModEntities;
import net.charalofromage.blocopolismod.util.TickScheduler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ExplosiveProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector2f;

public class LightningOrbProjectileEntity extends ExplosiveProjectileEntity{


    public Vector2f groundedOffset;

    public LightningOrbProjectileEntity(EntityType<? extends ExplosiveProjectileEntity> entityType, World world) {
        super(entityType, world);
    }
    public LightningOrbProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.LIGHTNING_ORB, player, player.getRotationVector(), world);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {

            super.onEntityHit(entityHitResult);
            this.discard();
            World world = entityHitResult.getEntity().getWorld();
            BlockPos targetPos = BlockPos.ofFloored(entityHitResult.getPos());

            if (world instanceof ServerWorld serverWorld) {
                for (int i = 0; i < 20; i++) {
                    int delay = i * 2; // 1 éclair par seconde
                    TickScheduler.runLater(serverWorld, delay, () -> {
                        LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(serverWorld);
                        if (lightning != null) {
                            lightning.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(targetPos));
                            serverWorld.spawnEntity(lightning);
                        }
                    });
                }
            }
        }


    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {

            super.onBlockHit(blockHitResult);
            this.discard();
            BlockPos targetPos = blockHitResult.getBlockPos();
            World world = this.getWorld();
            if (world instanceof ServerWorld serverWorld) {
                for (int i = 0; i < 20; i++) {
                    int delay = i * 2;
                    TickScheduler.runLater(serverWorld, delay, () -> {
                        LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(serverWorld);
                        if (lightning != null) {
                            lightning.refreshPositionAfterTeleport(Vec3d.ofBottomCenter(targetPos));
                            serverWorld.spawnEntity(lightning);
                        }
                    });
                }
            }
        
    }
    @Override
    public void tick() {

        if (!this.getWorld().isClient && (this.getBlockY() > this.getWorld().getTopY() + 30)) {
            this.discard();
        } else {
            super.tick();
        }
    }
}