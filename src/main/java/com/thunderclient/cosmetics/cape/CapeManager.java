package com.thunderclient.cosmetics.cape;

import com.thunderclient.ThunderClient;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;

public final class CapeManager {
    private final Map<String, CapeProfile> savedCapes = new LinkedHashMap<>();
    private String activeCape;
    private boolean enabled = true;

    public void loadSavedCapes() {
        ThunderClient.LOGGER.info("Cape manager initialized");
    }

    public void saveCapeFromFile(String id, Path path) {
        savedCapes.put(id, new CapeProfile(id, CapeSource.LOCAL_FILE, path.toString()));
    }

    public void saveCapeFromUrl(String id, String url) {
        savedCapes.put(id, new CapeProfile(id, CapeSource.URL, url));
    }

    public void apply(String id) {
        if (savedCapes.containsKey(id)) activeCape = id;
    }

    public Map<String, CapeProfile> getSavedCapes() { return Map.copyOf(savedCapes); }
    public String getActiveCape() { return activeCape; }
    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
