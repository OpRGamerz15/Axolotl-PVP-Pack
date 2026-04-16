package com.thunderclient.cosmetics.engine;

import com.thunderclient.cosmetics.cape.CapeManager;
import com.thunderclient.cosmetics.skin.SkinManager;

public final class CosmeticsManager {
    private boolean globalEnabled = true;
    private final SkinManager skinManager = new SkinManager();
    private final CapeManager capeManager = new CapeManager();

    public void initialize() {
        skinManager.loadSavedSkins();
        capeManager.loadSavedCapes();
    }

    public boolean isGlobalEnabled() {
        return globalEnabled;
    }

    public void setGlobalEnabled(boolean globalEnabled) {
        this.globalEnabled = globalEnabled;
    }

    public SkinManager skinManager() { return skinManager; }
    public CapeManager capeManager() { return capeManager; }
}
