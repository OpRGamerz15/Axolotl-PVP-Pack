package com.thunderclient.manager;

import com.thunderclient.module.Module;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

import java.util.HashMap;
import java.util.Map;

public final class KeybindManager {
    private final ModuleManager moduleManager;
    private final Map<String, KeyBinding> bindings = new HashMap<>();

    public KeybindManager(ModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    public void register() {
        moduleManager.getModules().forEach(module -> {
            if (module.getKeyCode() < 0) return;
            KeyBinding key = new KeyBinding(
                    "key.thunderclient." + module.getId(),
                    InputUtil.Type.KEYSYM,
                    module.getKeyCode(),
                    "category.thunderclient"
            );
            KeyBindingHelper.registerKeyBinding(key);
            bindings.put(module.getId(), key);
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            for (Module module : moduleManager.getModules()) {
                KeyBinding key = bindings.get(module.getId());
                if (key == null) continue;
                while (key.wasPressed()) module.toggle();
            }
        });
    }

    public Map<String, Integer> snapshot() {
        Map<String, Integer> out = new HashMap<>();
        moduleManager.getModules().forEach(module -> out.put(module.getId(), module.getKeyCode()));
        return out;
    }
}
