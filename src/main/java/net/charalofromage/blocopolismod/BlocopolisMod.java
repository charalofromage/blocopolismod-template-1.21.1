package net.charalofromage.blocopolismod;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.block.entity.ModBlockEntities;
import net.charalofromage.blocopolismod.entity.ModEntities;
import net.charalofromage.blocopolismod.entity.custom.SnakeEntity;
import net.charalofromage.blocopolismod.item.ModItemGroups;
import net.charalofromage.blocopolismod.item.ModItems;
import net.charalofromage.blocopolismod.util.TickScheduler;
import net.charalofromage.blocopolismod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;


import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.EnchantmentEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.util.TriState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlocopolisMod implements ModInitializer {
	public static final String MOD_ID = "blocopolismod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModWorldGeneration.generateModWorldGen();
		ModEntities.registerModEntities();

		ModBlockEntities.registerBlockEntities();

		FabricDefaultAttributeRegistry.register(ModEntities.SNAKE, SnakeEntity.createAttributes());

		ServerTickEvents.END_WORLD_TICK.register((ServerWorld world) -> {
			TickScheduler.tick(world);
		});

	}
}