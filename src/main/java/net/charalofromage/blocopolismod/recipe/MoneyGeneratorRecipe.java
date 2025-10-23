package net.charalofromage.blocopolismod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.component.ComponentChanges;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.World;

import static net.minecraft.item.ItemStack.ITEM_CODEC;

public record MoneyGeneratorRecipe(Ingredient inputItem, ItemStack output) implements Recipe<MoneyGeneratorRecipeInput> {

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int LAVA_SLOT = 2;
    private static final int INGREDIENT_TYPE_SLOT = 3;
    private static final int OUTPUT_TYPE_SLOT = 4;

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    // read Recipe JSON files --> new GrowthChamberRecipe

    @Override
    public boolean matches(MoneyGeneratorRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(MoneyGeneratorRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.MONEY_GENERATOR_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.MONEY_GENERATOR_TYPE;
    }

    public static class Serializer implements RecipeSerializer<MoneyGeneratorRecipe> {
        public static final MapCodec<MoneyGeneratorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(MoneyGeneratorRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(MoneyGeneratorRecipe::output)
        ).apply(inst, MoneyGeneratorRecipe::new));

        public static final PacketCodec<RegistryByteBuf, MoneyGeneratorRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, MoneyGeneratorRecipe::inputItem,
                        ItemStack.PACKET_CODEC, MoneyGeneratorRecipe::output,
                        MoneyGeneratorRecipe::new);

        @Override
        public MapCodec<MoneyGeneratorRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, MoneyGeneratorRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}

