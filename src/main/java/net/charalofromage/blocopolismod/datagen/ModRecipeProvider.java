package net.charalofromage.blocopolismod.datagen;

import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder.createStonecutting;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> SILVER_SMELTABLES = List.of(ModItems.RAW_SILVER,
                ModBlocks.SILVER_ORE,
                ModBlocks.DEEPSLATE_SILVER_ORE);
        offerSmelting(recipeExporter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.25f, 200, "silver_ingot");
        offerBlasting(recipeExporter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.SILVER_INGOT, 0.25f, 100, "silver_ingot");


        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_SILVER, RecipeCategory.DECORATIONS, ModBlocks.RAW_SILVER_BLOCK);

        List<ItemConvertible> LEAD_SMELTABLES = List.of(ModItems.RAW_LEAD,
                ModBlocks.LEAD_ORE,
                ModBlocks.DEEPSLATE_LEAD_ORE);
        offerSmelting(recipeExporter, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT, 0.25f, 200, "lead_ingot");
        offerBlasting(recipeExporter, SILVER_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT, 0.25f, 100, "lead_ingot");


        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_LEAD, RecipeCategory.DECORATIONS, ModBlocks.RAW_LEAD_BLOCK);

        List<ItemConvertible> BRONZE_SMELTABLES = List.of(ModItems.RAW_BRONZE,
                ModBlocks.BRONZE_ORE,
                ModBlocks.DEEPSLATE_BRONZE_ORE);
        offerSmelting(recipeExporter, BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.25f, 200, "bronze_ingot");
        offerBlasting(recipeExporter, BRONZE_SMELTABLES, RecipeCategory.MISC, ModItems.BRONZE_INGOT, 0.25f, 100, "bronze_ingot");


        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BRONZE, RecipeCategory.DECORATIONS, ModBlocks.RAW_BRONZE_BLOCK);


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.POSEIDON_WEAPON)
                .pattern("TTT")
                .pattern(" S ")
                .pattern(" S ")
                .input('T', Items.TRIDENT)
                .input('S', ModItems.POSEIDON_STICK)
                .criterion(hasItem(Items.TRIDENT), conditionsFromItem(Items.TRIDENT))
                .criterion(hasItem(ModItems.POSEIDON_STICK), conditionsFromItem(ModItems.POSEIDON_STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_STICK)
                .pattern("   ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', ModItems.SILVER_INGOT)
                .criterion(hasItem(ModItems.SILVER_INGOT), conditionsFromItem(ModItems.SILVER_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_STICK)
                .pattern("   ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAD_STICK)
                .pattern("   ")
                .pattern(" S ")
                .pattern(" S ")
                .input('S', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_STICK), conditionsFromItem(ModItems.LEAD_STICK))
                .offerTo(recipeExporter);


        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BRONZE_NUGGET, RecipeCategory.DECORATIONS, ModItems.BRONZE_INGOT);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SILVER_NUGGET, RecipeCategory.DECORATIONS, ModItems.SILVER_INGOT);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.LEAD_NUGGET, RecipeCategory.DECORATIONS, ModItems.LEAD_INGOT);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_INGOT, 9)
                .input(ModBlocks.SILVER_BLOCK)
                .criterion(hasItem(ModBlocks.SILVER_BLOCK), conditionsFromItem(ModBlocks.SILVER_BLOCK))
                .offerTo(recipeExporter, Identifier.of(BlocopolisMod.MOD_ID, "silver_ingot_from_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEAD_INGOT, 9)
                .input(ModBlocks.LEAD_BLOCK)
                .criterion(hasItem(ModBlocks.LEAD_BLOCK), conditionsFromItem(ModBlocks.LEAD_BLOCK))
                .offerTo(recipeExporter, Identifier.of(BlocopolisMod.MOD_ID, "lead_ingot_from_block"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_INGOT, 9)
                .input(ModBlocks.BRONZE_BLOCK)
                .criterion(hasItem(ModBlocks.BRONZE_BLOCK), conditionsFromItem(ModBlocks.BRONZE_BLOCK))
                .offerTo(recipeExporter, Identifier.of(BlocopolisMod.MOD_ID, "bronze_ingot_from_block"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.SILVER_INGOT)
                .criterion(hasItem(ModItems.SILVER_INGOT), conditionsFromItem(ModItems.SILVER_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.LEAD_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BRONZE_BLOCK)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SILVER_SLAB, 2)
                .pattern("SSS")
                .pattern("   ")
                .pattern("   ")
                .input('S', ModBlocks.SILVER_BLOCK).criterion(hasItem(ModBlocks.SILVER_BLOCK), conditionsFromItem(ModBlocks.SILVER_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SILVER_STAIRS, 4)
                .pattern("  S")
                .pattern(" SS")
                .pattern("SSS")
                .input('S', ModBlocks.SILVER_BLOCK).criterion(hasItem(ModBlocks.SILVER_BLOCK), conditionsFromItem(ModBlocks.SILVER_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SILVER_WALL, 6)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModBlocks.SILVER_BLOCK).criterion(hasItem(ModBlocks.SILVER_BLOCK), conditionsFromItem(ModBlocks.SILVER_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SILVER_DOOR, 3)
                .pattern(" SS")
                .pattern(" SS")
                .pattern(" SS")
                .input('S', ModItems.SILVER_INGOT).criterion(hasItem(ModItems.SILVER_INGOT), conditionsFromItem(ModItems.SILVER_INGOT)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SILVER_FENCE, 3)
                .pattern("STS")
                .pattern("STS")
                .pattern("   ")
                .input('S', ModBlocks.SILVER_BLOCK)
                .input('T', ModItems.SILVER_STICK)
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_INGOT))
                .criterion(hasItem(ModBlocks.SILVER_BLOCK), conditionsFromItem(ModBlocks.SILVER_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SILVER_FENCE_GATE, 1)
                .pattern("STS")
                .pattern("STS")
                .pattern("   ")
                .input('T', ModBlocks.SILVER_BLOCK)
                .input('S', ModItems.SILVER_STICK)
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_INGOT))
                .criterion(hasItem(ModBlocks.SILVER_BLOCK), conditionsFromItem(ModBlocks.SILVER_BLOCK))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SILVER_TRAPDOOR, 2)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModItems.SILVER_INGOT).criterion(hasItem(ModItems.SILVER_INGOT), conditionsFromItem(ModItems.SILVER_INGOT)).offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_BLOCK, ModBlocks.SILVER_STAIRS, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_BLOCK, ModBlocks.SILVER_SLAB, 2);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_BLOCK, ModBlocks.SILVER_FENCE, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_BLOCK, ModBlocks.SILVER_FENCE_GATE, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_BLOCK, ModBlocks.SILVER_WALL, 1);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_STAIRS, ModBlocks.SILVER_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_FENCE, ModBlocks.SILVER_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_FENCE_GATE, ModBlocks.SILVER_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.SILVER_WALL, ModBlocks.SILVER_BLOCK, 1);



        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BRONZE_SLAB, 2)
                .pattern("SSS")
                .pattern("   ")
                .pattern("   ")
                .input('S', ModBlocks.BRONZE_BLOCK).criterion(hasItem(ModBlocks.BRONZE_BLOCK), conditionsFromItem(ModBlocks.BRONZE_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BRONZE_STAIRS, 4)
                .pattern("  S")
                .pattern(" SS")
                .pattern("SSS")
                .input('S', ModBlocks.BRONZE_BLOCK).criterion(hasItem(ModBlocks.BRONZE_BLOCK), conditionsFromItem(ModBlocks.BRONZE_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BRONZE_WALL, 6)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModBlocks.BRONZE_BLOCK).criterion(hasItem(ModBlocks.BRONZE_BLOCK), conditionsFromItem(ModBlocks.BRONZE_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BRONZE_DOOR, 3)
                .pattern(" SS")
                .pattern(" SS")
                .pattern(" SS")
                .input('S', ModItems.BRONZE_INGOT).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BRONZE_FENCE, 3)
                .pattern("STS")
                .pattern("STS")
                .pattern("   ")
                .input('S', ModBlocks.BRONZE_BLOCK)
                .input('T', ModItems.BRONZE_STICK)
                .criterion(hasItem(ModItems.BRONZE_STICK), conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(hasItem(ModBlocks.BRONZE_BLOCK), conditionsFromItem(ModBlocks.BRONZE_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BRONZE_FENCE_GATE, 1)
                .pattern("STS")
                .pattern("STS")
                .pattern("   ")
                .input('T', ModBlocks.BRONZE_BLOCK)
                .input('S', ModItems.BRONZE_STICK)
                .criterion(hasItem(ModItems.BRONZE_STICK), conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(hasItem(ModBlocks.BRONZE_BLOCK), conditionsFromItem(ModBlocks.BRONZE_BLOCK))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.BRONZE_TRAPDOOR, 2)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModItems.BRONZE_INGOT).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_BLOCK, ModBlocks.BRONZE_STAIRS, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_BLOCK, ModBlocks.BRONZE_SLAB, 2);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_BLOCK, ModBlocks.BRONZE_FENCE, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_BLOCK, ModBlocks.BRONZE_FENCE_GATE, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_BLOCK, ModBlocks.BRONZE_WALL, 1);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_STAIRS, ModBlocks.BRONZE_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_FENCE, ModBlocks.BRONZE_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_FENCE_GATE, ModBlocks.BRONZE_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.BRONZE_WALL, ModBlocks.BRONZE_BLOCK, 1);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEAD_SLAB, 2)
                .pattern("SSS")
                .pattern("   ")
                .pattern("   ")
                .input('S', ModBlocks.LEAD_BLOCK).criterion(hasItem(ModBlocks.LEAD_BLOCK), conditionsFromItem(ModBlocks.LEAD_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEAD_STAIRS, 4)
                .pattern("  S")
                .pattern(" SS")
                .pattern("SSS")
                .input('S', ModBlocks.LEAD_BLOCK).criterion(hasItem(ModBlocks.LEAD_BLOCK), conditionsFromItem(ModBlocks.LEAD_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEAD_WALL, 6)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModBlocks.LEAD_BLOCK).criterion(hasItem(ModBlocks.LEAD_BLOCK), conditionsFromItem(ModBlocks.LEAD_BLOCK)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEAD_DOOR, 3)
                .pattern(" SS")
                .pattern(" SS")
                .pattern(" SS")
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT)).offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEAD_FENCE, 3)
                .pattern("STS")
                .pattern("STS")
                .pattern("   ")
                .input('S', ModBlocks.LEAD_BLOCK)
                .input('T', ModItems.LEAD_STICK)
                .criterion(hasItem(ModItems.LEAD_STICK), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(ModBlocks.LEAD_BLOCK), conditionsFromItem(ModBlocks.LEAD_BLOCK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEAD_FENCE_GATE, 1)
                .pattern("STS")
                .pattern("STS")
                .pattern("   ")
                .input('T', ModBlocks.LEAD_BLOCK)
                .input('S', ModItems.LEAD_STICK)
                .criterion(hasItem(ModItems.LEAD_STICK), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(ModBlocks.LEAD_BLOCK), conditionsFromItem(ModBlocks.LEAD_BLOCK))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.LEAD_TRAPDOOR, 2)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("   ")
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT)).offerTo(recipeExporter);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_BLOCK, ModBlocks.LEAD_STAIRS, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_BLOCK, ModBlocks.LEAD_SLAB, 2);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_BLOCK, ModBlocks.LEAD_FENCE, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_BLOCK, ModBlocks.LEAD_FENCE_GATE, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_BLOCK, ModBlocks.LEAD_WALL, 1);

        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_STAIRS, ModBlocks.LEAD_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_FENCE, ModBlocks.LEAD_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_FENCE_GATE, ModBlocks.LEAD_BLOCK, 1);
        offerStonecuttingRecipe(recipeExporter, RecipeCategory.DECORATIONS, ModBlocks.LEAD_WALL, ModBlocks.LEAD_BLOCK, 1);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_HOE, 1)
                .pattern(" SS")
                .pattern(" T ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

                ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_HOE, 1)
                .pattern(" SS")
                .pattern(" T ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" T ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_AXE, 1)
                .pattern(" SS")
                .pattern(" TS")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SHOVEL, 1)
                .pattern(" S ")
                .pattern(" T ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BRONZE_SWORD, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.BRONZE_INGOT)
                .criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" T ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_AXE, 1)
                .pattern(" SS")
                .pattern(" TS")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK)).offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_SHOVEL, 1)
                .pattern(" S ")
                .pattern(" T ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(recipeExporter);

               ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.LEAD_SWORD, 1)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" T ")
                .input('T', Items.STICK)
                .input('S', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                       .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.HADES_WEAPON, 1)
                .pattern(" SS")
                .pattern(" T ")
                .pattern(" T ")
                .input('T', ModItems.SILVER_STICK)
                .input('S', ModItems.PIECE_OF_BLADE_OF_HADES)
                .criterion(hasItem(ModItems.PIECE_OF_BLADE_OF_HADES), conditionsFromItem(ModItems.PIECE_OF_BLADE_OF_HADES))
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_STICK))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.BRONZE_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.BRONZE_INGOT).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.BRONZE_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.BRONZE_INGOT).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.BRONZE_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.BRONZE_INGOT).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.BRONZE_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.BRONZE_INGOT).criterion(hasItem(ModItems.BRONZE_INGOT), conditionsFromItem(ModItems.BRONZE_INGOT)).offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.LEAD_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.LEAD_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.LEAD_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.LEAD_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT)).offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.TRAVEL_HELMET, 1)
                .pattern("CSC")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .input('C', ModItems.OWL_EYES).criterion(hasItem(ModItems.OWL_EYES), conditionsFromItem(ModItems.OWL_EYES)).offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.TRAVEL_CHESTPLATE, 1)
                .pattern("T T")
                .pattern("ZPZ")
                .pattern("SSS")
                .input('P', ModItems.PLUME_DE_PAN).criterion(hasItem(ModItems.PLUME_DE_PAN), conditionsFromItem(ModItems.PLUME_DE_PAN))
                .input('Z', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .input('S', ModItems.SNAKE_SKIN).criterion(hasItem(ModItems.SNAKE_SKIN), conditionsFromItem(ModItems.SNAKE_SKIN))
                .input('T', Items.STRING).criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.TRAVEL_LEGGINGS, 1)
                .pattern("CCC")
                .pattern("S S")
                .pattern("P P")
                .input('C', Items.LEATHER).criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .input('S', ModItems.LEAD_INGOT).criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .input('P', ModItems.SNAKE_SKIN).criterion(hasItem(ModItems.SNAKE_SKIN), conditionsFromItem(ModItems.SNAKE_SKIN))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.TRAVEL_BOOTS, 1)
                .pattern("S S")
                .pattern("P P")
                .pattern("   ")
                .input('S', ModItems.PLUME_DE_PAN)
                .input('P', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(ModItems.PLUME_DE_PAN), conditionsFromItem(ModItems.PLUME_DE_PAN)).
                offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COIN_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_NUGGET)
                .criterion(hasItem(ModItems.LEAD_NUGGET), conditionsFromItem(ModItems.LEAD_NUGGET))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.INGOT_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_INGOT)
                .criterion(hasItem(ModItems.LEAD_INGOT), conditionsFromItem(ModItems.LEAD_INGOT))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SHOVEL_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_SHOVEL)
                .criterion(hasItem(ModItems.LEAD_SHOVEL), conditionsFromItem(ModItems.LEAD_SHOVEL))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AXE_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_AXE)
                .criterion(hasItem(ModItems.LEAD_AXE), conditionsFromItem(ModItems.LEAD_AXE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PICKAXE_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_PICKAXE)
                .criterion(hasItem(ModItems.LEAD_PICKAXE), conditionsFromItem(ModItems.LEAD_PICKAXE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SWORD_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_SWORD)
                .criterion(hasItem(ModItems.LEAD_SWORD), conditionsFromItem(ModItems.LEAD_SWORD))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HOE_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_HOE)
                .criterion(hasItem(ModItems.LEAD_HOE), conditionsFromItem(ModItems.LEAD_HOE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HELMET_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_HELMET)
                .criterion(hasItem(ModItems.LEAD_HELMET), conditionsFromItem(ModItems.LEAD_HELMET))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHESTPLATE_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_CHESTPLATE)
                .criterion(hasItem(ModItems.LEAD_CHESTPLATE), conditionsFromItem(ModItems.LEAD_CHESTPLATE))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LEGGINGS_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_LEGGINGS)
                .criterion(hasItem(ModItems.LEAD_LEGGINGS), conditionsFromItem(ModItems.LEAD_LEGGINGS))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BOOTS_PATTERN, 1)
                .pattern("DDD")
                .pattern("DND")
                .pattern("DDD")
                .input('D', Items.DIAMOND)
                .input('N', ModItems.LEAD_BOOTS)
                .criterion(hasItem(ModItems.LEAD_BOOTS), conditionsFromItem(ModItems.LEAD_BOOTS))
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND)).
                offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.HADES_WEAPON)
                .input(ModItems.HADES_WEAPON)
                .input(ModItems.PIECE_OF_BLADE_OF_HADES)
                .criterion(hasItem(ModItems.HADES_WEAPON), conditionsFromItem(ModItems.HADES_WEAPON))
                .criterion(hasItem(ModItems.PIECE_OF_BLADE_OF_HADES), conditionsFromItem(ModItems.PIECE_OF_BLADE_OF_HADES))
                .offerTo(recipeExporter, getRecipeName(ModItems.HADES_WEAPON)+ "_repair");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_SWORD)
                .input(ModItems.SILVER_STICK)
                .input(ModItems.SILVER_SWORD_HEAD)
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_STICK))
                .criterion(hasItem(ModItems.SILVER_SWORD_HEAD), conditionsFromItem(ModItems.SILVER_SWORD_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.SILVER_SWORD) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_HOE)
                .input(ModItems.SILVER_STICK)
                .input(ModItems.SILVER_HOE_HEAD)
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_STICK))
                .criterion(hasItem(ModItems.SILVER_HOE_HEAD), conditionsFromItem(ModItems.SILVER_HOE_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.SILVER_HOE) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_PICKAXE)
                .input(ModItems.SILVER_STICK)
                .input(ModItems.SILVER_PICKAXE_HEAD)
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_STICK))
                .criterion(hasItem(ModItems.SILVER_PICKAXE_HEAD), conditionsFromItem(ModItems.SILVER_PICKAXE_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.SILVER_PICKAXE) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_AXE)
                .input(ModItems.SILVER_STICK)
                .input(ModItems.SILVER_AXE_HEAD)
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_STICK))
                .criterion(hasItem(ModItems.SILVER_AXE_HEAD), conditionsFromItem(ModItems.SILVER_AXE_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.SILVER_AXE) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SILVER_SHOVEL)
                .input(ModItems.SILVER_STICK)
                .input(ModItems.SILVER_SHOVEL_HEAD)
                .criterion(hasItem(ModItems.SILVER_STICK), conditionsFromItem(ModItems.SILVER_STICK))
                .criterion(hasItem(ModItems.SILVER_SHOVEL_HEAD), conditionsFromItem(ModItems.SILVER_SHOVEL_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.SILVER_SHOVEL) + "_from_head");



        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_SWORD)
                .input(ModItems.BRONZE_STICK)
                .input(ModItems.BRONZE_SWORD_HEAD)
                .criterion(hasItem(ModItems.BRONZE_STICK), conditionsFromItem(ModItems.BRONZE_STICK))
                .criterion(hasItem(ModItems.BRONZE_SWORD_HEAD), conditionsFromItem(ModItems.BRONZE_SWORD_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.BRONZE_SWORD) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_HOE)
                .input(ModItems.BRONZE_STICK)
                .input(ModItems.BRONZE_HOE_HEAD)
                .criterion(hasItem(ModItems.BRONZE_STICK), conditionsFromItem(ModItems.BRONZE_STICK))
                .criterion(hasItem(ModItems.BRONZE_HOE_HEAD), conditionsFromItem(ModItems.BRONZE_HOE_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.BRONZE_HOE) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_PICKAXE)
                .input(ModItems.BRONZE_STICK)
                .input(ModItems.BRONZE_PICKAXE_HEAD)
                .criterion(hasItem(ModItems.BRONZE_STICK), conditionsFromItem(ModItems.BRONZE_STICK))
                .criterion(hasItem(ModItems.BRONZE_PICKAXE_HEAD), conditionsFromItem(ModItems.BRONZE_PICKAXE_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.BRONZE_PICKAXE) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_AXE)
                .input(ModItems.BRONZE_STICK)
                .input(ModItems.BRONZE_AXE_HEAD)
                .criterion(hasItem(ModItems.BRONZE_STICK), conditionsFromItem(ModItems.BRONZE_STICK))
                .criterion(hasItem(ModItems.BRONZE_AXE_HEAD), conditionsFromItem(ModItems.BRONZE_AXE_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.BRONZE_AXE) + "_from_head");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BRONZE_SHOVEL)
                .input(ModItems.BRONZE_STICK)
                .input(ModItems.BRONZE_SHOVEL_HEAD)
                .criterion(hasItem(ModItems.BRONZE_STICK), conditionsFromItem(ModItems.BRONZE_STICK))
                .criterion(hasItem(ModItems.BRONZE_SHOVEL_HEAD), conditionsFromItem(ModItems.BRONZE_SHOVEL_HEAD))
                .offerTo(recipeExporter, getRecipeName(ModItems.BRONZE_SHOVEL) + "_from_head");

    }

}