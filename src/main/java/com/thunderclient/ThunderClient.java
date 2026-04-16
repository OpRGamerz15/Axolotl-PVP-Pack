package com.thunderclient;

import com.thunderclient.background.BackgroundManager;
import com.thunderclient.config.ConfigManager;
import com.thunderclient.cosmetics.engine.CosmeticsManager;
import com.thunderclient.discord.DiscordRpcManager;
import com.thunderclient.event.EventBus;
import com.thunderclient.loading.LoadingOverlayController;
import com.thunderclient.manager.KeybindManager;
import com.thunderclient.manager.ModuleManager;
import com.thunderclient.performance.PerformanceOrchestrator;
import com.thunderclient.screenshot.ScreenshotManager;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ThunderClient implements ClientModInitializer {
    public static final String MOD_ID = "thunderclient";
    public static final Logger LOGGER = LoggerFactory.getLogger("ThunderClient");

    private static ThunderClient instance;

    private EventBus eventBus;
    private ModuleManager moduleManager;
    private KeybindManager keybindManager;
    private ConfigManager configManager;
    private CosmeticsManager cosmeticsManager;
    private BackgroundManager backgroundManager;
    private DiscordRpcManager discordRpcManager;
    private ScreenshotManager screenshotManager;
    private LoadingOverlayController loadingOverlayController;
    private PerformanceOrchestrator performanceOrchestrator;

    @Override
    public void onInitializeClient() {
        instance = this;
        this.eventBus = new EventBus();
        this.moduleManager = new ModuleManager(eventBus);
        this.keybindManager = new KeybindManager(moduleManager);
        this.configManager = new ConfigManager(moduleManager, keybindManager);
        this.cosmeticsManager = new CosmeticsManager();
        this.backgroundManager = new BackgroundManager();
        this.discordRpcManager = new DiscordRpcManager();
        this.screenshotManager = new ScreenshotManager();
        this.loadingOverlayController = new LoadingOverlayController();
        this.performanceOrchestrator = new PerformanceOrchestrator();

        moduleManager.bootstrapDefaults();
        keybindManager.register();
        configManager.loadProfile("default");
        cosmeticsManager.initialize();
        backgroundManager.initialize();
        discordRpcManager.initialize();
        performanceOrchestrator.initialize(moduleManager);

        LOGGER.info("Thunder Client initialized with {} modules ({})", moduleManager.getModules().size(), moduleManager.getCategoryCounts());
    }

    public static ThunderClient get() {
        return instance;
    }

    public EventBus getEventBus() { return eventBus; }
    public ModuleManager getModuleManager() { return moduleManager; }
    public KeybindManager getKeybindManager() { return keybindManager; }
    public ConfigManager getConfigManager() { return configManager; }
    public CosmeticsManager getCosmeticsManager() { return cosmeticsManager; }
    public BackgroundManager getBackgroundManager() { return backgroundManager; }
    public DiscordRpcManager getDiscordRpcManager() { return discordRpcManager; }
    public ScreenshotManager getScreenshotManager() { return screenshotManager; }
    public LoadingOverlayController getLoadingOverlayController() { return loadingOverlayController; }
    public PerformanceOrchestrator getPerformanceOrchestrator() { return performanceOrchestrator; }
}
