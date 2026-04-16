package com.thunderclient.module.modules.hud;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class ArmorStatusModule extends SimpleModule {
    public ArmorStatusModule() {
        super("armor_status", "ArmorStatus", "HUD element for ArmorStatus.", ModuleCategory.HUD, -1);
        setEnabled(true);
    }
}
