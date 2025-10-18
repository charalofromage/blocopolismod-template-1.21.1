package net.charalofromage.blocopolismod.trim;

import com.ibm.icu.impl.locale.BaseLocale;
import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimPattern;
import net.minecraft.registry.*;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

public class ModTrimsPatterns {
    public static final RegistryKey<ArmorTrimPattern> CHARALO = RegistryKey.of(RegistryKeys.TRIM_PATTERN, Identifier.of(BlocopolisMod.MOD_ID, "charalo"));

    public static void bootstrap(Registerable<ArmorTrimPattern> context){
        register(context, ModItems.NEW_TEMPLATE, CHARALO);
    }
    private static void register(Registerable<ArmorTrimPattern> context, Item item, RegistryKey<ArmorTrimPattern> key){
        ArmorTrimPattern trimPattern = new ArmorTrimPattern(key.getValue(), Registries.ITEM.getEntry(item), Text.translatable(Util.createTranslationKey("trim_pattern", key.getValue())), false);
        context.register(key, trimPattern);
    }
}
