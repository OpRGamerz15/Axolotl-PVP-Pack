package com.thunderclient.ui.hud;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public final class HudEditorScreen extends Screen {
    public HudEditorScreen() {
        super(Text.literal("HUD Editor"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(textRenderer, "Drag & drop HUD components here", width / 2, height / 2, 0xFFFFFFFF);
        super.render(context, mouseX, mouseY, delta);
    }
}
