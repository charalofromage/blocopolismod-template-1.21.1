package net.charalofromage.blocopolismod.datagen;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.item.ModItems;
import net.charalofromage.blocopolismod.item.custom.HermesBoot;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_BRONZE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_LEAD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SILVER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_LEAD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_SILVER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LEAD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHICKEN_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURTLE_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COW_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WITCH_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPIDER_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERMAN_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SQUID_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PIG_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RABBIT_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZOMBIE_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKELETON_SPAWNER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHEEP_SPAWNER);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHICKEN_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TURTLE_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.COW_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WITCH_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SPIDER_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ENDERMAN_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SQUID_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PIG_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RABBIT_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZOMBIE_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SKELETON_SPAWNERUP);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SHEEP_SPAWNERUP);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.AUTOKILLERSPAWNER);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MONEY_GENERATOR);

        BlockStateModelGenerator.BlockTexturePool silverPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SILVER_BLOCK);

        silverPool.stairs(ModBlocks.SILVER_STAIRS);
        silverPool.slab(ModBlocks.SILVER_SLAB);
        silverPool.wall(ModBlocks.SILVER_WALL);
        silverPool.fence(ModBlocks.SILVER_FENCE);
        silverPool.fenceGate(ModBlocks.SILVER_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.SILVER_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.SILVER_TRAPDOOR);

        BlockStateModelGenerator.BlockTexturePool bronzePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BRONZE_BLOCK);

        bronzePool.stairs(ModBlocks.BRONZE_STAIRS);
        bronzePool.slab(ModBlocks.BRONZE_SLAB);
        bronzePool.wall(ModBlocks.BRONZE_WALL);
        bronzePool.fence(ModBlocks.BRONZE_FENCE);
        bronzePool.fenceGate(ModBlocks.BRONZE_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.BRONZE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.BRONZE_TRAPDOOR);



        BlockStateModelGenerator.BlockTexturePool leadPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LEAD_BLOCK);

        leadPool.stairs(ModBlocks.LEAD_STAIRS);
        leadPool.slab(ModBlocks.LEAD_SLAB);
        leadPool.wall(ModBlocks.LEAD_WALL);
        leadPool.fence(ModBlocks.LEAD_FENCE);
        leadPool.fenceGate(ModBlocks.LEAD_FENCE_GATE);

        blockStateModelGenerator.registerDoor(ModBlocks.LEAD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.LEAD_TRAPDOOR);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_LEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOCOPOLIS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.APHRODITE_SHELL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_BACKPACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.HERMES_SHOE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_BACKPACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.LIGHTNING_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModItems.OWL_EYES, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIECE_OF_BLADE_OF_HADES, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLUME_DE_PAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.POSEIDON_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.POSEIDON_WEAPON, Models.GENERATED);
        itemModelGenerator.register(ModItems.HADES_WEAPON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNAKE_SKIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_BACKPACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_SILVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BRONZE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RANDOM_SPAWNER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEAD_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_HORSE_ARMOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.NEW_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.APHRODITE_SHELLS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPAWNER_SPEED_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPAWNER_CREEPER_UPGRADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COIN_PATTERN, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_PATTERN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_COIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILVER_COIN, Models.GENERATED);

        itemModelGenerator.register(ModItems.SILVER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.SILVER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LEAD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ZEUS_LIGHTNING, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.BRONZE_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LEAD_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LEAD_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LEAD_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.LEAD_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SILVER_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TRAVEL_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TRAVEL_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TRAVEL_BOOTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.TRAVEL_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.HERMES_SHOOES));


        itemModelGenerator.register(ModItems.SNAKE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));


    }
}
