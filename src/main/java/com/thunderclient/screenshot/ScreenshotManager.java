package com.thunderclient.screenshot;

import net.minecraft.client.MinecraftClient;

import java.nio.file.Path;

public final class ScreenshotManager {
    public Path screenshotDirectory() {
        return MinecraftClient.getInstance().runDirectory.toPath().resolve("screenshots");
    }
}
