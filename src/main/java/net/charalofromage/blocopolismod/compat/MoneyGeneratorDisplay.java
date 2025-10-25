package net.charalofromage.blocopolismod.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.charalofromage.blocopolismod.block.custom.MoneyGenerator;
import net.charalofromage.blocopolismod.recipe.MoneyGeneratorRecipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.List;

public class MoneyGeneratorDisplay extends BasicDisplay {

    public MoneyGeneratorDisplay(RecipeEntry<MoneyGeneratorRecipe> recipe){
        super(List.of(
                //EntryIngredients.ofIngredient(recipe.value().getIngredients().get(1)), //lingot
                EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0)) //Input
                //EntryIngredients.ofIngredient(recipe.value().getIngredients().get(2))  //paterne
                ),

                List.of(
                        EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))

                ));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return MoneyGeneratorCategory.MONEY_GENERATOR;
    }
}
