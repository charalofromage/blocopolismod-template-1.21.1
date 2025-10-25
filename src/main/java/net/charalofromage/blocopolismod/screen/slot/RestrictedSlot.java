package net.charalofromage.blocopolismod.screen.slot;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class RestrictedSlot extends Slot {
    private final Item[] allowedItems;
    private final int maxCount;

    /**
     * @param inventory L'inventaire associé
     * @param index L'index du slot dans l'inventaire
     * @param x Position X dans le GUI
     * @param y Position Y dans le GUI
     * @param allowedItems Les items autorisés
     * @param maxCount Quantité max autorisée dans ce slot
     */
    public RestrictedSlot(Inventory inventory, int index, int x, int y, Item[] allowedItems, int maxCount) {
        super(inventory, index, x, y);
        this.allowedItems = allowedItems;
        this.maxCount = maxCount;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        // 🔒 Accepter seulement les items spécifiés
        for (Item allowed : allowedItems) {
            if (stack.isOf(allowed)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getMaxItemCount() {
        // 🔢 Limite de quantité autorisée
        return maxCount;
    }
}