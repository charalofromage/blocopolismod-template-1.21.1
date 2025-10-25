package net.charalofromage.blocopolismod.datagen;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.BRONZE_CHEST)
                .add(ModBlocks.BRONZE_ORE)
                .add(ModBlocks.LEAD_BLOCK)
                .add(ModBlocks.DEEPSLATE_BRONZE_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE)
                .add(ModBlocks.LEAD_CHEST)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.RAW_BRONZE_BLOCK)
                .add(ModBlocks.RAW_LEAD_BLOCK)
                .add(ModBlocks.RAW_SILVER_BLOCK)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.SILVER_CHEST)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.SILVER_DOOR)
                .add(ModBlocks.SILVER_FENCE)
                .add(ModBlocks.SILVER_FENCE_GATE)
                .add(ModBlocks.SILVER_SLAB)
                .add(ModBlocks.SILVER_STAIRS)
                .add(ModBlocks.SILVER_TRAPDOOR)
                .add(ModBlocks.SILVER_WALL)
                .add(ModBlocks.BRONZE_DOOR)
                .add(ModBlocks.BRONZE_FENCE)
                .add(ModBlocks.BRONZE_FENCE_GATE)
                .add(ModBlocks.BRONZE_SLAB)
                .add(ModBlocks.BRONZE_STAIRS)
                .add(ModBlocks.BRONZE_TRAPDOOR)
                .add(ModBlocks.BRONZE_WALL)
                .add(ModBlocks.CHICKEN_SPAWNER)
                .add(ModBlocks.TURTLE_SPAWNER)
                .add(ModBlocks.COW_SPAWNER)
                .add(ModBlocks.SHEEP_SPAWNER)
                .add(ModBlocks.SQUID_SPAWNER)
                .add(ModBlocks.RABBIT_SPAWNER)
                .add(ModBlocks.ZOMBIE_SPAWNER)
                .add(ModBlocks.SKELETON_SPAWNER)
                .add(ModBlocks.WITCH_SPAWNER)
                .add(ModBlocks.ENDERMAN_SPAWNER)
                .add(ModBlocks.SPIDER_SPAWNER)
                .add(ModBlocks.PIG_SPAWNER)
                .add(ModBlocks.CHICKEN_SPAWNERUP)
                .add(ModBlocks.TURTLE_SPAWNERUP)
                .add(ModBlocks.COW_SPAWNERUP)
                .add(ModBlocks.SHEEP_SPAWNERUP)
                .add(ModBlocks.SQUID_SPAWNERUP)
                .add(ModBlocks.RABBIT_SPAWNERUP)
                .add(ModBlocks.ZOMBIE_SPAWNERUP)
                .add(ModBlocks.SKELETON_SPAWNERUP)
                .add(ModBlocks.WITCH_SPAWNERUP)
                .add(ModBlocks.ENDERMAN_SPAWNERUP)
                .add(ModBlocks.SPIDER_SPAWNERUP)
                .add(ModBlocks.CREEPER_SPAWNER)
                .add(ModBlocks.AUTOKILLERSPAWNER)
                .add(ModBlocks.PIG_SPAWNERUP)
                .add(ModBlocks.MONEY_GENERATOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.SILVER_BLOCK)
                .add(ModBlocks.SILVER_ORE)
                .add(ModBlocks.DEEPSLATE_SILVER_ORE)
                .add(ModBlocks.SILVER_DOOR)
                .add(ModBlocks.SILVER_FENCE)
                .add(ModBlocks.SILVER_FENCE_GATE)
                .add(ModBlocks.SILVER_SLAB)
                .add(ModBlocks.SILVER_STAIRS)
                .add(ModBlocks.SILVER_TRAPDOOR)
                .add(ModBlocks.AUTOKILLERSPAWNER)
                .add(ModBlocks.SILVER_WALL)
                .add(ModBlocks.MONEY_GENERATOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BRONZE_BLOCK)
                .add(ModBlocks.BRONZE_CHEST)
                .add(ModBlocks.BRONZE_ORE)
                .add(ModBlocks.LEAD_BLOCK)
                .add(ModBlocks.DEEPSLATE_BRONZE_ORE)
                .add(ModBlocks.DEEPSLATE_LEAD_ORE)
                .add(ModBlocks.LEAD_CHEST)
                .add(ModBlocks.LEAD_ORE)
                .add(ModBlocks.RAW_BRONZE_BLOCK)
                .add(ModBlocks.RAW_LEAD_BLOCK)
                .add(ModBlocks.BRONZE_DOOR)
                .add(ModBlocks.BRONZE_FENCE)
                .add(ModBlocks.BRONZE_FENCE_GATE)
                .add(ModBlocks.BRONZE_SLAB)
                .add(ModBlocks.BRONZE_STAIRS)
                .add(ModBlocks.BRONZE_TRAPDOOR)
                .add(ModBlocks.BRONZE_WALL)
                .add(ModBlocks.LEAD_DOOR)
                .add(ModBlocks.LEAD_FENCE)
                .add(ModBlocks.LEAD_FENCE_GATE)
                .add(ModBlocks.LEAD_SLAB)
                .add(ModBlocks.LEAD_STAIRS)
                .add(ModBlocks.LEAD_TRAPDOOR)
                .add(ModBlocks.LEAD_WALL);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SILVER_CHEST);

        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModBlocks.SILVER_FENCE)
                .add(ModBlocks.LEAD_FENCE)
                .add(ModBlocks.BRONZE_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.SILVER_FENCE_GATE)
                .add(ModBlocks.LEAD_FENCE_GATE)
                .add(ModBlocks.BRONZE_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.SILVER_WALL)
                .add(ModBlocks.LEAD_WALL)
                .add(ModBlocks.BRONZE_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEED_BRONZE_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEED_LEAD_TOOL)
                .addTag(ModTags.Blocks.NEED_BRONZE_TOOL)
                .add(ModBlocks.CHICKEN_SPAWNER)
                .add(ModBlocks.TURTLE_SPAWNER)
                .add(ModBlocks.COW_SPAWNER)
                .add(ModBlocks.SHEEP_SPAWNER)
                .add(ModBlocks.SQUID_SPAWNER)
                .add(ModBlocks.RABBIT_SPAWNER)
                .add(ModBlocks.ZOMBIE_SPAWNER)
                .add(ModBlocks.SKELETON_SPAWNER)
                .add(ModBlocks.WITCH_SPAWNER)
                .add(ModBlocks.ENDERMAN_SPAWNER)
                .add(ModBlocks.SPIDER_SPAWNER)
                .add(ModBlocks.PIG_SPAWNER)
                .add(ModBlocks.CHICKEN_SPAWNERUP)
                .add(ModBlocks.TURTLE_SPAWNERUP)
                .add(ModBlocks.COW_SPAWNERUP)
                .add(ModBlocks.SHEEP_SPAWNERUP)
                .add(ModBlocks.SQUID_SPAWNERUP)
                .add(ModBlocks.RABBIT_SPAWNERUP)
                .add(ModBlocks.ZOMBIE_SPAWNERUP)
                .add(ModBlocks.SKELETON_SPAWNERUP)
                .add(ModBlocks.WITCH_SPAWNERUP)
                .add(ModBlocks.ENDERMAN_SPAWNERUP)
                .add(ModBlocks.SPIDER_SPAWNERUP)
                .add(ModBlocks.CREEPER_SPAWNER)
                .add(ModBlocks.PIG_SPAWNERUP);

        getOrCreateTagBuilder(ModTags.Blocks.NEED_SILVER_TOOL)
                .addTag(ModTags.Blocks.NEED_LEAD_TOOL);

    }
}
