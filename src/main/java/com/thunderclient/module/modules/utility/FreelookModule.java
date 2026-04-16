package com.thunderclient.module.modules.utility;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;
import org.lwjgl.glfw.GLFW;

public final class FreelookModule extends SimpleModule {
    public FreelookModule() {
        super("freelook", "Freelook", "Look around without changing movement direction.", ModuleCategory.UTILITY, GLFW.GLFW_KEY_LEFT_ALT);
    }
}
