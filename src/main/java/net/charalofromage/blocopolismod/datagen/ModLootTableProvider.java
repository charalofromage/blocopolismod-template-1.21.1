package net.charalofromage.blocopolismod.datagen;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BRONZE_BLOCK);
        addDrop(ModBlocks.SILVER_BLOCK);
        addDrop(ModBlocks.LEAD_BLOCK);
        addDrop(ModBlocks.RAW_BRONZE_BLOCK);
        addDrop(ModBlocks.RAW_LEAD_BLOCK);
        addDrop(ModBlocks.RAW_SILVER_BLOCK);
        addDrop(ModBlocks.BRONZE_CHEST);
        addDrop(ModBlocks.LEAD_CHEST);
        addDrop(ModBlocks.SILVER_CHEST);
        addDrop(ModBlocks.SILVER_DOOR, doorDrops(ModBlocks.SILVER_DOOR));
        addDrop(ModBlocks.SILVER_FENCE);
        addDrop(ModBlocks.SILVER_FENCE_GATE);
        addDrop(ModBlocks.SILVER_SLAB, slabDrops(ModBlocks.SILVER_SLAB));
        addDrop(ModBlocks.SILVER_STAIRS);
        addDrop(ModBlocks.SILVER_TRAPDOOR);
        addDrop(ModBlocks.SILVER_WALL);
        addDrop(ModBlocks.BRONZE_DOOR, doorDrops(ModBlocks.BRONZE_DOOR));
        addDrop(ModBlocks.BRONZE_FENCE);
        addDrop(ModBlocks.BRONZE_FENCE_GATE);
        addDrop(ModBlocks.BRONZE_SLAB, slabDrops(ModBlocks.BRONZE_SLAB));
        addDrop(ModBlocks.BRONZE_STAIRS);
        addDrop(ModBlocks.BRONZE_TRAPDOOR);
        addDrop(ModBlocks.BRONZE_WALL);
        addDrop(ModBlocks.LEAD_DOOR, doorDrops(ModBlocks.LEAD_DOOR));
        addDrop(ModBlocks.LEAD_FENCE);
        addDrop(ModBlocks.LEAD_FENCE_GATE);
        addDrop(ModBlocks.LEAD_SLAB, slabDrops(ModBlocks.LEAD_SLAB));
        addDrop(ModBlocks.LEAD_STAIRS);
        addDrop(ModBlocks.LEAD_TRAPDOOR);
        addDrop(ModBlocks.LEAD_WALL);
        addDrop(ModBlocks.CHICKEN_SPAWNER);
        addDrop(ModBlocks.TURTLE_SPAWNER);
        addDrop(ModBlocks.COW_SPAWNER);
        addDrop(ModBlocks.SHEEP_SPAWNER);
        addDrop(ModBlocks.SQUID_SPAWNER);
        addDrop(ModBlocks.RABBIT_SPAWNER);
        addDrop(ModBlocks.ZOMBIE_SPAWNER);
        addDrop(ModBlocks.AUTOKILLERSPAWNER);
        addDrop(ModBlocks.SKELETON_SPAWNER);
        addDrop(ModBlocks.WITCH_SPAWNER);
        addDrop(ModBlocks.ENDERMAN_SPAWNER);
        addDrop(ModBlocks.SPIDER_SPAWNER);
        addDrop(ModBlocks.PIG_SPAWNER);
        addDrop(ModBlocks.DEEPSLATE_LEAD_ORE, oreDrops(ModBlocks.DEEPSLATE_LEAD_ORE, ModItems.RAW_LEAD));
        addDrop(ModBlocks.DEEPSLATE_BRONZE_ORE, oreDrops(ModBlocks.DEEPSLATE_BRONZE_ORE, ModItems.RAW_BRONZE));
        addDrop(ModBlocks.LEAD_ORE, oreDrops(ModBlocks.LEAD_ORE, ModItems.RAW_LEAD));
        addDrop(ModBlocks.BRONZE_ORE, oreDrops(ModBlocks.BRONZE_ORE, ModItems.RAW_BRONZE));

        addDrop(ModBlocks.DEEPSLATE_SILVER_ORE, drops(ModBlocks.DEEPSLATE_SILVER_ORE, ModItems.RAW_SILVER));
        addDrop(ModBlocks.SILVER_ORE, drops(ModBlocks.SILVER_ORE, ModItems.RAW_SILVER));

        addDrop(ModBlocks.CHICKEN_SPAWNERUP, drops(ModBlocks.CHICKEN_SPAWNER));
        addDrop(ModBlocks.TURTLE_SPAWNERUP, drops(ModBlocks.TURTLE_SPAWNER));
        addDrop(ModBlocks.COW_SPAWNERUP, drops(ModBlocks.COW_SPAWNER));
        addDrop(ModBlocks.SHEEP_SPAWNERUP, drops(ModBlocks.SHEEP_SPAWNER));
        addDrop(ModBlocks.SQUID_SPAWNERUP, drops(ModBlocks.SQUID_SPAWNER));
        addDrop(ModBlocks.RABBIT_SPAWNERUP, drops(ModBlocks.RABBIT_SPAWNER));
        addDrop(ModBlocks.ZOMBIE_SPAWNERUP, drops(ModBlocks.ZOMBIE_SPAWNER));
        addDrop(ModBlocks.SKELETON_SPAWNERUP, drops(ModBlocks.SKELETON_SPAWNER));
        addDrop(ModBlocks.WITCH_SPAWNERUP, drops(ModBlocks.WITCH_SPAWNER));
        addDrop(ModBlocks.CREEPER_SPAWNER, drops(ModBlocks.WITCH_SPAWNER));
        addDrop(ModBlocks.ENDERMAN_SPAWNERUP, drops(ModBlocks.ENDERMAN_SPAWNER));
        addDrop(ModBlocks.SPIDER_SPAWNERUP, drops(ModBlocks.SPIDER_SPAWNER));
        addDrop(ModBlocks.PIG_SPAWNERUP, drops(ModBlocks.PIG_SPAWNER));


    }


}



