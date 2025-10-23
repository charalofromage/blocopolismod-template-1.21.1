package net.charalofromage.blocopolismod.block.entity.custom;

import net.charalofromage.blocopolismod.block.entity.ImplementedInventory;
import net.charalofromage.blocopolismod.block.entity.ModBlockEntities;
import net.charalofromage.blocopolismod.item.ModItems;
import net.charalofromage.blocopolismod.recipe.ModRecipes;
import net.charalofromage.blocopolismod.recipe.MoneyGeneratorRecipe;
import net.charalofromage.blocopolismod.recipe.MoneyGeneratorRecipeInput;
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
    private final int INGREDIENT_TYPE_SLOT = 3;
    private final int OUTPUT_TYPE_SLOT = 4;


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
        nbt.putInt("money_generator.quantity_decrement", silver_quantity_decrement);
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
        silver_quantity_decrement = nbt.getInt("money_generator.quantity_decrement");
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
        if (this.getStack(OUTPUT_TYPE_SLOT).getItem() == ModItems.COIN_PATTERN) {

            if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.BRONZE_INGOT) {
                this.bronze_quantity_decrement = 1;
                return true;
            }else if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.SILVER_INGOT){
                this.silver_quantity_decrement = 1;
                return true;
            }

        }else if (this.getStack(OUTPUT_TYPE_SLOT).getItem() == ModItems.INGOT_PATTERN){

            if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.BRONZE_INGOT) {
                this.bronze_quantity_decrement = 11;
                return true;
            }else if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.SILVER_INGOT){
                this.silver_quantity_decrement = 11;
                return true;
            }
        }
        return false;
    }

    private void resetCraftingProgress() {
        this.craft_progress = 0;
    }

    private boolean canCraft() {

        ItemStack output = null;

        if (this.getStack(OUTPUT_TYPE_SLOT).getItem() == ModItems.COIN_PATTERN) {

            if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.BRONZE_INGOT) {
                output = ModItems.BRONZE_COIN.getDefaultStack();

            }else if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.SILVER_INGOT){
                output = ModItems.SILVER_COIN.getDefaultStack();

            }

        }else if (this.getStack(OUTPUT_TYPE_SLOT).getItem() == ModItems.INGOT_PATTERN){

            if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.BRONZE_INGOT) {
                output = ModItems.BRONZE_INGOT.getDefaultStack();

            }else if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.SILVER_INGOT){
                output = ModItems.SILVER_INGOT.getDefaultStack();

            }
        }
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
    ItemStack output = null;
        if (this.getStack(OUTPUT_TYPE_SLOT).getItem() == ModItems.COIN_PATTERN) {

            if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.BRONZE_INGOT) {
                output = new ItemStack(ModItems.BRONZE_COIN);
                this.bronze_quantity_stocked = this.bronze_quantity_stocked - bronze_quantity_decrement;
            }else if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.SILVER_INGOT){
                output = new ItemStack(ModItems.SILVER_COIN);
                this.silver_quantity_stocked = this.silver_quantity_stocked - silver_quantity_decrement;
            }

        }else if (this.getStack(OUTPUT_TYPE_SLOT).getItem() == ModItems.INGOT_PATTERN){

            if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.BRONZE_INGOT) {
                output = new ItemStack(ModItems.BRONZE_INGOT);
                this.bronze_quantity_stocked = this.bronze_quantity_stocked - bronze_quantity_decrement;
            }else if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.SILVER_INGOT){
                output = new ItemStack(ModItems.SILVER_INGOT);
                this.silver_quantity_stocked = this.silver_quantity_stocked - silver_quantity_decrement;
            }
        }
        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
        this.lava_volume += -1;
    }

    private boolean hasEnoughQuantity() {
        if (this.getStack(INGREDIENT_TYPE_SLOT).getItem() == ModItems.SILVER_INGOT){
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
        Item inputType = recipe.get().value().output().getItem();

        this.removeStack(INPUT_SLOT, 1);

        if (inputType == ModItems.BRONZE_NUGGET){
            this.bronze_quantity_stocked += bronze_quantity_add;
        }else{
        this.silver_quantity_stocked += silver_quantity_add;
        }
        this.lava_volume += -1;
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

        ItemStack output = recipe.get().value().output();

        if (output.getItem() == ModItems.BRONZE_NUGGET){
            this.bronze_quantity_add = output.getCount();
            return canAddBronzeQuantityInStock() && hasLava();
        }else {
            this.silver_quantity_add = output.getCount();
            return canAddSilverQuantityInStock() && hasLava();
        }
    }

    private Optional<RecipeEntry<MoneyGeneratorRecipe>> getCurrentRecipe() {
        ItemStack stack = inventory.get(INPUT_SLOT);

        return this.getWorld().getRecipeManager().getFirstMatch(ModRecipes.MONEY_GENERATOR_TYPE,
                new MoneyGeneratorRecipeInput(inventory.get(INPUT_SLOT)), this.getWorld());
    }

    private boolean canAddSilverQuantityInStock() {
        return this.silver_quantity_stocked + this.silver_quantity_add <= 10_000;
    }

    private boolean canAddBronzeQuantityInStock() {
        return this.bronze_quantity_stocked + this.bronze_quantity_add <= 10_000;
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