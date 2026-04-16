package com.thunderclient.module;

public final class GenericModule extends SimpleModule {
    public GenericModule(String id, String name, String description, ModuleCategory category, int keyCode, boolean enabledByDefault) {
        super(id, name, description, category, keyCode);
        if (enabledByDefault) {
            setEnabled(true);
        }
    }
}
