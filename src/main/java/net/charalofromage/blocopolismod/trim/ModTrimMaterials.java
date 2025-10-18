package net.charalofromage.blocopolismod.trim;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> SILVER = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(BlocopolisMod.MOD_ID, "silver"));
    public static final RegistryKey<ArmorTrimMaterial> LEAD = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(BlocopolisMod.MOD_ID, "lead"));
    public static final RegistryKey<ArmorTrimMaterial> BRONZE = RegistryKey.of(RegistryKeys.TRIM_MATERIAL, Identifier.of(BlocopolisMod.MOD_ID, "bronze"));


    public static void boostrap(Registerable<ArmorTrimMaterial> registerable){
        register(registerable, SILVER, Registries.ITEM.getEntry(ModItems.SILVER_INGOT), Style.EMPTY.withColor(TextColor.parse("#C0C0C0").getOrThrow()), 0.1f);
        register(registerable, LEAD, Registries.ITEM.getEntry(ModItems.LEAD_INGOT), Style.EMPTY.withColor(TextColor.parse("#6A7F8C").getOrThrow()), 0.9f);
        register(registerable, BRONZE, Registries.ITEM.getEntry(ModItems.BRONZE_INGOT), Style.EMPTY.withColor(TextColor.parse("#Cd7f32").getOrThrow()), 0.5f);
    }

    private static void register(Registerable<ArmorTrimMaterial> registerable, RegistryKey<ArmorTrimMaterial> armorTrimKey, RegistryEntry<Item> item, Style style, float itemModelIndex){
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(armorTrimKey.getValue().getPath(), item, itemModelIndex, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", armorTrimKey.getValue())).fillStyle(style));

        registerable.register(armorTrimKey, trimMaterial);
    }
}
