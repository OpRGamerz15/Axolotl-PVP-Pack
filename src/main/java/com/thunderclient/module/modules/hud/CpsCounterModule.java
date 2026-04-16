package com.thunderclient.module.modules.hud;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class CpsCounterModule extends SimpleModule {
    public CpsCounterModule() {
        super("cps_counter", "CpsCounter", "HUD element for CpsCounter.", ModuleCategory.HUD, -1);
        setEnabled(true);
    }
}
