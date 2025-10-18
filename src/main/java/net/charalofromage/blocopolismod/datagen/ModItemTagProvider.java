package net.charalofromage.blocopolismod.datagen;

import net.charalofromage.blocopolismod.item.ModItems;
import net.charalofromage.blocopolismod.item.custom.ZeusItem;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
getOrCreateTagBuilder(ItemTags.SWORDS)
        .add(ModItems.SILVER_SWORD)
        .add(ModItems.BRONZE_SWORD)
        .add(ModItems.LEAD_SWORD)
        .add(ModItems.ZEUS_LIGHTNING);

getOrCreateTagBuilder(ItemTags.SHOVELS)
        .add(ModItems.SILVER_SHOVEL)
        .add(ModItems.BRONZE_SHOVEL)
        .add(ModItems.LEAD_SHOVEL);

getOrCreateTagBuilder(ItemTags.PICKAXES)
        .add(ModItems.BRONZE_PICKAXE)
        .add(ModItems.SILVER_PICKAXE)
        .add(ModItems.LEAD_PICKAXE);

getOrCreateTagBuilder(ItemTags.HOES)
        .add(ModItems.BRONZE_HOE)
        .add(ModItems.LEAD_HOE)
        .add(ModItems.SILVER_HOE);

getOrCreateTagBuilder(ItemTags.AXES)
        .add(ModItems.BRONZE_AXE)
        .add(ModItems.LEAD_AXE)
        .add(ModItems.SILVER_AXE);

getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)
        .add(ModItems.POSEIDON_WEAPON)
        .add(ModItems.BRONZE_HELMET)
        .add(ModItems.BRONZE_CHESTPLATE)
        .add(ModItems.BRONZE_LEGGINGS)
        .add(ModItems.BRONZE_BOOTS)
        .add(ModItems.LEAD_HELMET)
        .add(ModItems.LEAD_CHESTPLATE)
        .add(ModItems.LEAD_LEGGINGS)
        .add(ModItems.LEAD_BOOTS)
        .add(ModItems.SILVER_HELMET)
        .add(ModItems.SILVER_CHESTPLATE)
        .add(ModItems.SILVER_LEGGINGS)
        .add(ModItems.TRAVEL_HELMET)
        .add(ModItems.TRAVEL_CHESTPLATE)
        .add(ModItems.TRAVEL_LEGGINGS)
        .add(ModItems.TRAVEL_BOOTS)
        .add(ModItems.SILVER_BOOTS)
        .add(ModItems.HERMES_SHOOES);

getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
        .add(ModItems.BRONZE_HELMET)
        .add(ModItems.BRONZE_CHESTPLATE)
        .add(ModItems.BRONZE_LEGGINGS)
        .add(ModItems.BRONZE_BOOTS)
        .add(ModItems.LEAD_HELMET)
        .add(ModItems.LEAD_CHESTPLATE)
        .add(ModItems.LEAD_LEGGINGS)
        .add(ModItems.LEAD_BOOTS)
        .add(ModItems.SILVER_HELMET)
        .add(ModItems.SILVER_CHESTPLATE)
        .add(ModItems.SILVER_LEGGINGS)
        .add(ModItems.SILVER_BOOTS)
        .add(ModItems.APHRODITE_SHELLS);

getOrCreateTagBuilder(ItemTags.ARMOR_ENCHANTABLE)
        .add(ModItems.BRONZE_HELMET)
        .add(ModItems.BRONZE_CHESTPLATE)
        .add(ModItems.BRONZE_LEGGINGS)
        .add(ModItems.BRONZE_BOOTS)
        .add(ModItems.LEAD_HELMET)
        .add(ModItems.LEAD_CHESTPLATE)
        .add(ModItems.LEAD_LEGGINGS)
        .add(ModItems.LEAD_BOOTS)
        .add(ModItems.TRAVEL_HELMET)
        .add(ModItems.TRAVEL_CHESTPLATE)
        .add(ModItems.TRAVEL_LEGGINGS)
        .add(ModItems.TRAVEL_BOOTS)
        .add(ModItems.SILVER_HELMET)
        .add(ModItems.SILVER_CHESTPLATE)
        .add(ModItems.SILVER_LEGGINGS)
        .add(ModItems.SILVER_BOOTS);

getOrCreateTagBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
        .add(ModItems.BRONZE_BOOTS)
        .add(ModItems.TRAVEL_BOOTS)
        .add(ModItems.LEAD_BOOTS)
        .add(ModItems.SILVER_BOOTS)
        .add(ModItems.HERMES_SHOOES);

getOrCreateTagBuilder(ItemTags.HEAD_ARMOR_ENCHANTABLE)
        .add(ModItems.BRONZE_HELMET)
        .add(ModItems.LEAD_HELMET)
        .add(ModItems.TRAVEL_HELMET)
        .add(ModItems.SILVER_HELMET);

getOrCreateTagBuilder(ItemTags.CHEST_ARMOR_ENCHANTABLE)
        .add(ModItems.BRONZE_CHESTPLATE)
        .add(ModItems.TRAVEL_CHESTPLATE)
        .add(ModItems.LEAD_CHESTPLATE)
        .add(ModItems.SILVER_CHESTPLATE);

getOrCreateTagBuilder(ItemTags.LEG_ARMOR_ENCHANTABLE)
        .add(ModItems.SILVER_LEGGINGS)
        .add(ModItems.LEAD_LEGGINGS)
        .add(ModItems.TRAVEL_LEGGINGS)
        .add(ModItems.BRONZE_LEGGINGS);

getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
        .add(ModItems.SILVER_INGOT)
        .add(ModItems.LEAD_INGOT)
        .add(ModItems.BRONZE_INGOT);

getOrCreateTagBuilder(ItemTags.TRIM_TEMPLATES)
        ;
    }
}

