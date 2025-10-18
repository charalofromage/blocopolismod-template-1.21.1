package net.charalofromage.blocopolismod.item.custom;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;


public class RandomSpawnerItem extends Item {
    public RandomSpawnerItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        world = user.getWorld();

        double alea = Math.random() * 82 + 2;

        if (!world.isClient) {

            getDefaultStack().decrement(1);

            if (alea <= 8 || (alea <= 48 && alea > 45)) {
                return TypedActionResult.success(new ItemStack(ModBlocks.TURTLE_SPAWNER));
            }

            if (alea <= 16 && 8 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.COW_SPAWNER));
            }

            if (alea <= 24 && 16 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.SHEEP_SPAWNER), world.isClient());
            }

            if (alea <= 32 && 24 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.RABBIT_SPAWNER), world.isClient());
            }

            if (alea <= 40 && 32 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.CHICKEN_SPAWNER), world.isClient());
            }


            if (alea <= 45 && 40 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.SPIDER_SPAWNER), world.isClient());
            }


            if (alea <= 69 && 64 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.ZOMBIE_SPAWNER), world.isClient());
            }


            if (alea <= 74 && 69 < alea) {
            return TypedActionResult.success(new ItemStack(ModBlocks.SKELETON_SPAWNER), world.isClient());
            }


            if (alea <= 79 && 74 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.WITCH_SPAWNER), world.isClient());
            }


            if (alea <= 64 && 56 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.SQUID_SPAWNER), world.isClient());
            }


            if (alea <= 56 && 48 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.PIG_SPAWNER), world.isClient());
            }


            if (alea <= 84 && 79 < alea) {
                return TypedActionResult.success(new ItemStack(ModBlocks.ENDERMAN_SPAWNER), world.isClient());
            }
        }
        return TypedActionResult.success(new ItemStack(ModItems.RANDOM_SPAWNER), world.isClient());
    }
}

