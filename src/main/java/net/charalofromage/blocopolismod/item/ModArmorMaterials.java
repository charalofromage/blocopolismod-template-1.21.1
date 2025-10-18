package net.charalofromage.blocopolismod.item;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final RegistryEntry<ArmorMaterial> BRONZE_ARMOR_MATERIAL = registerArmorMaterial("bronze",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BODY, 6);
                map.put(ArmorItem.Type.BOOTS, 4);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 5);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, ()-> Ingredient.ofItems(ModItems.BRONZE_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BlocopolisMod.MOD_ID, "bronze"))), 2.5f, 0));

    public static final RegistryEntry<ArmorMaterial> LEAD_ARMOR_MATERIAL = registerArmorMaterial("lead",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BODY, 7);
                map.put(ArmorItem.Type.BOOTS, 5);
                map.put(ArmorItem.Type.LEGGINGS, 8);
                map.put(ArmorItem.Type.CHESTPLATE, 10);
                map.put(ArmorItem.Type.HELMET, 6);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, ()-> Ingredient.ofItems(ModItems.LEAD_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BlocopolisMod.MOD_ID, "lead"))), 3f, 0.1f));

    public static final RegistryEntry<ArmorMaterial> SILVER_ARMOR_MATERIAL = registerArmorMaterial("silver",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BODY, 8);
                map.put(ArmorItem.Type.BOOTS, 6);
                map.put(ArmorItem.Type.LEGGINGS, 10);
                map.put(ArmorItem.Type.CHESTPLATE, 12);
                map.put(ArmorItem.Type.HELMET, 7);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, ()-> Ingredient.ofItems(ModBlocks.SILVER_BLOCK),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BlocopolisMod.MOD_ID, "silver"))), 4f, 0.15f));

public static final RegistryEntry<ArmorMaterial> TRAVEL_ARMOR_MATERIAL = registerArmorMaterial("travel",
            ()-> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BODY, 5);
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE,6);
                map.put(ArmorItem.Type.HELMET, 2);
            }), 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, ()-> Ingredient.ofItems(ModItems.LEAD_INGOT),
                    List.of(new ArmorMaterial.Layer(Identifier.of(BlocopolisMod.MOD_ID, "travel"))), 0f, 0.0f));


    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material){
        return Registry.registerReference(Registries.ARMOR_MATERIAL, Identifier.of(BlocopolisMod.MOD_ID, name), material.get());
    }

}
