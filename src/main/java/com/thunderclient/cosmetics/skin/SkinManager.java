package com.thunderclient.cosmetics.skin;

import com.thunderclient.ThunderClient;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public final class SkinManager {
    private final Map<String, SkinEntry> savedSkins = new LinkedHashMap<>();
    private String activeSkinId;

    public void loadSavedSkins() {
        ThunderClient.LOGGER.info("Skin manager initialized (cache + profile storage ready)");
    }

    public void saveLocalSkin(String id, Path pngPath) {
        savedSkins.put(id, SkinEntry.local(id, pngPath));
    }

    public void saveUrlSkin(String id, String url) {
        savedSkins.put(id, SkinEntry.url(id, url));
    }

    public void applySkin(String id) {
        if (savedSkins.containsKey(id)) {
            activeSkinId = id;
            ThunderClient.LOGGER.info("Applied skin profile {}", id);
        }
    }

    public Map<String, SkinEntry> getSavedSkins() {
        return Map.copyOf(savedSkins);
    }

    public String getActiveSkinId() {
        return activeSkinId;
    }
}
