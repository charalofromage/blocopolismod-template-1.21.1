package net.charalofromage.blocopolismod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.charalofromage.blocopolismod.BlocopolisMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MoneyGeneratorScreen extends HandledScreen<MoneyGeneratorScreenHandler> {

    private static final Identifier GUI_TEXTURE =
            Identifier.of(BlocopolisMod.MOD_ID, "textures/gui/money_generator/money_generator_gui.png");

    private static final Identifier ARROW_TEXTURE1 =
            Identifier.of(BlocopolisMod.MOD_ID, "textures/gui/money_generator/arrow_1_gui.png");

    private static final Identifier ARROW_TEXTURE2 =
            Identifier.of(BlocopolisMod.MOD_ID, "textures/gui/money_generator/arrow_2_gui.png");

    private static final Identifier SILVER_BARRE =
            Identifier.of(BlocopolisMod.MOD_ID, "textures/gui/money_generator/silver_barre_gui.png");


    private static final Identifier BRONZE_BARRE =
            Identifier.of(BlocopolisMod.MOD_ID, "textures/gui/money_generator/bronze_barre_gui.png");


    public MoneyGeneratorScreen(MoneyGeneratorScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        this.backgroundWidth = 176;
        this.backgroundHeight = 274;


    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, backgroundWidth, backgroundHeight);

        renderProgressArrow(context, x, y);
        renderSecondProgressArrow(context, x, y);
        renderSilverBarreProgress(context, x, y);
        renderBronzeBarreProgress(context, x, y);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        // Le titre du coffre
        context.drawText(this.textRenderer, this.title, 8, 6, 4210752, false);

        // Le texte "Inventory"
        context.drawText(this.textRenderer, this.playerInventoryTitle, 8, 182, 4210752, false);

        //Le Volume d'Argent
        int silverQuantityStocked = handler.getPropertyDelegate().get(2);
        context.drawText(this.textRenderer, ( silverQuantityStocked/100.000) + "m³" , 134, 43, 12632256, false);

        //Le Volume de Bronze
        int bronzeQuantityStocked = handler.getPropertyDelegate().get(6);
        context.drawText(this.textRenderer, ( bronzeQuantityStocked/100.000) + "m³" , 134, 138, 9464378, false);

        //Le Volume de lave
        int lavaVolume = handler.getPropertyDelegate().get(3);
        context.drawText(this.textRenderer, lavaVolume + "L" , 144, 170, 16753920, false);
    }

    private void renderProgressArrow(DrawContext context, int x, int y){
        if (handler.isSmelting()){
            context.drawTexture(ARROW_TEXTURE1, x + 45, y + 56, 0, 0,
                    handler.getScaleArrowProgress(), 12, 78, 12);
        }
    }

    private void renderSecondProgressArrow(DrawContext context, int x, int y){
        if (handler.isCrafting()){

            int progressWidth = handler.getScaleSecondArrowProgress();
            int totalWidth = 78;
            int arrowHeight = 12;

            // Décaler le point d'affichage pour partir de la droite
            int drawX = x + 45 + (totalWidth - progressWidth);

            // Décaler la lecture dans la texture pour ne prendre que la partie droite

            int u = totalWidth - progressWidth;
            context.drawTexture(ARROW_TEXTURE2, drawX, y + 119, u, 0,
                    progressWidth, arrowHeight, totalWidth, arrowHeight);
        }
    }

    private void renderSilverBarreProgress(DrawContext context, int x, int y) {

            int progress = handler.getScaleSilverBarreProgress(); // hauteur de remplissage actuelle
            int totalHeight = 81; // hauteur max de ta texture (à adapter)

            // Calcule la position de départ (part du bas)
            int offsetY = totalHeight - progress;

            // Dessine seulement la partie visible, à partir du bas
            context.drawTexture(
                    SILVER_BARRE,
                    x + 133,                // position X sur ton GUI
                    y + 53 + offsetY,          // position Y ajustée (pour que ça monte)
                    0,                         // U (dans ta texture)
                    offsetY,                   // V (on "décale" pour ne dessiner que la partie visible)
                    17,                        // largeur
                    progress,                  // hauteur dessinée
                    17,                        // largeur texture totale
                    81                         // hauteur texture totale
            );
        }


    private void renderBronzeBarreProgress(DrawContext context, int x, int y) {

            int progress = handler.getScaleBronzeBarreProgress(); // hauteur de remplissage actuelle
            int totalHeight = 81; // hauteur max de ta texture (à adapter)

            // Calcule la position de départ (part du bas)
            int offsetY = totalHeight - progress;

            // Dessine seulement la partie visible, à partir du bas
            context.drawTexture(
                    BRONZE_BARRE,
                    x + 153,                // position X sur ton GUI
                    y + 53 + offsetY,          // position Y ajustée (pour que ça monte)
                    0,                         // U (dans ta texture)
                    offsetY,                   // V (on "décale" pour ne dessiner que la partie visible)
                    17,                        // largeur
                    progress,                  // hauteur dessinée
                    17,                        // largeur texture totale
                    81                         // hauteur texture totale
            );
        }



    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
