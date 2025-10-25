package net.charalofromage.blocopolismod.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.InputIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.charalofromage.blocopolismod.block.custom.MoneyGenerator;
import net.charalofromage.blocopolismod.recipe.MoneyGeneratorRecipe;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class MoneyGeneratorDisplay implements Display {

    private final EntryIngredient input;
    private final int outputValue;
    private final Item inputItem;

    public MoneyGeneratorDisplay(MoneyGeneratorRecipe recipe) {
        this.input = EntryIngredients.ofIngredient(recipe.inputItem());
        this.outputValue = recipe.output();
        this.inputItem = recipe.getIngredients().get(0).getMatchingStacks()[0].getItem();
    }

    public Item getInputItem(){
        return inputItem;
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(input);
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of();
    }

    public int getOutputValue() {
        return outputValue;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MoneyGeneratorCategory.MONEY_GENERATOR;
    }

}
