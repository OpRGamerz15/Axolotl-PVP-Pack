package com.thunderclient.module;

public abstract class Module {
    private final String id;
    private final String name;
    private final String description;
    private final ModuleCategory category;
    private int keyCode;
    private boolean enabled;

    protected Module(String id, String name, String description, ModuleCategory category, int keyCode) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.keyCode = keyCode;
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void setEnabled(boolean enabled) {
        if (this.enabled == enabled) {
            return;
        }
        this.enabled = enabled;
        if (enabled) onEnable(); else onDisable();
    }

    protected void onEnable() {}
    protected void onDisable() {}

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public ModuleCategory getCategory() { return category; }
    public int getKeyCode() { return keyCode; }
    public void setKeyCode(int keyCode) { this.keyCode = keyCode; }
    public boolean isEnabled() { return enabled; }
}
