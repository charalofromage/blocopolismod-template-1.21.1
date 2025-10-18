package net.charalofromage.blocopolismod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SnakeEntity extends AnimalEntity{
public final AnimationState idleAnimationState = new AnimationState();     //animation lorsqu'il ne se passe rien
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();


    public SnakeEntity(EntityType<? extends SnakeEntity> entityType, World world) {
        super(entityType, world);
    }


    private boolean isAttacking = false;
    private int attackAnimationTimer = 0;

    public void playAttackAnimation(){
        this.attackAnimationTimer = 0;
        this.isAttacking = true;
    }

    public boolean isAttacking() {
        return this.isAttacking;
    }

    @Override
    public boolean tryAttack(Entity target) {
        boolean success = super.tryAttack(target);
        System.out.println("tryAttack");
        if (success && this.getWorld().isClient) {
            System.out.println("success coté client");
                this.attackAnimationState.start(this.age);
        }
        if (success && !this.getWorld().isClient) {
            System.out.println("success coté serveur");
                this.attackAnimationState.start(this.age);

        if (!success){
            System.out.println("success == false");
        }
        }
        return success;
    }

    @Override
    protected void initGoals() {
       this.goalSelector.add(2, new SwimGoal(this));
       this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
       this.goalSelector.add(4, new LookAroundGoal(this));
       this.goalSelector.add(1, new MeleeAttackGoal(this, 1, true));
       this.targetSelector.add(0, new ActiveTargetGoal(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.75)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 35)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 40)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 1)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 25);
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0){
            this.idleAnimationTimeout = 200; //le cooldown en tick
            this.idleAnimationState.start(this.age);
        }else{
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()){
            this.setupAnimationStates();
        }
        if (isAttacking){
            attackAnimationTimer++;
            if (attackAnimationTimer >= 12){
                isAttacking = false;
                attackAnimationTimer = 0;
            }
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GHAST_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return super.getHurtSound(source);
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return super.getDeathSound();
    }
}
