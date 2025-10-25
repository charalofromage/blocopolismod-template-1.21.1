package net.charalofromage.blocopolismod.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.charalofromage.blocopolismod.recipe.MoneyGeneratorCraftRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MoneyGeneratorCraftDisplay implements Display {

    private final EntryIngredient ingot;
    private final EntryIngredient pattern;
    private final int inputValue;
    private final EntryIngredient output;
    private final Item outputItem;

    public MoneyGeneratorCraftDisplay(MoneyGeneratorCraftRecipe recipe) {
        this.ingot = EntryIngredients.ofIngredient(recipe.ingot());
        this.pattern = EntryIngredients.ofIngredient(recipe.pattern());
        this.inputValue = recipe.quantity_required();
        this.output = EntryIngredients.of(recipe.output());
        this.outputItem = recipe.output().getItem();
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(ingot, pattern);
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(output);
    }

    public Item getOutputItem(){
        return outputItem;
    }

    public int getInputValue() {
        return inputValue;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MoneyGeneratorCraftCategory.MONEY_GENERATOR_CRAFT;
    }

}
