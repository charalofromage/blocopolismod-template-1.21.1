package net.charalofromage.blocopolismod.item.custom;

import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.*;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.*;
import net.minecraft.world.World;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.world.event.GameEvent;
import java.util.function.Consumer;


public class PoseidonItem extends Item {
    public PoseidonItem(Settings settings) {
        super(settings);
    }

    public static AttributeModifiersComponent createAttributeModifiers(int baseAttackDamage, float attackSpeed) {
        return AttributeModifiersComponent.builder()
                .add(
                        EntityAttributes.GENERIC_ATTACK_DAMAGE,
                        new EntityAttributeModifier(
                                BASE_ATTACK_DAMAGE_MODIFIER_ID, (double) ((float) baseAttackDamage), EntityAttributeModifier.Operation.ADD_VALUE
                        ),
                        AttributeModifierSlot.MAINHAND
                )
                .add(
                        EntityAttributes.GENERIC_ATTACK_SPEED,
                        new EntityAttributeModifier(BASE_ATTACK_SPEED_MODIFIER_ID, (double) attackSpeed, EntityAttributeModifier.Operation.ADD_VALUE),
                        AttributeModifierSlot.MAINHAND
                )
                .build();
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

            World world = context.getWorld();
            ItemPlacementContext itemPlacementContext = new ItemPlacementContext(context);
            BlockPos blockPos = itemPlacementContext.getBlockPos();
            ItemStack itemStack = context.getStack();
            PlayerEntity playerEntity = context.getPlayer();

                if (world instanceof ServerWorld serverWorld) {
                    //Remplacer le DolphinEntity par un NautilusEntity
                    Consumer<DolphinEntity> consumer = EntityType.copier(serverWorld, itemStack, context.getPlayer());
                    DolphinEntity dolphinEntity = EntityType.DOLPHIN.create(serverWorld, consumer, blockPos, SpawnReason.MOB_SUMMONED, true, true);

                    if (dolphinEntity == null) {
                        return ActionResult.FAIL;
                    }

                    float f = (float) MathHelper.floor((MathHelper.wrapDegrees(context.getPlayerYaw() - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                    dolphinEntity.refreshPositionAndAngles(dolphinEntity.getX(), dolphinEntity.getY(), dolphinEntity.getZ(), f, 0.0F);
                    serverWorld.spawnEntityAndPassengers(dolphinEntity);
                    dolphinEntity.emitGameEvent(GameEvent.ENTITY_PLACE, context.getPlayer());

                context.getStack().damage(2, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));
                    playerEntity.getItemCooldownManager().set(this, 300);
                }
                return ActionResult.success(world.isClient);
            }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if (!world.isClient && entity instanceof PlayerEntity player){
            if (hasItemInInventory(player, ModItems.POSEIDON_WEAPON)){
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 90));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 90));
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.WATER_BREATHING, 90));
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
    public static boolean hasItemInInventory(PlayerEntity player, Item targetItem) {
        // Parcourt tous les slots de l'inventaire du joueur
        for (int i = 0; i < player.getInventory().size(); i++) {
            ItemStack stack = player.getInventory().getStack(i);

            // Vérifie que le stack n'est pas vide et correspond à l'item cible
            if (!stack.isEmpty() && stack.isOf(targetItem)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = target.getWorld();
        Direction direction = attacker.getFacing();

        if(!world.isClient){

            stack.damage(10, attacker, EquipmentSlot.MAINHAND);
        }


        return super.postHit(stack, target, attacker);
    }
}










