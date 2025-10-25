package net.charalofromage.blocopolismod.item;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.entity.ModEntities;
import net.charalofromage.blocopolismod.item.custom.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RAW_SILVER = registerItem("raw_silver", new Item(new Item.Settings()));
    public static final Item PLUME_DE_PAN = registerItem("plume_de_pan", new Item(new Item.Settings()));
    public static final Item SILVER_INGOT = registerItem("silver_ingot", new Item(new Item.Settings()));
    public static final Item RAW_BRONZE = registerItem("raw_bronze", new Item(new Item.Settings()));
    public static final Item BRONZE_INGOT = registerItem("bronze_ingot", new Item(new Item.Settings()));
    public static final Item RAW_LEAD = registerItem("raw_lead", new Item(new Item.Settings()));
    public static final Item LEAD_INGOT = registerItem("lead_ingot", new Item(new Item.Settings()));
    public static final Item SNAKE_SKIN = registerItem("snake_skin", new Item(new Item.Settings()));
    public static final Item OWL_EYES = registerItem("owl_eyes", new Item(new Item.Settings()));
    public static final Item RANDOM_SPAWNER = registerItem("random_spawner", new RandomSpawnerItem(new Item.Settings().maxCount(1)));
    public static final Item LEAD_BACKPACK = registerItem("lead_backpack", new Item(new Item.Settings()));
    public static final Item SILVER_BACKPACK = registerItem("silver_backpack", new Item(new Item.Settings()));
    public static final Item BRONZE_BACKPACK = registerItem("bronze_backpack", new Item(new Item.Settings()));
    public static final Item LANCE   = registerItem("lance", new Item(new Item.Settings()));
    public static final Item LEAD_STICK = registerItem("lead_stick", new Item(new Item.Settings()));
    public static final Item SILVER_STICK = registerItem("silver_stick", new Item(new Item.Settings()));
    public static final Item BRONZE_STICK = registerItem("bronze_stick", new Item(new Item.Settings()));
    public static final Item BLOCOPOLIS = registerItem("blocopolis", new Item(new Item.Settings()));
    public static final Item SILVER_NUGGET = registerItem("silver_nugget", new Item(new Item.Settings()));
    public static final Item BRONZE_NUGGET = registerItem("bronze_nugget", new Item(new Item.Settings()));
    public static final Item LEAD_NUGGET = registerItem("lead_nugget", new Item(new Item.Settings()));
    public static final Item POSEIDON_STICK = registerItem("poseidon_stick", new Item(new Item.Settings()));
    public static final Item LIGHTNING_FRAGMENT = registerItem("lightning_fragment", new Item(new Item.Settings()));
    public static final Item HERMES_SHOE = registerItem("hermes_shoe", new Item(new Item.Settings()));

    public static final Item APHRODITE_SHELL = registerItem("aphrodite_shell", new Item(new Item.Settings()));
    public static final Item APHRODITE_SHELLS = registerItem("aphrodite_shells", new AphroditeShells(new Item.Settings().maxDamage(8).maxCount(1)));
    public static final Item SPAWNER_SPEED_UPGRADE = registerItem("spawner_speed_upgrade", new Spawner_upgrade(new Item.Settings()));
    public static final Item SPAWNER_CREEPER_UPGRADE = registerItem("spawner_creeper_upgrade", new Item(new Item.Settings()));
    public static final Item COIN_PATTERN = registerItem("coin_pattern", new Item(new Item.Settings()));
    public static final Item SILVER_COIN = registerItem("silver_coin", new Item(new Item.Settings().maxCount(99)));
    public static final Item SILVER_COIN_100 = registerItem("silver_coin_100", new Item(new Item.Settings().maxCount(99)));
    public static final Item SILVER_COIN_10_000 = registerItem("silver_coin_10_000", new Item(new Item.Settings().maxCount(99)));
    public static final Item SILVER_COIN_1_000_000 = registerItem("silver_coin_1_000_000", new Item(new Item.Settings().maxCount(99)));
    public static final Item BRONZE_COIN = registerItem("bronze_coin", new Item(new Item.Settings().maxCount(99)));
    public static final Item BRONZE_COIN_100 = registerItem("bronze_coin_100", new Item(new Item.Settings().maxCount(99)));
    public static final Item BRONZE_COIN_10_000 = registerItem("bronze_coin_10_000", new Item(new Item.Settings().maxCount(99)));
    public static final Item BRONZE_COIN_1_000_000 = registerItem("bronze_coin_1_000_000", new Item(new Item.Settings().maxCount(99)));
    public static final Item INGOT_PATTERN = registerItem("ingot_pattern", new Item(new Item.Settings()));
    public static final Item AXE_PATTERN = registerItem("axe_pattern", new Item(new Item.Settings()));
    public static final Item PICKAXE_PATTERN = registerItem("pickaxe_pattern", new Item(new Item.Settings()));
    public static final Item HOE_PATTERN = registerItem("hoe_pattern", new Item(new Item.Settings()));
    public static final Item SWORD_PATTERN = registerItem("sword_pattern", new Item(new Item.Settings()));
    public static final Item SHOVEL_PATTERN = registerItem("shovel_pattern", new Item(new Item.Settings()));
    public static final Item CHESTPLATE_PATTERN = registerItem("chestplate_pattern", new Item(new Item.Settings()));
    public static final Item HELMET_PATTERN = registerItem("helmet_pattern", new Item(new Item.Settings()));
    public static final Item LEGGINGS_PATTERN = registerItem("leggings_pattern", new Item(new Item.Settings()));
    public static final Item BOOTS_PATTERN = registerItem("boots_pattern", new Item(new Item.Settings()));

    public static final Item SILVER_AXE_HEAD = registerItem("silver_axe_head", new Item(new Item.Settings()));
    public static final Item SILVER_PICKAXE_HEAD = registerItem("silver_pickaxe_head", new Item(new Item.Settings()));
    public static final Item SILVER_HOE_HEAD = registerItem("silver_hoe_head", new Item(new Item.Settings()));
    public static final Item SILVER_SWORD_HEAD = registerItem("silver_sword_head", new Item(new Item.Settings()));
    public static final Item SILVER_SHOVEL_HEAD = registerItem("silver_shovel_head", new Item(new Item.Settings()));

    public static final Item BRONZE_AXE_HEAD = registerItem("bronze_axe_head", new Item(new Item.Settings()));
    public static final Item BRONZE_PICKAXE_HEAD = registerItem("bronze_pickaxe_head", new Item(new Item.Settings()));
    public static final Item BRONZE_HOE_HEAD = registerItem("bronze_hoe_head", new Item(new Item.Settings()));
    public static final Item BRONZE_SWORD_HEAD = registerItem("bronze_sword_head", new Item(new Item.Settings()));
    public static final Item BRONZE_SHOVEL_HEAD = registerItem("bronze_shovel_head", new Item(new Item.Settings()));


    public static final Item POSEIDON_WEAPON = registerItem("poseidon_weapon",
            new PoseidonItem(new Item.Settings().maxDamage(256).maxCount(1)
                    .attributeModifiers(PoseidonItem.createAttributeModifiers(5, -3f))));


    public static final Item HADES_WEAPON = registerItem("hades_weapon",
            new HadesItem(
                    new Item.Settings()
                            .maxDamage(3)
                            .maxCount(1)
                            .attributeModifiers(HadesItem.createAttributeModifiers(5, -3f))
                    , true));

    public static final Item ZEUS_LIGHTNING = registerItem("zeus_lightning",
            new ZeusItem(new Item.Settings().maxCount(1).maxDamage(2048)
                    .attributeModifiers(ZeusItem.createAttributeModifiers(14, -3f))));



