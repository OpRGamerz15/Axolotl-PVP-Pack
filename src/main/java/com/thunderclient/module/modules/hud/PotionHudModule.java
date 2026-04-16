package com.thunderclient.module.modules.hud;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class PotionHudModule extends SimpleModule {
    public PotionHudModule() {
        super("potion_hud", "PotionHud", "HUD element for PotionHud.", ModuleCategory.HUD, -1);
        setEnabled(true);
    }
}
