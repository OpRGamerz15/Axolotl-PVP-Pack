package com.thunderclient.performance;

import java.util.Arrays;

/**
 * Very small ring-buffer monitor used by performance modules to evaluate
 * smoothness statistics without allocations each tick.
 */
public final class FrameTimeMonitor {
    private final long[] samples;
    private int index;
    private boolean filled;
    private long lastNanos;

    public FrameTimeMonitor(int sampleSize) {
        this.samples = new long[sampleSize];
    }

    public void pushFrameNanos(long nowNanos) {
        if (lastNanos != 0) {
            samples[index] = nowNanos - lastNanos;
            index = (index + 1) % samples.length;
            if (index == 0) {
                filled = true;
            }
        }
        lastNanos = nowNanos;
    }

    public double getAverageMs() {
        int size = filled ? samples.length : index;
        if (size == 0) return 0;

        long total = 0;
        for (int i = 0; i < size; i++) total += samples[i];
        return total / 1_000_000.0 / size;
    }

    public double getP95Ms() {
        int size = filled ? samples.length : index;
        if (size == 0) return 0;

        long[] copy = Arrays.copyOf(samples, size);
        Arrays.sort(copy);
        int i = Math.min(size - 1, (int) Math.floor(size * 0.95));
        return copy[i] / 1_000_000.0;
    }
}
