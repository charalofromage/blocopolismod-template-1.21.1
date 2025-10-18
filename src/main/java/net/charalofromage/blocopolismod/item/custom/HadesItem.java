package net.charalofromage.blocopolismod.item.custom;

import net.charalofromage.blocopolismod.item.ModItems;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class HadesItem extends Item {
    boolean isCrafted;
    public HadesItem(Settings settings, boolean isCrafted) {
        super(settings);
        this.isCrafted = isCrafted;
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
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getWorld();

        if (!world.isClient) {
            if (stack.getDamage() == 3 && isCrafted){
                return false;
            }
            if(target.getHealth() < 1){
                target.setHealth(0);
            }else{
            target.setHealth(1);
            }
            if (isCrafted){
                if (stack.getDamage() == 2){
                    stack.setDamage(3);
                }else{
                stack.damage(1, attacker, EquipmentSlot.MAINHAND);
                }
            }else {
                stack.decrementUnlessCreative(1, attacker);
                return super.postHit(stack, target, attacker);
            }
        }
        return false;

    }
    public boolean canBeEnchantedWith(ItemStack stack, RegistryEntry<net.minecraft.enchantment.Enchantment> enchantment, EnchantingContext context) {
        return false;
    }
    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.PIECE_OF_BLADE_OF_HADES);
    }
}