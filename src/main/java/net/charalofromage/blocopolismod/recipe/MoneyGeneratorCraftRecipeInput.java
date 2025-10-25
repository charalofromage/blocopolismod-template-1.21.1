package net.charalofromage.blocopolismod.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record MoneyGeneratorCraftRecipeInput(
        ItemStack inputSlot,   // 0
        ItemStack outputSlot,  // 1
        ItemStack lavaSlot,    // 2
        ItemStack ingotSlot,   // 3
        ItemStack patternSlot  // 4
) implements RecipeInput {

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int LAVA_SLOT = 2;
    private static final int INGOT_SLOT = 3;
    private static final int PATTERN_SLOT = 4;

    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case INPUT_SLOT -> inputSlot;
            case OUTPUT_SLOT -> outputSlot;
            case LAVA_SLOT -> lavaSlot;
            case INGOT_SLOT -> ingotSlot;
            case PATTERN_SLOT -> patternSlot;
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public int getSize() {
        return 5;
    }
}