package net.charalofromage.blocopolismod.item;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
public static final ItemGroup BLOCOPOLIS_ITEMS = Registry.register(Registries.ITEM_GROUP,
        Identifier.of(BlocopolisMod.MOD_ID, "blocopolis_items"),
        FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.BLOCOPOLIS))
                .displayName(Text.translatable("itemgroup.blocopolismod.blocopolis_items"))
                .entries((displayContext, entries) -> {
                    entries.add(ModItems.SILVER_INGOT);;
                    entries.add(ModItems.SILVER_NUGGET);
                    entries.add(ModItems.SILVER_STICK);
                    entries.add(ModItems.RAW_SILVER);
                    entries.add(ModItems.SILVER_AXE);
                    entries.add(ModItems.SILVER_PICKAXE);
                    entries.add(ModItems.SILVER_HOE);
                    entries.add(ModItems.SILVER_SHOVEL);
                    entries.add(ModItems.SILVER_SWORD);
                    entries.add(ModItems.SILVER_HELMET);
                    entries.add(ModItems.SILVER_CHESTPLATE);
                    entries.add(ModItems.SILVER_LEGGINGS);
                    entries.add(ModItems.SILVER_BOOTS);
                    entries.add(ModItems.SILVER_HORSE_ARMOR);

                    entries.add(ModBlocks.SILVER_ORE);
                    entries.add(ModBlocks.DEEPSLATE_SILVER_ORE);
                    entries.add(ModBlocks.RAW_SILVER_BLOCK);
                    entries.add(ModBlocks.SILVER_BLOCK);
                    entries.add(ModBlocks.SILVER_DOOR);
                    entries.add(ModBlocks.SILVER_FENCE);
                    entries.add(ModBlocks.SILVER_FENCE_GATE);
                    entries.add(ModBlocks.SILVER_SLAB);
                    entries.add(ModBlocks.SILVER_STAIRS);
                    entries.add(ModBlocks.SILVER_TRAPDOOR);
                    entries.add(ModBlocks.SILVER_WALL);


                    entries.add(ModItems.LEAD_INGOT);
                    entries.add(ModItems.LEAD_NUGGET);
                    entries.add(ModItems.LEAD_STICK);
                    entries.add(ModItems.RAW_LEAD);
                    entries.add(ModItems.LEAD_AXE);
                    entries.add(ModItems.LEAD_PICKAXE);
                    entries.add(ModItems.LEAD_HOE);
                    entries.add(ModItems.LEAD_SHOVEL);
                    entries.add(ModItems.LEAD_SWORD);
                    entries.add(ModItems.LEAD_HELMET);
                    entries.add(ModItems.LEAD_CHESTPLATE);
                    entries.add(ModItems.LEAD_LEGGINGS);
                    entries.add(ModItems.LEAD_BOOTS);
                    entries.add(ModItems.LEAD_HORSE_ARMOR);

                    entries.add(ModBlocks.LEAD_ORE);
                    entries.add(ModBlocks.DEEPSLATE_LEAD_ORE);
                    entries.add(ModBlocks.RAW_LEAD_BLOCK);
                    entries.add(ModBlocks.LEAD_BLOCK);
                    entries.add(ModBlocks.LEAD_DOOR);
                    entries.add(ModBlocks.LEAD_FENCE);
                    entries.add(ModBlocks.LEAD_FENCE_GATE);
                    entries.add(ModBlocks.LEAD_SLAB);
                    entries.add(ModBlocks.LEAD_STAIRS);
                    entries.add(ModBlocks.LEAD_TRAPDOOR);
                    entries.add(ModBlocks.LEAD_WALL);


                    entries.add(ModItems.BRONZE_INGOT);
                    entries.add(ModItems.BRONZE_NUGGET);
                    entries.add(ModItems.BRONZE_STICK);
                    entries.add(ModItems.RAW_BRONZE);
                    entries.add(ModItems.BRONZE_AXE);
                    entries.add(ModItems.BRONZE_PICKAXE);
                    entries.add(ModItems.BRONZE_HOE);
                    entries.add(ModItems.BRONZE_SHOVEL);
                    entries.add(ModItems.BRONZE_SWORD);
                    entries.add(ModItems.BRONZE_HELMET);
                    entries.add(ModItems.BRONZE_CHESTPLATE);
                    entries.add(ModItems.BRONZE_LEGGINGS);
                    entries.add(ModItems.BRONZE_BOOTS);
                    entries.add(ModItems.BRONZE_HORSE_ARMOR);

                    entries.add(ModBlocks.BRONZE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_BRONZE_ORE);
                    entries.add(ModBlocks.RAW_BRONZE_BLOCK);
                    entries.add(ModBlocks.BRONZE_BLOCK);
                    entries.add(ModBlocks.BRONZE_DOOR);
                    entries.add(ModBlocks.BRONZE_FENCE);
                    entries.add(ModBlocks.BRONZE_FENCE_GATE);
                    entries.add(ModBlocks.BRONZE_SLAB);
                    entries.add(ModBlocks.BRONZE_STAIRS);
                    entries.add(ModBlocks.BRONZE_TRAPDOOR);
                    entries.add(ModBlocks.BRONZE_WALL);
                    
                    entries.add(ModItems.BRONZE_BACKPACK);
                    entries.add(ModItems.SILVER_BACKPACK);
                    entries.add(ModItems.LEAD_BACKPACK);

                    entries.add(ModItems.RANDOM_SPAWNER);

                    entries.add(ModItems.PLUME_DE_PAN);
                    entries.add(ModItems.SNAKE_SKIN);
                    entries.add(ModItems.OWL_EYES);
                    entries.add(ModItems.HERMES_SHOOES);
                    entries.add(ModItems.SPAWNER_SPEED_UPGRADE);

                    entries.add(ModItems.POSEIDON_STICK);
                    entries.add(ModItems.LIGHTNING_FRAGMENT);
                    entries.add(ModItems.PIECE_OF_BLADE_OF_HADES);
                    entries.add(ModItems.APHRODITE_SHELL);
                    entries.add(ModItems.HERMES_SHOE);

                    entries.add(ModItems.POSEIDON_WEAPON);
                    entries.add(ModItems.HADES_WEAPON);

                    entries.add(ModItems.LANCE);
                    entries.add(ModItems.ZEUS_LIGHTNING);

                    entries.add(ModItems.TRAVEL_HELMET);
                    entries.add(ModItems.TRAVEL_CHESTPLATE);
                    entries.add(ModItems.TRAVEL_LEGGINGS);
                    entries.add(ModItems.TRAVEL_BOOTS);

                    entries.add(ModItems.APHRODITE_SHELLS);

                    entries.add(ModBlocks.SILVER_CHEST);
                    entries.add(ModBlocks.BRONZE_CHEST);
                    entries.add(ModBlocks.LEAD_CHEST);



                    entries.add(ModBlocks.CHICKEN_SPAWNER);
                    entries.add(ModBlocks.ZOMBIE_SPAWNER);
                    entries.add(ModBlocks.PIG_SPAWNER);
                    entries.add(ModBlocks.SPIDER_SPAWNER);
                    entries.add(ModBlocks.SKELETON_SPAWNER);
                    entries.add(ModBlocks.COW_SPAWNER);
                    entries.add(ModBlocks.TURTLE_SPAWNER);
                    entries.add(ModBlocks.ENDERMAN_SPAWNER);
                    entries.add(ModBlocks.SHEEP_SPAWNER);
                    entries.add(ModBlocks.SQUID_SPAWNER);
                    entries.add(ModBlocks.RABBIT_SPAWNER);
                    entries.add(ModBlocks.WITCH_SPAWNER);

                    entries.add(ModItems.SNAKE_SPAWN_EGG);
                })
                .build());

    public static void registerItemGroups(){
        BlocopolisMod.LOGGER.info("Registring Item Groups for "+ BlocopolisMod.MOD_ID);
    }
}
