package com.thunderclient.module.modules.performance;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;
import org.lwjgl.glfw.GLFW;

public final class FpsBoostModule extends SimpleModule {
    public FpsBoostModule() {
        super("fps_boost", "FPS Boost", "Global rendering and memory optimizations.", ModuleCategory.PERFORMANCE, GLFW.GLFW_KEY_F6);
        setEnabled(true);
    }
}
