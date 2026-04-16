package com.thunderclient.module.modules.utility;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class ToggleSprintModule extends SimpleModule {
    public ToggleSprintModule() {
        super("toggle_sprint", "Toggle Sprint", "Persistent sprint state.", ModuleCategory.PVP_ENHANCEMENTS, -1);
    }
}
