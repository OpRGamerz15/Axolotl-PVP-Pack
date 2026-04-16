package com.thunderclient.module.modules.render;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;
import org.lwjgl.glfw.GLFW;

public final class ZoomModule extends SimpleModule {
    public ZoomModule() {
        super("zoom", "Zoom", "Smooth adjustable zoom.", ModuleCategory.RENDER, GLFW.GLFW_KEY_C);
    }
}
