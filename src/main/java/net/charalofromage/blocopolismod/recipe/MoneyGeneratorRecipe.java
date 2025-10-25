package net.charalofromage.blocopolismod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record MoneyGeneratorRecipe(Ingredient inputItem, int output) implements Recipe<MoneyGeneratorRecipeInput> {

    private static final int INPUT_SLOT = 0;

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(MoneyGeneratorRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }
        return inputItem.test(input.getStackInSlot(INPUT_SLOT));
    }

    @Override
    public ItemStack craft(MoneyGeneratorRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        // Plus de ItemStack réel, on retourne juste un ItemStack vide
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        // Plus de ItemStack réel
        return ItemStack.EMPTY;
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
                Codec.INT.fieldOf("result").forGetter(MoneyGeneratorRecipe::output)
        ).apply(inst, MoneyGeneratorRecipe::new));

        public static final PacketCodec<RegistryByteBuf, Integer> INT_CODEC =
                new PacketCodec<RegistryByteBuf, Integer>() {
                    @Override
                    public void encode(RegistryByteBuf buf, Integer value) {
                        buf.writeInt(value);
                    }

                    @Override
                    public Integer decode(RegistryByteBuf buf) {
                        return buf.readInt();
                    }
                };

        public static final PacketCodec<RegistryByteBuf, MoneyGeneratorRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, MoneyGeneratorRecipe::inputItem,
                        INT_CODEC, MoneyGeneratorRecipe::output,
                        MoneyGeneratorRecipe::new
                );

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