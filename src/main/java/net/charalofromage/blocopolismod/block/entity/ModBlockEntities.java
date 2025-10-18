package net.charalofromage.blocopolismod.block.entity;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.block.entity.custom.ModChestEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {


    public static final BlockEntityType<ModChestEntity> SILVER_CHEST_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BlocopolisMod.MOD_ID, "silver_chest_be"),
                    BlockEntityType.Builder.create(ModChestEntity::new, ModBlocks.SILVER_CHEST).build(null));

    public static final BlockEntityType<ModChestEntity> BRONZE_CHEST_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BlocopolisMod.MOD_ID, "bronze_chest_be"),
                    BlockEntityType.Builder.create(ModChestEntity::new, ModBlocks.BRONZE_CHEST).build(null));

    public static final BlockEntityType<ModChestEntity> LEAD_CHEST_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BlocopolisMod.MOD_ID, "lead_chest_be"),
                    BlockEntityType.Builder.create(ModChestEntity::new, ModBlocks.LEAD_CHEST).build(null));




public static void registerBlockEntities(){
    BlocopolisMod.LOGGER.info("Registering Block Entities for " + BlocopolisMod.MOD_ID);
}

}