public static final Item PIECE_OF_BLADE_OF_HADES = registerItem("piece_of_blade_of_hades",
            new HadesItem(new Item.Settings().maxCount(64).
                    attributeModifiers(HadesItem.createAttributeModifiers(0, 0)), false));

    public static final Item BRONZE_SWORD =registerItem("bronze_sword", new SwordItem(ModToolMaterials.BRONZE,
        new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.BRONZE, 7, -2.4F))));


    public static final Item BRONZE_PICKAXE =registerItem("bronze_pickaxe", new PickaxeItem(ModToolMaterials.BRONZE,
        new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 4f, -2.8F))));
    public static final Item BRONZE_HOE =registerItem("bronze_hoe", new HoeItem(ModToolMaterials.BRONZE,
        new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 0f, -0.0F))));
    public static final Item BRONZE_SHOVEL =registerItem("bronze_shovel", new ShovelItem(ModToolMaterials.BRONZE,
        new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.BRONZE, 4.5f, -3.0F))));
    public static final Item BRONZE_AXE =registerItem("bronze_axe", new AxeItem(ModToolMaterials.BRONZE,
        new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.BRONZE, 9f, -3.0F))));

    public static final Item LEAD_SWORD =registerItem("lead_sword", new SwordItem(ModToolMaterials.LEAD,
        new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.LEAD, 7, -2.4F))));
    public static final Item LEAD_PICKAXE =registerItem("lead_pickaxe", new PickaxeItem(ModToolMaterials.LEAD,
        new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.LEAD, 4f, -2.8F))));
    public static final Item LEAD_HOE =registerItem("lead_hoe", new HoeItem(ModToolMaterials.LEAD,
        new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.LEAD, 0f, -0.0F))));
    public static final Item LEAD_SHOVEL =registerItem("lead_shovel", new ShovelItem(ModToolMaterials.LEAD,
        new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.LEAD, 4.5f, -3.0F))));
    public static final Item LEAD_AXE =registerItem("lead_axe", new AxeItem(ModToolMaterials.LEAD,
        new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.LEAD, 9f, -3.0F))));

    public static final Item SILVER_SWORD =registerItem("silver_sword", new SwordItem(ModToolMaterials.SILVER,
        new Item.Settings().attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.SILVER, 7, -2.4F))));
    public static final Item SILVER_PICKAXE =registerItem("silver_pickaxe", new PickaxeItem(ModToolMaterials.SILVER,
        new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.SILVER, 4f, -2.8F))));
    public static final Item SILVER_HOE =registerItem("silver_hoe", new HoeItem(ModToolMaterials.SILVER,
        new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.SILVER, 0f, -0.0F))));
    public static final Item SILVER_SHOVEL =registerItem("silver_shovel", new ShovelItem(ModToolMaterials.SILVER,
        new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.SILVER, 4.5f, -3.0F))));
    public static final Item SILVER_AXE =registerItem("silver_axe", new AxeItem(ModToolMaterials.SILVER,
        new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.SILVER, 9f, -3.0F))));

