package net.charalofromage.blocopolismod.item.custom;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Spawner_upgrade extends Item {
    public Spawner_upgrade(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        BlockPos blockPos = context.getBlockPos();
        BlockState state = world.getBlockState(blockPos);
        Block block = state.getBlock();
        ItemStack stack = context.getStack();

        if (!world.isClient){
            if (block == ModBlocks.CREEPER_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.CREEPER_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.COW_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.COW_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.RABBIT_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.RABBIT_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.SHEEP_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.SHEEP_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.ENDERMAN_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.ENDERMAN_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            }else if (block == ModBlocks.ZOMBIE_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.ZOMBIE_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.SKELETON_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.SKELETON_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.SPIDER_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.SPIDER_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.WITCH_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.WITCH_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.TURTLE_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.TURTLE_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.SQUID_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.SQUID_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.CHICKEN_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.CHICKEN_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            } else if (block == ModBlocks.PIG_SPAWNER){
            world.setBlockState(blockPos, ModBlocks.PIG_SPAWNERUP.getDefaultState());
                stack.decrementUnlessCreative(1, context.getPlayer());
            }
        }
        return super.useOnBlock(context);
    }
}
