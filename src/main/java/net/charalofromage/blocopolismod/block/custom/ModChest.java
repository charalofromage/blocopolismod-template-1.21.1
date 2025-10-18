package net.charalofromage.blocopolismod.block.custom;

import com.mojang.serialization.MapCodec;
import net.charalofromage.blocopolismod.block.entity.custom.ModChestEntity;
import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ModChest extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE =
            Block.createCuboidShape(1, 1, 1, 15, 15, 15);
    public static final MapCodec<ModChest> CODEC = ModChest.createCodec(ModChest::new);
    public ModChest(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ChestBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {

        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ModChestEntity){
                ItemScatterer.spawn(world, pos, ((ModChestEntity) blockEntity));
                world.updateComparators(pos, this);
            }


            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }
}
