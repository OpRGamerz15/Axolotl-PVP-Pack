package com.thunderclient.module.modules.hud;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class PingDisplayModule extends SimpleModule {
    public PingDisplayModule() {
        super("ping_display", "PingDisplay", "HUD element for PingDisplay.", ModuleCategory.HUD, -1);
        setEnabled(true);
    }
}
