package com.thunderclient.mixin;

import com.thunderclient.ThunderClient;
import com.thunderclient.background.BackgroundMode;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin {
    @Inject(method = "render", at = @At("TAIL"))
    private void thunderclient$renderBranding(DrawContext context, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        BackgroundMode mode = ThunderClient.get().getBackgroundManager().getMode();
        context.drawTextWithShadow(
                net.minecraft.client.MinecraftClient.getInstance().textRenderer,
                "Thunder Client • " + mode.name(),
                8,
                8,
                0xFF7CC8FF
        );
    }
}
