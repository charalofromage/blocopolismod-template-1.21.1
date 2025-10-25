package net.charalofromage.blocopolismod.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record MoneyGeneratorRecipeInput(ItemStack input) implements RecipeInput {

    private static final int INPUT_SLOT = 0;

    @Override
    public ItemStack getStackInSlot(int slot) {
        if (slot == INPUT_SLOT) {
            return input;
        }
        return ItemStack.EMPTY;
    }

    @Override
    public int getSize() {
        return 1;
    }

    /**
     * Méthode utilitaire pour créer une entrée facilement.
     */
    public static MoneyGeneratorRecipeInput of(ItemStack stack) {
        return new MoneyGeneratorRecipeInput(stack);
    }
}