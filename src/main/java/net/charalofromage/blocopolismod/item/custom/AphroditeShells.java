package net.charalofromage.blocopolismod.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AphroditeShells extends Item {
    public AphroditeShells(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);

        if (!world.isClient) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 9));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 150, 4));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 600, 4));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 10, 2));

            if (stack.isDamageable()) {
                if (hand == Hand.MAIN_HAND) {

                    stack.damage(1, player, EquipmentSlot.MAINHAND);
                }else{
                    stack.damage(1, player, EquipmentSlot.OFFHAND);
                }
            } else {
                stack.decrement(1);
            }

            player.getItemCooldownManager().set(this, 720);
        }

        return TypedActionResult.success(stack, world.isClient());
    }
}