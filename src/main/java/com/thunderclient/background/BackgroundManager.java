package com.thunderclient.background;

public final class BackgroundManager {
    private BackgroundMode mode = BackgroundMode.ANIMATED_GRADIENT;

    public void initialize() {
        // Hook future shader/video pipeline here.
    }

    public void setMode(BackgroundMode mode) {
        this.mode = mode;
    }

    public BackgroundMode getMode() {
        return mode;
    }
}
