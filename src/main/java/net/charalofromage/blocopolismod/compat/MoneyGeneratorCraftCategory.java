package net.charalofromage.blocopolismod.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.charalofromage.blocopolismod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class MoneyGeneratorCraftCategory implements DisplayCategory<MoneyGeneratorCraftDisplay> {

    private Item[] bronze =
            {ModItems.BRONZE_INGOT, ModItems.BRONZE_NUGGET, ModItems.BRONZE_CHESTPLATE, ModItems.BRONZE_BOOTS,
                    ModItems.BRONZE_LEGGINGS, ModItems.BRONZE_HELMET, ModItems.BRONZE_AXE_HEAD, ModItems.BRONZE_COIN,
                    ModItems.BRONZE_HOE_HEAD, ModItems.BRONZE_PICKAXE_HEAD, ModItems.BRONZE_SHOVEL_HEAD, ModItems.BRONZE_SWORD_HEAD,

                    ModBlocks.BRONZE_BLOCK.asItem(), ModBlocks.BRONZE_SLAB.asItem(), ModBlocks.BRONZE_STAIRS.asItem(),
                    ModBlocks.BRONZE_WALL.asItem(), ModBlocks.BRONZE_FENCE.asItem(), ModBlocks.BRONZE_FENCE_GATE.asItem(),
                    ModBlocks.BRONZE_DOOR.asItem(), ModBlocks.BRONZE_TRAPDOOR.asItem() };

    public static final Identifier TEXTURE = Identifier.of(
            BlocopolisMod.MOD_ID,
            "textures/gui/money_generator/money_generator_without_inventory_gui.png"
    );

    public static final CategoryIdentifier<MoneyGeneratorCraftDisplay> MONEY_GENERATOR_CRAFT =
            CategoryIdentifier.of(BlocopolisMod.MOD_ID, "money_generator_craft");

    @Override
    public CategoryIdentifier<? extends MoneyGeneratorCraftDisplay> getCategoryIdentifier() {
        return MONEY_GENERATOR_CRAFT;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.blocopolismod.money_generator");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.MONEY_GENERATOR);
    }

    @Override
    public List<Widget> setupDisplay(MoneyGeneratorCraftDisplay display, Rectangle bounds) {
        List<Widget> widgets = new LinkedList<>();
        Point start = new Point(bounds.getCenterX() - 88, bounds.getCenterY() - 83); // centré

        // Fond
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(start.x, start.y, 176, 166)));

        // Slot de sortie
        widgets.add(Widgets.createSlot(
                        new Point(start.x + 25, start.y + 107))
                .entries(display.getOutputEntries().get(0))
                .markInput()
        );

        // Slot du lingot
        widgets.add(Widgets.createSlot(
                        new Point(start.x + 7, start.y + 5))
                .entries(display.getInputEntries().get(0))
                .markInput()
        );

        // Slot du pattern
        widgets.add(Widgets.createSlot(
                        new Point(start.x + 25, start.y + 89))
                .entries(display.getInputEntries().get(1))
                .markInput()
        );

        for (int i = 0; i < bronze.length; i++) {
            if (display.getOutputItem() == bronze[i]) {
                // Affichage de la valeur d'entrée
                widgets.add(Widgets.createLabel(
                        new Point(start.x + 133, start.y + 119),
                        Text.literal("-" + display.getInputValue() / 1000f + " m³")
                ).leftAligned().color(0x906C3A, 0x906C3A));

                return widgets;
            }
        }

        widgets.add(Widgets.createLabel(
                new Point(start.x + 133, start.y + 24),
                Text.literal("-" + display.getInputValue() / 1000f + " m³")
        ).leftAligned().color(0xC0C0C0, 0xC0C0C0));


        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 166;
    }
}
