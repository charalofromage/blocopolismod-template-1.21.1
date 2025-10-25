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
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record MoneyGeneratorCraftRecipe(int quantity_required, Ingredient ingot, Ingredient pattern, ItemStack output) implements Recipe<MoneyGeneratorCraftRecipeInput> {

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;
    private static final int LAVA_SLOT = 2;
    private static final int INGOT_SLOT = 3;
    private static final int PATTERN_SLOT = 4;

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.ingot);
        list.add(this.pattern);
        return list;
    }

    @Override
    public boolean matches(MoneyGeneratorCraftRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }
        return ingot.test(input.getStackInSlot(INGOT_SLOT)) && pattern.test(input.getStackInSlot(PATTERN_SLOT));
    }

    @Override
    public ItemStack craft(MoneyGeneratorCraftRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        // Plus de ItemStack réel
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.MONEY_GENERATOR_CRAFT_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.MONEY_GENERATOR_CRAFT_TYPE;
    }

    public static class Serializer implements RecipeSerializer<MoneyGeneratorCraftRecipe> {

        public static final MapCodec<MoneyGeneratorCraftRecipe> CODEC =
                RecordCodecBuilder.mapCodec(inst -> inst.group(
                        Codec.INT.fieldOf("quantity_required").forGetter(MoneyGeneratorCraftRecipe::quantity_required),
                        Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingot").forGetter(MoneyGeneratorCraftRecipe::ingot),
                        Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("pattern").forGetter(MoneyGeneratorCraftRecipe::pattern),
                        ItemStack.CODEC.fieldOf("result").forGetter(MoneyGeneratorCraftRecipe::output)
                ).apply(inst, MoneyGeneratorCraftRecipe::new));

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

        public static final PacketCodec<RegistryByteBuf, MoneyGeneratorCraftRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        INT_CODEC, MoneyGeneratorCraftRecipe::quantity_required,
                        Ingredient.PACKET_CODEC, MoneyGeneratorCraftRecipe::ingot,
                        Ingredient.PACKET_CODEC, MoneyGeneratorCraftRecipe::pattern,
                        ItemStack.PACKET_CODEC, MoneyGeneratorCraftRecipe::output,
                        MoneyGeneratorCraftRecipe::new
                );

        @Override
        public MapCodec<MoneyGeneratorCraftRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, MoneyGeneratorCraftRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}