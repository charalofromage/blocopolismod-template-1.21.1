package net.charalofromage.blocopolismod.item.custom;

import net.charalofromage.blocopolismod.entity.custom.LightningOrbProjectileEntity;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ProjectileItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class ZeusItem extends Item {
    public ZeusItem(Settings settings) {
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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {

            LightningOrbProjectileEntity lightningOrbProjectileEntity = new LightningOrbProjectileEntity(world, player);

            lightningOrbProjectileEntity.setPosition(
                    player.getX(),
                    player.getEyeY() - 0.1, // légèrement en dessous des yeux pour éviter que ça parte “dans la tête”
                    player.getZ()
            );

            lightningOrbProjectileEntity.setVelocity(player, player.getPitch(), player.getYaw(), 0.0000000000000000000000f, 3f, 0f);
            world.spawnEntity(lightningOrbProjectileEntity);

            stack.damage(128, player,EquipmentSlot.MAINHAND);

            return TypedActionResult.success(stack, world.isClient());
        }
        return TypedActionResult.pass(stack);
    }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, EquipmentSlot.MAINHAND);
    }
}