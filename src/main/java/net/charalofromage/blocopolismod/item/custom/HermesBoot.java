package net.charalofromage.blocopolismod.item.custom;

import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class HermesBoot extends ArmorItem {

    public HermesBoot(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!world.isClient && entity instanceof PlayerEntity player) {

            // Vérifie si les bottes d'Hermès sont bien équipées
            boolean isWearingHermes = player.getInventory().getArmorStack(0).getItem() == ModItems.HERMES_SHOOES;

            if (isWearingHermes) {
                if (!player.getAbilities().allowFlying) {
                    player.getAbilities().allowFlying = true;
                    player.sendAbilitiesUpdate();
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 10, 3));
                }
            } else {
                // On désactive le vol sauf si le joueur est en créatif ou spectateur
                if (!player.isCreative() && !player.isSpectator() && player.getAbilities().allowFlying) {
                    player.getAbilities().flying = false;
                    player.getAbilities().allowFlying = false;
                    player.sendAbilitiesUpdate();
                }
            }
        }
    }
}