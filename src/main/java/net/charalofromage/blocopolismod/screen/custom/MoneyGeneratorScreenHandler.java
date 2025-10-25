package net.charalofromage.blocopolismod.screen.custom;

import dev.architectury.platform.Mod;
import net.charalofromage.blocopolismod.block.entity.custom.MoneyGeneratorBlockEntity;
import net.charalofromage.blocopolismod.item.ModItems;
import net.charalofromage.blocopolismod.screen.ModScreenHandlers;
import net.charalofromage.blocopolismod.screen.slot.RestrictedSlot;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class MoneyGeneratorScreenHandler extends ScreenHandler {

private final Inventory inventory;
private final PropertyDelegate propertyDelegate;
private final MoneyGeneratorBlockEntity blockEntity;

public MoneyGeneratorScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos){
    this(syncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(7));
}

public MoneyGeneratorScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate){
    super(ModScreenHandlers.MONEY_GENERATOR_SCREEN_HANDLER, syncId);
    this.inventory = ((Inventory) blockEntity);
    this.blockEntity = ((MoneyGeneratorBlockEntity) blockEntity);
    this.propertyDelegate = arrayPropertyDelegate;

    this.addSlot(new Slot(inventory, 0, 26, 54));
    this.addSlot(new Slot(inventory, 1, 26, 126));
    this.addSlot(new RestrictedSlot(inventory, 2, 144, 150,
            new Item[]{Items.LAVA_BUCKET}, 1));
    this.addSlot(new RestrictedSlot(inventory, 3, 8, 18,
            new Item[]{ModItems.BRONZE_INGOT, ModItems.SILVER_INGOT}, 1));
    this.addSlot(new RestrictedSlot(inventory, 4, 26, 108,
            new Item[]{ModItems.INGOT_PATTERN, ModItems.COIN_PATTERN, ModItems.AXE_PATTERN, ModItems.PICKAXE_PATTERN,
                    ModItems.BOOTS_PATTERN, ModItems.HELMET_PATTERN, ModItems.HOE_PATTERN, ModItems.CHESTPLATE_PATTERN,
                    ModItems.SWORD_PATTERN, ModItems.LEGGINGS_PATTERN},
            1));

    addPlayerInventory(playerInventory);
    addPlayerHotbar(playerInventory);

    addProperties(arrayPropertyDelegate);
}

    public PropertyDelegate getPropertyDelegate() {
        return this.propertyDelegate;
    }

public boolean isSmelting(){
    return propertyDelegate.get(0) > 0;
}
public boolean isCrafting(){
    return propertyDelegate.get(4) > 0;
}

public int getScaleArrowProgress(){
    int progress = this.propertyDelegate.get(0);
    int maxProgress = this.propertyDelegate.get(1);
    int arrowPixelSize = 78;

    return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize/maxProgress : 0 ;
}

public int getScaleSecondArrowProgress(){
    int progress = this.propertyDelegate.get(4);
    int maxProgress = this.propertyDelegate.get(5);
    int arrowPixelSize = 78;

    return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize/maxProgress : 0 ;
}

public int getScaleSilverBarreProgress(){
    int progress = this.propertyDelegate.get(2);
    int maxProgress = 100_000;
    int arrowPixelSize = 81;

    return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize/maxProgress : 0 ;
}

public int getScaleBronzeBarreProgress(){
    int progress = this.propertyDelegate.get(6);
    int maxProgress = 100_000;
    int arrowPixelSize = 81;

    return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize/maxProgress : 0 ;
}




    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 192 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 250));
        }
    }
}
