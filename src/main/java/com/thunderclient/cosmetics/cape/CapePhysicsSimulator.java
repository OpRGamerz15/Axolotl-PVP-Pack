package com.thunderclient.cosmetics.cape;

public final class CapePhysicsSimulator {
    private float sway;

    public void tick(float velocity, boolean onGround) {
        float target = onGround ? velocity * 0.6f : velocity;
        sway += (target - sway) * 0.18f;
    }

    public float getSway() {
        return sway;
    }
}
