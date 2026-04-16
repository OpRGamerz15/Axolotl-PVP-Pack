package com.thunderclient.util;

public final class Easing {
    private Easing() {}

    public static float clamp01(float v) {
        return Math.max(0f, Math.min(1f, v));
    }

    public static float easeOutCubic(float t) {
        float x = clamp01(t) - 1f;
        return x * x * x + 1f;
    }

    public static float easeInOutSine(float t) {
        return (float) (-(Math.cos(Math.PI * clamp01(t)) - 1f) / 2f);
    }
}
