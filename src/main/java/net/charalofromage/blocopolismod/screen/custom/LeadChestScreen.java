package net.charalofromage.blocopolismod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.charalofromage.blocopolismod.BlocopolisMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class LeadChestScreen extends HandledScreen<LeadChestScreenHandler> {


    public static final Identifier GUI_TEXTURE =
            Identifier.of(BlocopolisMod.MOD_ID, "textures/gui/lead_chest/lead_chest_gui.png");

    public LeadChestScreen(LeadChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);

        this.backgroundWidth = 176;
        this.backgroundHeight = 328;
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, backgroundWidth, backgroundHeight);
    }

    @Override
    protected void drawForeground(DrawContext context, int mouseX, int mouseY) {
        // Le titre du coffre
        context.drawText(this.textRenderer, this.title, 8, 6, 4210752, false);

        // Le texte "Inventory"
        context.drawText(this.textRenderer, this.playerInventoryTitle, 8, this.backgroundHeight - 94, 4210752, false);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
