package net.charalofromage.blocopolismod.screen.custom;

import net.charalofromage.blocopolismod.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class BronzeChestScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public BronzeChestScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf buf) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(buf.readBlockPos()));
    }

    public BronzeChestScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos pos) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(pos));
    }

    private static final int COLUMNS = 9;
    private static final int ROWS = 9;
    private static final int SLOT_SIZE = 18;

    // remplace ces valeurs par celles de ta texture (même que dans SilverChestScreen)
    private static final int BG_WIDTH = 176;   // <-- remplace par la largeur de ton image
    private static final int BG_HEIGHT = 274;  // <-- remplace par la hauteur de ton image

    // calcul automatique du startX/startY : centré horizontalement + marge verticale arbitraire
    // tu pourras ajuster 'offsetY' si les slots sont légèrement trop haut/bas dans ta texture
    private static final int startX = 8;
    private static final int offsetY = 18; // ajuste si nécessaire
    private static final int startY = offsetY;




    public BronzeChestScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity) {
        super(ModScreenHandlers.BRONZE_CHEST_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity);

        addChestInventory();

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

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
    private void addPlayerInventory(PlayerInventory playerInventory){
        for (int i = 0; i < 3; ++i){
            for (int l = 0; l < 9; ++l){
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 194 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory){
        for (int i = 0; i < 9; ++i){
            this.addSlot(new Slot(playerInventory, i,  8 + i * 18, 252));
        }
    }

    private void addChestInventory() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                int index = col + row * COLUMNS;
                int x = startX + col * SLOT_SIZE;
                int y = startY + row * SLOT_SIZE;
                this.addSlot(new Slot(inventory, index, x, y));
            }
        }
        System.out.println("Slots: " + this.slots.size());
    }
}