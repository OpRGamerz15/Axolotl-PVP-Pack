package com.thunderclient.performance;

import com.thunderclient.ThunderClient;
import com.thunderclient.manager.ModuleManager;
import com.thunderclient.module.ModuleCategory;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

/**
 * Central runtime optimization coordinator for Thunder Client.
 *
 * This is intentionally mod-side (Fabric client mod), not a web/runtime layer.
 */
public final class PerformanceOrchestrator {
    private long tick;
    private long lastMemoryCheckMs;
    private final FrameTimeMonitor frameTimeMonitor = new FrameTimeMonitor(120);

    public void initialize(ModuleManager modules) {
        ClientTickEvents.END_CLIENT_TICK.register(this::onTick);
        ThunderClient.LOGGER.info("Performance orchestrator active with {} performance modules",
                modules.getCategoryCounts().getOrDefault(ModuleCategory.PERFORMANCE, 0L));
    }

    private void onTick(MinecraftClient client) {
        tick++;

        frameTimeMonitor.pushFrameNanos(System.nanoTime());

        long now = System.currentTimeMillis();
        if (now - lastMemoryCheckMs >= 5000L) {
            lastMemoryCheckMs = now;
            applyMemoryPressureMitigation(client);
        }

        // Every second: log heavy stutter summary in debug logs for profiling.
        if (tick % 20 == 0 && frameTimeMonitor.getP95Ms() > 20.0) {
            ThunderClient.LOGGER.debug("Frame pacing warning (p95={}ms, avg={}ms)",
                    String.format("%.2f", frameTimeMonitor.getP95Ms()),
                    String.format("%.2f", frameTimeMonitor.getAverageMs()));
        }
    }

    private void applyMemoryPressureMitigation(MinecraftClient client) {
        long usedMb = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024);
        if (usedMb > 1536) {
            client.particleManager.clear();
            ThunderClient.LOGGER.debug("Memory guard cleared particles at {}MB usage", usedMb);
        }
    }
}
