package net.charalofromage.blocopolismod.item.custom;

import com.google.common.collect.ImmutableMap;
import net.charalofromage.blocopolismod.item.ModArmorMaterials;
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

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.SILVER_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.SATURATION, 200, 0, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> HELMET_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.SILVER_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 1, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> LEGGING_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.SILVER_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.HASTE, 200, 1, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> BOOTS_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.SILVER_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.SPEED, 200, 1, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> BREASTPLATE_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.SILVER_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1, false, false))).build();

  private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> LEAD_HELMET_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.LEAD_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 0, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> LEAD_LEGGING_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.LEAD_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.HASTE, 200, 0, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> LEAD_BOOTS_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.LEAD_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.SPEED, 200, 0, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> LEAD_BREASTPLATE_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.LEAD_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 0, false, false))).build();

  private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> TRAVEL_HELMET_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 0, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> TRAVEL_LEGGING_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.SPEED, 200, 2, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> TRAVEL_BOOTS_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 10, 0, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> TRAVEL_BREASTPLATE_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 3, false, false))).build();

    private static final Map<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>> FULL_TRAVEL_EFFECT = (new ImmutableMap.Builder<RegistryEntry<ArmorMaterial>,
            List<StatusEffectInstance>>()).put(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL,
            List.of(new StatusEffectInstance(StatusEffects.SATURATION, 200, 0, false, false))).build();

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()){
            if(entity instanceof PlayerEntity player){
                if(hasFullSuitOfArmorOn(player)){
                    evaluateArmorEffects(player);
                }
                 if(hasHelmetArmorOn(player)){
                    evaluateHelmetEffects(player);
                }
                 if(hasBootsArmorOn(player)){
                    evaluateBootsEffects(player);
                }
                 if(hasBreastplateArmorOn(player)){
                    evaluateBreastplateEffects(player);
                }
                 if(hasLeggingsArmorOn(player)){
                    evaluateLeggingsEffects(player);
                }
                 if(hasBreastplateArmorOn(player)){
                    evaluateLeadBreastplateEffects(player);
                }
                 if(hasBootsArmorOn(player)){
                    evaluateLeadBootsEffects(player);
                }
                 if(hasLeggingsArmorOn(player)){
                    evaluateLeadLeggingsEffects(player);
                }
                 if(hasHelmetArmorOn(player)){
                    evaluateLeadHelmetEffects(player);
                }
                 if(hasBreastplateArmorOn(player)){
                    evaluateTravelBreastplateEffects(player);
                }
                 if(hasBootsArmorOn(player)){
                    evaluateTravelBootsEffects(player);
                }
                 if(hasLeggingsArmorOn(player)){
                    evaluateTravelLeggingsEffects(player);
                }
                 if(hasHelmetArmorOn(player)){
                    evaluateTravelHelmetEffects(player);
                }
                 if(hasFullSuitOfArmorOn(player)){
                    evaluateArmorTravelEffects(player);
                }

            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);

        }
    }

    private void evaluateHelmetEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : HELMET_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(3).getItem() == ModItems.SILVER_HELMET){
            addStatusEffectForArmor(player,mapArmorMaterial, mapStatusEffects);
            }

        }
    }
    private void evaluateBootsEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : BOOTS_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(0).getItem() == ModItems.SILVER_BOOTS){
            addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }
    private void evaluateLeggingsEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : LEGGING_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(1).getItem() == ModItems.SILVER_LEGGINGS) {
                addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }

        }
    }
    private void evaluateBreastplateEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : BREASTPLATE_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(2).getItem() == ModItems.SILVER_CHESTPLATE) {
                addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }

        }
    }

private void evaluateArmorTravelEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : FULL_TRAVEL_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffects);

        }
    }

    private void evaluateTravelHelmetEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : TRAVEL_HELMET_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(3).getItem() == ModItems.TRAVEL_HELMET){
            addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }

        }
    }
    private void evaluateTravelBootsEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : TRAVEL_BOOTS_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(0).getItem() == ModItems.TRAVEL_BOOTS){
            addStatusEffectForArmor(player,mapArmorMaterial, mapStatusEffects);
            }
        }
    }
    private void evaluateTravelLeggingsEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : TRAVEL_LEGGING_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(1).getItem() == ModItems.TRAVEL_LEGGINGS) {
                addStatusEffectForArmor(player,mapArmorMaterial, mapStatusEffects);
            }

        }
    }
    private void evaluateTravelBreastplateEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : TRAVEL_BREASTPLATE_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(2).getItem() == ModItems.TRAVEL_CHESTPLATE) {
            addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }

        }
    }

    private void evaluateLeadHelmetEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : LEAD_HELMET_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(3).getItem() == ModItems.LEAD_HELMET) {
                addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }
    private void evaluateLeadBootsEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : LEAD_BOOTS_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(0).getItem() == ModItems.LEAD_BOOTS) {
                addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }
        }
    }
    private void evaluateLeadLeggingsEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : LEAD_LEGGING_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(1).getItem() == ModItems.LEAD_LEGGINGS) {
                addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }

        }
    }
    private void evaluateLeadBreastplateEffects(PlayerEntity player) {
        for (Map.Entry<RegistryEntry<ArmorMaterial>, List<StatusEffectInstance>> entry : LEAD_BREASTPLATE_EFFECT.entrySet()) {
            RegistryEntry<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();
            if(player.getInventory().getArmorStack(2).getItem() == ModItems.LEAD_CHESTPLATE) {
                addStatusEffectForArmor(player, mapArmorMaterial, mapStatusEffects);
            }

        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, RegistryEntry<ArmorMaterial> mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect){
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect){
            for (StatusEffectInstance instance : mapStatusEffect){
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private void addStatusEffectForArmor(PlayerEntity player, RegistryEntry<ArmorMaterial> mapArmorMaterial, List<StatusEffectInstance> mapStatusEffect){
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffect){
            for (StatusEffectInstance instance : mapStatusEffect){
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player){
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasHelmetArmorOn(PlayerEntity player){
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty();
    }

    private boolean hasBreastplateArmorOn(PlayerEntity player){
        ItemStack breastplate = player.getInventory().getArmorStack(2);

        return !breastplate.isEmpty();
    }

    private boolean hasLeggingsArmorOn(PlayerEntity player){
        ItemStack leggings = player.getInventory().getArmorStack(1);

        return !leggings.isEmpty();
    }

    private boolean hasBootsArmorOn(PlayerEntity player){
        ItemStack boots = player.getInventory().getArmorStack(0);

        return !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(RegistryEntry<ArmorMaterial> material, PlayerEntity player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmorStack(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmorStack(1).getItem());
        ArmorItem breastplate = ((ArmorItem) player.getInventory().getArmorStack(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmorStack(3).getItem());

        return helmet.getMaterial() == material && breastplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}
