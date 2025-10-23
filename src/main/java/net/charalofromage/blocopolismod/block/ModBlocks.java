package net.charalofromage.blocopolismod.block;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.custom.*;
import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {
    public static final Block SILVER_ORE = registerBlock("silver_ore",
            new Block(AbstractBlock.Settings.create().requiresTool().sounds(BlockSoundGroup.STONE).strength(4f)));
    public static final Block RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));
    public static final Block LEAD_ORE = registerBlock("lead_ore",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(4f)));
    public static final Block RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));
    public static final Block SILVER_BLOCK = registerBlock("silver_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));
    public static final Block LEAD_BLOCK = registerBlock("lead_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));
    public static final Block BRONZE_ORE = registerBlock("bronze_ore",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(4f)));
    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));
    public static final Block RAW_BRONZE_BLOCK = registerBlock("raw_bronze_block",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));


    public static final Block SILVER_CHEST = registerBlock("silver_chest",
            new ModSilverChest(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(6f)));
    public static final Block LEAD_CHEST = registerBlock("lead_chest",
            new ModLeadChest(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));
    public static final Block BRONZE_CHEST = registerBlock("bronze_chest",
            new ModBronzeChest(AbstractBlock.Settings.create().sounds(BlockSoundGroup.STONE).requiresTool().strength(5f)));

    public static final Block DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(5f)));
    public static final Block DEEPSLATE_BRONZE_ORE = registerBlock("deepslate_bronze_ore",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(5f)));
    public static final Block DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.DEEPSLATE).requiresTool().strength(5f)));

    public static final Block SILVER_STAIRS = registerBlock("silver_stairs",
            new StairsBlock(ModBlocks.SILVER_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(5F).requiresTool()));
    public static final Block SILVER_SLAB = registerBlock("silver_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(5F).requiresTool()));
    public static final Block SILVER_DOOR = registerBlock("silver_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(5F).requiresTool().nonOpaque()));
    public static final Block SILVER_TRAPDOOR = registerBlock("silver_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(5F).requiresTool().nonOpaque()));
    public static final Block SILVER_FENCE = registerBlock("silver_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(5F).requiresTool()));
    public static final Block SILVER_FENCE_GATE = registerBlock("silver_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(5F).requiresTool()));
    public static final Block SILVER_WALL = registerBlock("silver_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(5F).requiresTool()));

    public static final Block BRONZE_STAIRS = registerBlock("bronze_stairs",
            new StairsBlock(ModBlocks.BRONZE_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block BRONZE_SLAB = registerBlock("bronze_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block BRONZE_DOOR = registerBlock("bronze_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4F).requiresTool().nonOpaque()));
    public static final Block BRONZE_TRAPDOOR = registerBlock("bronze_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4F).requiresTool().nonOpaque()));
    public static final Block BRONZE_FENCE = registerBlock("bronze_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block BRONZE_FENCE_GATE = registerBlock("bronze_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block BRONZE_WALL = registerBlock("bronze_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(4F).requiresTool()));

    public static final Block LEAD_STAIRS = registerBlock("lead_stairs",
            new StairsBlock(ModBlocks.LEAD_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block LEAD_SLAB = registerBlock("lead_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block LEAD_DOOR = registerBlock("lead_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4F).requiresTool().nonOpaque()));
    public static final Block LEAD_TRAPDOOR = registerBlock("lead_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4F).requiresTool().nonOpaque()));
    public static final Block LEAD_FENCE = registerBlock("lead_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block LEAD_FENCE_GATE = registerBlock("lead_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().strength(4F).requiresTool()));
    public static final Block LEAD_WALL = registerBlock("lead_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(4F).requiresTool()));







    public static final Block CHICKEN_SPAWNER = registerBlock("chicken_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.CHICKEN, 50));

    public static final Block COW_SPAWNER = registerBlock("cow_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.COW, 50));
    public static final Block SHEEP_SPAWNER = registerBlock("sheep_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SHEEP, 50));
    public static final Block RABBIT_SPAWNER = registerBlock("rabbit_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.RABBIT, 50));
    public static final Block TURTLE_SPAWNER = registerBlock("turtle_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.TURTLE, 50));
    public static final Block ZOMBIE_SPAWNER = registerBlock("zombie_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.ZOMBIE, 50));
    public static final Block SPIDER_SPAWNER = registerBlock("spider_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SPIDER, 50));
    public static final Block WITCH_SPAWNER = registerBlock("witch_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.WITCH, 50));
    public static final Block SQUID_SPAWNER = registerBlock("squid_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SQUID, 50));
    public static final Block SKELETON_SPAWNER = registerBlock("skeleton_spawner",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SKELETON, 50));
    public static final Block ENDERMAN_SPAWNER = registerBlock("enderman_spawner",
            new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.ENDERMAN, 50));
    public static final Block PIG_SPAWNER = registerBlock("pig_spawner",
            new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.PIG, 50));
    public static final Block CREEPER_SPAWNER = registerBlock("creeper_spawner",
            new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.CREEPER, 50));
    public static final Block AUTOKILLERSPAWNER = registerBlock("autokillerspawner",
            new AutoKillBlockForSpawner(AbstractBlock.Settings.create().ticksRandomly().strength(4f).requiresTool()));


    public static final Block CHICKEN_SPAWNERUP = registerBlock("chicken_spawnerup",
            new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.CHICKEN, 30));
    public static final Block COW_SPAWNERUP = registerBlock("cow_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.COW, 30));
    public static final Block SHEEP_SPAWNERUP = registerBlock("sheep_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SHEEP, 30));
    public static final Block RABBIT_SPAWNERUP = registerBlock("rabbit_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.RABBIT, 30));
    public static final Block TURTLE_SPAWNERUP = registerBlock("turtle_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.TURTLE, 30));
    public static final Block ZOMBIE_SPAWNERUP = registerBlock("zombie_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.ZOMBIE, 30));
    public static final Block SPIDER_SPAWNERUP = registerBlock("spider_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SPIDER, 30));
    public static final Block WITCH_SPAWNERUP = registerBlock("witch_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.WITCH, 30));
    public static final Block SQUID_SPAWNERUP = registerBlock("squid_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SQUID, 30));
    public static final Block SKELETON_SPAWNERUP = registerBlock("skeleton_spawnerup",
        new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.SKELETON, 30));
    public static final Block ENDERMAN_SPAWNERUP = registerBlock("enderman_spawnerup",
            new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.ENDERMAN, 30));
    public static final Block PIG_SPAWNERUP = registerBlock("pig_spawnerup",
            new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.PIG, 30));
    public static final Block CREEPER_SPAWNERUP = registerBlock("creeper_spawnerup",
            new ModSpawner(AbstractBlock.Settings.create().strength(5f).requiresTool().ticksRandomly(), EntityType.CREEPER, 30));



public static final Block MONEY_GENERATOR = registerBlock("money_generator",
        new MoneyGenerator(AbstractBlock.Settings.create()));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BlocopolisMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(BlocopolisMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        BlocopolisMod.LOGGER.info("Registering Mod Blocks for"+BlocopolisMod.MOD_ID);
    }
}
