package net.charalofromage.blocopolismod.block.entity.custom;

import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.block.entity.ImplementedInventory;
import net.charalofromage.blocopolismod.block.entity.ModBlockEntities;
import net.charalofromage.blocopolismod.item.ModItems;
import net.charalofromage.blocopolismod.recipe.*;
import net.charalofromage.blocopolismod.screen.custom.MoneyGeneratorScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class MoneyGeneratorBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPos>, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);


    private final int INPUT_SLOT = 0;
    private final int OUTPUT_SLOT = 1;
    private final int LAVA_SLOT = 2;
    private final int INGOT_SLOT = 3;
    private final int PATTERN_SLOT = 4;


    protected final PropertyDelegate propertyDelegate;


    private int smeltProgress = 0;
    private int maxSmeltProgress = 100;

    private int craft_progress = 0;
    private int max_craft_progress = 1200;

    private int silver_quantity_stocked = 0;
    private int silver_quantity_add;
    private int silver_quantity_decrement;

    private int bronze_quantity_stocked = 0;
    private int bronze_quantity_add;
    private int bronze_quantity_decrement;


    private int lava_volume = 0;

    private Item[] bronze =
            {ModItems.BRONZE_INGOT, ModItems.BRONZE_NUGGET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_BOOTS,
                    ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_HELMET, ModItems.BRONZE_AXE, ModItems.BRONZE_COIN,
                    ModItems.BRONZE_HOE, ModItems.BRONZE_PICKAXE, ModItems.BRONZE_SHOVEL, ModItems.BRONZE_SWORD,

                    ModBlocks.BRONZE_BLOCK.asItem(), ModBlocks.BRONZE_SLAB.asItem(), ModBlocks.BRONZE_STAIRS.asItem(),
                    ModBlocks.BRONZE_WALL.asItem(), ModBlocks.BRONZE_FENCE.asItem(), ModBlocks.BRONZE_FENCE_GATE.asItem(),
                    ModBlocks.BRONZE_DOOR.asItem(), ModBlocks.BRONZE_TRAPDOOR.asItem() };

    public MoneyGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MONEY_GENERATOR_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> MoneyGeneratorBlockEntity.this.smeltProgress;
                    case 1 -> MoneyGeneratorBlockEntity.this.maxSmeltProgress;
                    case 2 -> MoneyGeneratorBlockEntity.this.silver_quantity_stocked;
                    case 3 -> MoneyGeneratorBlockEntity.this.lava_volume;
                    case 4 -> MoneyGeneratorBlockEntity.this.craft_progress;
                    case 5 -> MoneyGeneratorBlockEntity.this.max_craft_progress;
                    case 6 -> MoneyGeneratorBlockEntity.this.bronze_quantity_stocked;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: MoneyGeneratorBlockEntity.this.smeltProgress = value;
                    case 1: MoneyGeneratorBlockEntity.this.maxSmeltProgress = value;
                    case 2: MoneyGeneratorBlockEntity.this.silver_quantity_stocked = value;
                    case 3: MoneyGeneratorBlockEntity.this.lava_volume = value;
                    case 4: MoneyGeneratorBlockEntity.this.craft_progress = value;
                    case 5: MoneyGeneratorBlockEntity.this.max_craft_progress = value;
                    case 6: MoneyGeneratorBlockEntity.this.bronze_quantity_stocked = value;
                }
            }

            @Override
            public int size() {
                return 7;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.blocopolismod.money_generator");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MoneyGeneratorScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("money_generator.smeltProgress", smeltProgress);
        nbt.putInt("money_generator.max_progress", maxSmeltProgress);
        nbt.putInt("money_generator.quantity_stocked", silver_quantity_stocked);
        nbt.putInt("money_generator.lava_volume", lava_volume);
        nbt.putInt("money_generator.craft_progress", craft_progress);
        nbt.putInt("money_generator.max_craft_progress", max_craft_progress);
        nbt.putInt("money_generator.br_q_stocked", bronze_quantity_stocked);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        smeltProgress = nbt.getInt("money_generator.smeltProgress");
        maxSmeltProgress = nbt.getInt("money_generator.max_progress");
        silver_quantity_stocked = nbt.getInt("money_generator.quantity_stocked");
        lava_volume = nbt.getInt("money_generator.lava_volume");
        craft_progress = nbt.getInt("money_generator.craft_progress");
        max_craft_progress = nbt.getInt("money_generator.max_craft_progress");
        bronze_quantity_stocked = nbt.getInt("money_generator.br_q_stocked");

        super.readNbt(nbt, registryLookup);
    }





    public void tick(World world, BlockPos pos, BlockState state) {
        if (!world.isClient) {

            if (!hasLava() && this.getStack(LAVA_SLOT).isOf(Items.LAVA_BUCKET)) {
                refeelLava();
            }

            if (hasSmeltRecipe()) {
                increaseSmeltingProgress();
                markDirty(world, pos, state);
                if (hasSmletingFinished()) {
                    smeltItem();
                    resetSmeltingProgress();
                }
            } else {
                resetSmeltingProgress();
            }

            if (hasCraftRecipe()){
                if (hasLava() && hasEnoughQuantity() && canCraft()) {
                    increaseCraftingProgress();
                    markDirty(world, pos, state);
                    if (hasCraftingProgressFinished()){
                        craftItem();
                        resetCraftingProgress();
                    }
                }else {
                    resetCraftingProgress();
                }
            }else{
                resetCraftingProgress();
            }
        }
    }

    private boolean hasCraftRecipe() {

        Optional<RecipeEntry<MoneyGeneratorCraftRecipe>> recipe = getCurrentCraftRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        int quantity_required = recipe.get().value().quantity_required();

        if (this.getStack(INGOT_SLOT).getItem() == ModItems.BRONZE_INGOT){
            this.bronze_quantity_decrement = quantity_required;
        }else {
            this.silver_quantity_decrement = quantity_required;
        }

        return true;
    }

    private void resetCraftingProgress() {
        this.craft_progress = 0;
    }

    private boolean canCraft() {

        Optional<RecipeEntry<MoneyGeneratorCraftRecipe>> recipe = getCurrentCraftRecipe();

        ItemStack output = recipe.get().value().output();


        return canInsertAmountIntoOutputSlot(1, output.getItem().getMaxCount()) && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isOf(output.getItem()) || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(int count, int maxCount) {

        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    private void craftItem() {
        Optional<RecipeEntry<MoneyGeneratorCraftRecipe>> recipe = getCurrentCraftRecipe();

        ItemStack output = recipe.get().value().output();

        if (this.getStack(INGOT_SLOT).getItem() == ModItems.BRONZE_INGOT){
            this.bronze_quantity_stocked = this.bronze_quantity_stocked - bronze_quantity_decrement;
        }else{
            this.silver_quantity_stocked = this.silver_quantity_stocked - silver_quantity_decrement;
        }

        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));

        this.lava_volume += -1;
    }

    private boolean hasEnoughQuantity() {
        if (this.getStack(INGOT_SLOT).getItem() == ModItems.SILVER_INGOT){
            return this.silver_quantity_stocked >= this.silver_quantity_decrement;
        }else {
            return this.bronze_quantity_stocked >= this.bronze_quantity_decrement;
        }
    }

    private void increaseCraftingProgress() {
        this.craft_progress += 1;
    }

    private boolean hasCraftingProgressFinished() {
        return this.craft_progress >= max_craft_progress;
    }

    private void refeelLava() {
        this.lava_volume = 87;
        this.removeStack(LAVA_SLOT, 1);
    }

    private void smeltItem() {

        Optional<RecipeEntry<MoneyGeneratorRecipe>> recipe = getCurrentRecipe();

        this.bronze_quantity_stocked += bronze_quantity_add;
        this.silver_quantity_stocked += silver_quantity_add;

        this.removeStack(INPUT_SLOT, 1);
        this.lava_volume += -1;

        this.bronze_quantity_add = 0;
        this.silver_quantity_add = 0;
    }

    private void resetSmeltingProgress() {
        this.smeltProgress = 0;
    }

    private boolean hasSmletingFinished() {
        return this.smeltProgress >= this.maxSmeltProgress;
    }

    private void increaseSmeltingProgress() {
        this.smeltProgress += 1;
    }

    private boolean hasSmeltRecipe() {

        Optional<RecipeEntry<MoneyGeneratorRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return false;
        }

        ItemStack input = getStack(INPUT_SLOT);
        int output = recipe.get().value().output();

        int i =0 ;
        while (input.getItem() != bronze[i]){
            i += 1;
            if (i >= bronze.length){
                this.silver_quantity_add = output;
                return canAddSilverQuantityInStock() && hasLava();
            }
        }
        this.bronze_quantity_add = output;
        return canAddBronzeQuantityInStock() && hasLava();
    }

    private Optional<RecipeEntry<MoneyGeneratorRecipe>> getCurrentRecipe() {
        return this.getWorld().getRecipeManager()
                .getFirstMatch(ModRecipes.MONEY_GENERATOR_TYPE, new MoneyGeneratorRecipeInput(inventory.get(INPUT_SLOT)), this.getWorld());
    }

    private Optional<RecipeEntry<MoneyGeneratorCraftRecipe>> getCurrentCraftRecipe() {
        return this.getWorld().getRecipeManager()
                .getFirstMatch(ModRecipes.MONEY_GENERATOR_CRAFT_TYPE, new MoneyGeneratorCraftRecipeInput(
                        inventory.get(INPUT_SLOT),
                        inventory.get(OUTPUT_SLOT),
                        inventory.get(LAVA_SLOT),
                        inventory.get(INGOT_SLOT),
                        inventory.get(PATTERN_SLOT)
                ), this.getWorld());
    }

    private boolean canAddSilverQuantityInStock() {
        return this.silver_quantity_stocked + this.silver_quantity_add <= 100_000;
    }

    private boolean canAddBronzeQuantityInStock() {
        return this.bronze_quantity_stocked + this.bronze_quantity_add <= 100_000;
    }

    private boolean hasLava(){
        return this.lava_volume > 0;
    }


    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}