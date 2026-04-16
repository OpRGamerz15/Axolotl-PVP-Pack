package com.thunderclient.module.modules.hud;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class KeystrokesModule extends SimpleModule {
    public KeystrokesModule() {
        super("keystrokes", "Keystrokes", "HUD element for Keystrokes.", ModuleCategory.HUD, -1);
        setEnabled(true);
    }
}
