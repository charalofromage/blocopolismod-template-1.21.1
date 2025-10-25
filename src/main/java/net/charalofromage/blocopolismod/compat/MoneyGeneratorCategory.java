package net.charalofromage.blocopolismod.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.charalofromage.blocopolismod.BlocopolisMod;
import net.charalofromage.blocopolismod.block.ModBlocks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.LinkedList;
import java.util.List;

public class MoneyGeneratorCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE = Identifier.of(BlocopolisMod.MOD_ID,
            "textures/gui/money_generator/money_generator_without_inventory_gui.png");

    public static final CategoryIdentifier<MoneyGeneratorDisplay> MONEY_GENERATOR =
            CategoryIdentifier.of(BlocopolisMod.MOD_ID, "money_generator");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return MONEY_GENERATOR;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.blocopolismod.money_generator");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.MONEY_GENERATOR.asItem().getDefaultStack());
    }

    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 88, bounds.getCenterY() - 83); // moitié de 176 et 166
        List<Widget> widgets = new LinkedList<>();

        // Fond complet (176x166)
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 176, 166)));


        // Slot de lingot
        //widgets.add(Widgets.createSlot(new Point(6, 4)).entries(display.getInputEntries().get(0)).markInput());


        // Slot entrée (item à fondre)
        widgets.add(Widgets.createSlot(new Point(24, 35))
                .entries(display.getInputEntries().get(0))
                .markOutput());


        // Slot du paterne
        //widgets.add(Widgets.createSlot(new Point(24, 91)).entries(display.getInputEntries().get(2)).markOutput());


        // Output
        //widgets.add(Widgets.createSlot(new Point(24, 117)).entries(display.getOutputEntries().get(0)).markOutput());

        return widgets;
    }

    @Override
    public int getDisplayHeight() {
        return 166;
    }
}
