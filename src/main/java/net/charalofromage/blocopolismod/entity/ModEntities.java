package net.charalofromage.blocopolismod.entity;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.entity.custom.LightningOrbProjectileEntity;
import net.charalofromage.blocopolismod.entity.custom.SnakeEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
public static final EntityType<SnakeEntity> SNAKE = Registry.register(Registries.ENTITY_TYPE,
        Identifier.of(BlocopolisMod.MOD_ID, "snake"),
        EntityType.Builder.create(SnakeEntity::new,SpawnGroup.CREATURE )
                .dimensions(1.49f, 0.49f)
                .build());

    public static final EntityType LIGHTNING_ORB = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BlocopolisMod.MOD_ID, "lightning_orb"),
            EntityType.Builder.<LightningOrbProjectileEntity>create(LightningOrbProjectileEntity::new,SpawnGroup.MISC )
            .dimensions(0.5f, 0.5f)
                .build());

    public static void  registerModEntities(){
        BlocopolisMod.LOGGER.info("Registering Mod Entities for "+BlocopolisMod.MOD_ID);
    }
}
