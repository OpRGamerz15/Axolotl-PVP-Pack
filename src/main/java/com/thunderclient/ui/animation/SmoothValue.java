package com.thunderclient.ui.animation;

/**
 * Critically damped smoothing value used for premium-feel UI transitions.
 */
public final class SmoothValue {
    private float value;

    public SmoothValue(float initial) {
        this.value = initial;
    }

    public float update(float target, float deltaSeconds, float responsiveness) {
        float alpha = 1.0f - (float) Math.exp(-responsiveness * deltaSeconds);
        value += (target - value) * alpha;
        return value;
    }

    public float get() {
        return value;
    }
}
