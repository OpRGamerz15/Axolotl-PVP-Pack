package com.thunderclient.module.modules.utility;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class ToggleSneakModule extends SimpleModule {
    public ToggleSneakModule() {
        super("toggle_sneak", "Toggle Sneak", "Persistent sneak state.", ModuleCategory.PVP_ENHANCEMENTS, -1);
    }
}
