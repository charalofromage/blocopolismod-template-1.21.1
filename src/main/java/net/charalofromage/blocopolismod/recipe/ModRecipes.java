package net.charalofromage.blocopolismod.recipe;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static final RecipeSerializer<MoneyGeneratorRecipe> MONEY_GENERATOR_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(BlocopolisMod.MOD_ID, "money_generator"),
            new MoneyGeneratorRecipe.Serializer());

    public static final RecipeType<MoneyGeneratorRecipe> MONEY_GENERATOR_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(BlocopolisMod.MOD_ID, "money_generator"),
            new RecipeType<MoneyGeneratorRecipe>() {

                @Override
                public String toString() {
                    return "money_generator";
                }});


    public static final RecipeSerializer<MoneyGeneratorCraftRecipe> MONEY_GENERATOR_CRAFT_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(BlocopolisMod.MOD_ID, "money_generator_craft"),
            new MoneyGeneratorCraftRecipe.Serializer());

    public static final RecipeType<MoneyGeneratorCraftRecipe> MONEY_GENERATOR_CRAFT_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(BlocopolisMod.MOD_ID, "money_generator_craft"),
            new RecipeType<MoneyGeneratorCraftRecipe>() {

                @Override
                public String toString() {
                    return "money_generator_craft";
                }});


    public static void registerRecipes(){
        BlocopolisMod.LOGGER.info("Registering Custom Recipes for " + BlocopolisMod.MOD_ID);
    }
}
