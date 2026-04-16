package com.thunderclient.ui.click;

import com.thunderclient.ui.animation.SmoothValue;
import com.thunderclient.ui.theme.ThunderTheme;
import com.thunderclient.util.Easing;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public final class ClickGuiScreen extends Screen {
    private final ThunderTheme theme = ThunderTheme.defaultTheme();
    private final SmoothValue panelScale = new SmoothValue(0.94f);
    private final SmoothValue glowAlpha = new SmoothValue(0f);
    private float life;

    public ClickGuiScreen() {
        super(Text.literal("Thunder Client"));
    }

    @Override
    protected void init() {
        life = 0f;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        float deltaSeconds = Math.max(0.0001f, delta / 20f);
        life += deltaSeconds;

        float appear = Easing.easeOutCubic(Math.min(1f, life * 2.8f));
        float pulse = 0.5f + 0.5f * (float) Math.sin(life * 1.4f);

        float scale = panelScale.update(1.0f, deltaSeconds, 14f) * (0.95f + appear * 0.05f);
        int glow = (int) (glowAlpha.update(0.65f + pulse * 0.35f, deltaSeconds, 8f) * 255f);

        this.renderBackground(context, mouseX, mouseY, delta);

        int panelW = (int) (360 * scale);
        int panelH = (int) (232 * scale);
        int panelX = width / 2 - panelW / 2;
        int panelY = height / 2 - panelH / 2;

        // Layered shadow
        context.fill(panelX - 10, panelY - 6, panelX + panelW + 10, panelY + panelH + 14, (glow << 24));
        context.fill(panelX - 3, panelY - 2, panelX + panelW + 3, panelY + panelH + 4, theme.shadowColor());

        // Gradient panel fill
        context.fillGradient(panelX, panelY, panelX + panelW, panelY + panelH, 0xDD141822, 0xDD10141D);

        // Header bar
        context.fillGradient(panelX, panelY, panelX + panelW, panelY + 26, theme.primaryColor(), theme.secondaryColor());

        int subtitleAlpha = (int) (Easing.easeInOutSine(appear) * 255) & 0xFF;
        context.drawTextWithShadow(textRenderer, "Thunder Client", panelX + 12, panelY + 8, 0xFFFFFFFF);
        context.drawTextWithShadow(textRenderer, "High-performance legit PvP client", panelX + 12, panelY + 34, (subtitleAlpha << 24) | 0x00D7E8FF);

        // Premium hover card
        boolean hovered = mouseX >= panelX + 12 && mouseX <= panelX + panelW - 12 && mouseY >= panelY + 54 && mouseY <= panelY + 100;
        int cardColor = hovered ? 0xAA263247 : 0x88202838;
        context.fill(panelX + 12, panelY + 54, panelX + panelW - 12, panelY + 100, cardColor);
        context.drawTextWithShadow(textRenderer, hovered ? "Animations: ultra-smooth" : "Animations: smooth", panelX + 20, panelY + 68, 0xFFEAF3FF);
        context.drawTextWithShadow(textRenderer, "Modules loaded: premium profile", panelX + 20, panelY + 82, 0xFFAFC7E9);

        super.render(context, mouseX, mouseY, delta);
    }
}
