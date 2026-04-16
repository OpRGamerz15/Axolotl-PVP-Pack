package com.thunderclient.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.thunderclient.ThunderClient;
import com.thunderclient.manager.KeybindManager;
import com.thunderclient.manager.ModuleManager;
import com.thunderclient.module.Module;
import net.minecraft.client.MinecraftClient;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public final class ConfigManager {
    private static final Type PROFILE_TYPE = new TypeToken<Map<String, ModuleState>>() {}.getType();

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final ModuleManager moduleManager;
    private final KeybindManager keybindManager;

    public ConfigManager(ModuleManager moduleManager, KeybindManager keybindManager) {
        this.moduleManager = moduleManager;
        this.keybindManager = keybindManager;
    }

    public void saveProfile(String profileName) {
        Map<String, ModuleState> data = new HashMap<>();
        for (Module module : moduleManager.getModules()) {
            data.put(module.getId(), new ModuleState(module.isEnabled(), module.getKeyCode()));
        }

        Path file = profilePath(profileName);
        try {
            Files.createDirectories(file.getParent());
            Files.writeString(file, gson.toJson(data));
        } catch (IOException ex) {
            ThunderClient.LOGGER.error("Failed to save profile {}", profileName, ex);
        }
    }

    public void loadProfile(String profileName) {
        Path file = profilePath(profileName);
        if (!Files.exists(file)) {
            saveProfile(profileName);
            return;
        }

        try {
            Map<String, ModuleState> data = gson.fromJson(Files.readString(file), PROFILE_TYPE);
            if (data == null) return;
            for (Map.Entry<String, ModuleState> entry : data.entrySet()) {
                moduleManager.byId(entry.getKey()).ifPresent(module -> {
                    module.setEnabled(entry.getValue().enabled());
                    module.setKeyCode(entry.getValue().keyCode());
                });
            }
        } catch (IOException ex) {
            ThunderClient.LOGGER.error("Failed to load profile {}", profileName, ex);
        }
    }

    private Path profilePath(String name) {
        return MinecraftClient.getInstance().runDirectory.toPath()
                .resolve("config")
                .resolve("thunderclient")
                .resolve(name + ".json");
    }

    private record ModuleState(boolean enabled, int keyCode) {}
}
