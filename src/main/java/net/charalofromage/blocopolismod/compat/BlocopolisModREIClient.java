package net.charalofromage.blocopolismod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.recipe.ModRecipes;
import net.charalofromage.blocopolismod.recipe.MoneyGeneratorCraftRecipe;
import net.charalofromage.blocopolismod.recipe.MoneyGeneratorRecipe;
import net.charalofromage.blocopolismod.screen.custom.MoneyGeneratorScreen;

import java.awt.*;

public class BlocopolisModREIClient implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {

        registry.add(new MoneyGeneratorCategory());
        registry.addWorkstations(MoneyGeneratorCategory.MONEY_GENERATOR, EntryStacks.of(ModBlocks.MONEY_GENERATOR));

        registry.add(new MoneyGeneratorCraftCategory());
        registry.addWorkstations(MoneyGeneratorCraftCategory.MONEY_GENERATOR_CRAFT, EntryStacks.of(ModBlocks.MONEY_GENERATOR));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {

        registry.registerRecipeFiller(
                MoneyGeneratorRecipe.class,
                ModRecipes.MONEY_GENERATOR_TYPE,
                entry -> new MoneyGeneratorDisplay(entry.value())
        );

        registry.registerRecipeFiller(
                MoneyGeneratorCraftRecipe.class,
                ModRecipes.MONEY_GENERATOR_CRAFT_TYPE,
                entry -> new MoneyGeneratorCraftDisplay(entry.value())
        );
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        //Slots du plus haut au plus bas
        registry.registerClickArea(screen -> new Rectangle(25, 35, 18, 18), MoneyGeneratorScreen.class, MoneyGeneratorCategory.MONEY_GENERATOR);

        registry.registerClickArea(screen -> new Rectangle(25, 107, 18, 18), MoneyGeneratorScreen.class, MoneyGeneratorCraftCategory.MONEY_GENERATOR_CRAFT);
        registry.registerClickArea(screen -> new Rectangle(7, 5, 18, 18), MoneyGeneratorScreen.class, MoneyGeneratorCraftCategory.MONEY_GENERATOR_CRAFT);
        registry.registerClickArea(screen -> new Rectangle(25, 89, 18, 18), MoneyGeneratorScreen.class, MoneyGeneratorCraftCategory.MONEY_GENERATOR_CRAFT);
    }
}
