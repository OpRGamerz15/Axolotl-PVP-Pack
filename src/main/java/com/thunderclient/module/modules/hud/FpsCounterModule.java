package com.thunderclient.module.modules.hud;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class FpsCounterModule extends SimpleModule {
    public FpsCounterModule() {
        super("fps_counter", "FpsCounter", "HUD element for FpsCounter.", ModuleCategory.HUD, -1);
        setEnabled(true);
    }
}