public static final Item BRONZE_HELMET = registerItem("bronze_helmet",
        new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(45))
        ));
public static final Item BRONZE_LEGGINGS = registerItem("bronze_leggings",
        new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(45))
        ));
public static final Item BRONZE_BOOTS = registerItem("bronze_boots",
        new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(45))
        ));
public static final Item BRONZE_CHESTPLATE = registerItem("bronze_chestplate",
        new ArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(45))
        ));
public static final Item LEAD_HELMET = registerItem("lead_helmet",
        new ModArmorItem(ModArmorMaterials.LEAD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(60))
        ));
public static final Item LEAD_LEGGINGS = registerItem("lead_leggings",
        new ModArmorItem(ModArmorMaterials.LEAD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(60))
        ));
public static final Item LEAD_BOOTS = registerItem("lead_boots",
        new ModArmorItem(ModArmorMaterials.LEAD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(60))
        ));
public static final Item LEAD_CHESTPLATE = registerItem("lead_chestplate",
        new ModArmorItem(ModArmorMaterials.LEAD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(60))
        ));
public static final Item SILVER_HELMET = registerItem("silver_helmet",
        new ModArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(80))
        ));
public static final Item SILVER_LEGGINGS = registerItem("silver_leggings",
        new ModArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(80))
        ));
public static final Item SILVER_BOOTS = registerItem("silver_boots",
        new ModArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(80))
        ));
public static final Item SILVER_CHESTPLATE = registerItem("silver_chestplate",
        new ModArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(80))
        ));
public static final Item TRAVEL_HELMET = registerItem("travel_helmet",
        new ModArmorItem(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))
        ));
public static final Item TRAVEL_LEGGINGS = registerItem("travel_leggings",
        new ModArmorItem(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))
        ));
public static final Item TRAVEL_BOOTS = registerItem("travel_boots",
        new ModArmorItem(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))
        ));
public static final Item TRAVEL_CHESTPLATE = registerItem("travel_chestplate",
        new ModArmorItem(ModArmorMaterials.TRAVEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))
        ));


public static final Item SILVER_HORSE_ARMOR = registerItem("silver_horse_armor",
        new AnimalArmorItem(ModArmorMaterials.SILVER_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
public static final Item BRONZE_HORSE_ARMOR = registerItem("bronze_horse_armor",
        new AnimalArmorItem(ModArmorMaterials.BRONZE_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));
public static final Item LEAD_HORSE_ARMOR = registerItem("lead_horse_armor",
        new AnimalArmorItem(ModArmorMaterials.LEAD_ARMOR_MATERIAL, AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));


public static final Item NEW_TEMPLATE = registerItem("new_armor_trim_template",
        SmithingTemplateItem.of(Identifier.of(BlocopolisMod.MOD_ID, "charalo"), FeatureFlags.VANILLA));

public static final Item HERMES_SHOOES = registerItem("hermes_shooes", new HermesBoot(ModArmorMaterials.LEAD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().maxDamage(1024)));

public static final Item SNAKE_SPAWN_EGG = registerItem("snake_spawn_egg",
        new SpawnEggItem(ModEntities.SNAKE, 0x607D3B, 0xEEDC82, new Item.Settings()));





    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BlocopolisMod.MOD_ID, name), item);
    }

public static void registerModItems() {
    BlocopolisMod.LOGGER.info("Registering Mod Items for" + BlocopolisMod.MOD_ID);
}
}