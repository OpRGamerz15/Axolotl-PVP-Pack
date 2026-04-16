package com.thunderclient.ui.font;

import net.minecraft.client.font.TextRenderer;

public final class FontService {
    private final TextRenderer fallbackRenderer;

    public FontService(TextRenderer fallbackRenderer) {
        this.fallbackRenderer = fallbackRenderer;
    }

    public TextRenderer renderer() {
        return fallbackRenderer;
    }
}
