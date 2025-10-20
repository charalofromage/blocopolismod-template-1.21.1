package net.charalofromage.blocopolismod.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.charalofromage.blocopolismod.BlocopolisMod;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SilverChestScreen extends HandledScreen<SilverChestScreenHandler> {

    public static final Identifier GUI_TEXTURE =
            Identifier.of(BlocopolisMod.MOD_ID, "textures/gui/silver_chest/silver_chest_gui.png");

    public SilverChestScreen(SilverChestScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }


    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1f, 1f, 1f, 1f);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (width - 338) / 2;
        int y = (height - 328) / 2;

        context.drawTexture(GUI_TEXTURE, x, y, 0, 0, 338, 328, 512, 512);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
