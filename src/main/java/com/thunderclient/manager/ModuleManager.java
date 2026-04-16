package com.thunderclient.manager;

import com.thunderclient.event.EventBus;
import com.thunderclient.module.GenericModule;
import com.thunderclient.module.Module;
import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.modules.hud.*;
import com.thunderclient.module.modules.performance.*;
import com.thunderclient.module.modules.render.ZoomModule;
import com.thunderclient.module.modules.utility.*;

import java.util.*;

public final class ModuleManager {
    private final EventBus eventBus;
    private final Map<String, Module> modulesById = new LinkedHashMap<>();

    public ModuleManager(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void bootstrapDefaults() {
        register(
                new FpsBoostModule(),
                new EntityCullingModule(),
                new ParticleReducerModule(),
                new LazyChunkUpdatesModule(),
                new KeystrokesModule(),
                new FpsCounterModule(),
                new CpsCounterModule(),
                new ArmorStatusModule(),
                new PotionHudModule(),
                new PingDisplayModule(),
                new FreelookModule(),
                new ZoomModule(),
                new ToggleSprintModule(),
                new ToggleSneakModule(),
                new WaypointsModule(),
                new ChatPlusModule(),
                new BetterTablistModule()
        );

        registerCatalog(ModuleCategory.RENDER, List.of(
                spec("motion_blur", "Motion Blur", "Cinematic movement blur."),
                spec("clear_water", "Clear Water", "Improved underwater visibility."),
                spec("item_physics", "Item Physics", "Smooth dropped-item animation."),
                spec("damage_tint", "Damage Tint", "Premium hit tint overlays."),
                spec("small_fire", "Small Fire", "Reduced fire overlay size."),
                spec("block_outline_plus", "Block Outline+", "Customizable block outlines."),
                spec("fog_control", "Fog Control", "Fine fog distance control."),
                spec("sky_customizer", "Sky Customizer", "Skybox color and gradient controls."),
                spec("ambient_glow", "Ambient Glow", "Soft UI-aware ambient effect."),
                spec("hit_colorizer", "Hit Colorizer", "Custom hit-highlight colors."),
                spec("menu_bloom", "Menu Bloom", "Subtle bloom in client menus."),
                spec("crosshair_plus", "Crosshair+", "Crosshair style and animation."),
                spec("perspective_lock", "Perspective Lock", "Lock preferred camera mode."),
                spec("nametag_clean", "Nametag Clean", "Minimal and readable nametags."),
                spec("scoreboard_clean", "Scoreboard Clean", "Compact scoreboard renderer."),
                spec("world_color_grading", "Color Grading", "Stylized world tone mapping."),
                spec("screenshot_filters", "Screenshot Filters", "Optional visual filters."),
                spec("clean_enchant_glint", "Clean Glint", "Softer enchantment glint."),
                spec("fullscreen_hud_fade", "HUD Fade", "Context-aware HUD fading."),
                spec("cinematic_transitions", "Cinematic Transitions", "Smooth transition effects.")
        ));

        registerCatalog(ModuleCategory.HUD, List.of(
                spec("coords_hud", "Coordinates", "Shows XYZ coordinates."),
                spec("direction_hud", "Direction", "Cardinal direction indicator."),
                spec("clock_hud", "Clock", "Real-time or world-time clock."),
                spec("session_stats", "Session Stats", "Track wins, deaths, streaks."),
                spec("reach_display", "Reach Display", "Legit reach distance readout."),
                spec("combo_counter", "Combo Counter", "Current combo chain display."),
                spec("hit_accuracy", "Hit Accuracy", "Accuracy percentage widget."),
                spec("armor_durability", "Armor Durability", "Durability numbers on armor."),
                spec("item_counter", "Item Counter", "Consumable count tracker."),
                spec("latency_graph", "Latency Graph", "Compact ping graph."),
                spec("tps_display", "TPS", "Server TPS display."),
                spec("boss_timer", "Boss Timer", "Bossbar countdown helper."),
                spec("target_info", "Target Info", "Current target compact card."),
                spec("music_hud", "Music HUD", "Now playing widget."),
                spec("chat_preview", "Chat Preview", "Render queued chat preview."),
                spec("notification_center", "Notifications", "Animated notification stack."),
                spec("fps_graph", "FPS Graph", "Frame-time/FPS mini graph."),
                spec("pack_indicator", "Pack Indicator", "Current pack + profile info."),
                spec("server_card", "Server Card", "Current server quick info."),
                spec("watermark_plus", "Watermark+", "Premium animated watermark.")
        ));

        registerCatalog(ModuleCategory.PERFORMANCE, List.of(
                spec("smart_vsync", "Smart VSync", "Adaptive VSync strategies."),
                spec("dynamic_render_distance", "Dynamic Render Distance", "Auto scales view distance."),
                spec("ui_batching", "UI Batching", "Batch draw calls for menus."),
                spec("font_cache", "Font Cache", "Cache glyph quads for stable FPS."),
                spec("texture_trim", "Texture Trim", "Skip distant texture updates."),
                spec("shadow_throttle", "Shadow Throttle", "Reduce expensive shadow updates."),
                spec("tile_entity_limit", "Tile Entity Limit", "Distance-cull tile entities."),
                spec("entity_lod", "Entity LOD", "Lightweight entity LOD rendering."),
                spec("smart_particles", "Smart Particles", "Context-aware particle cap."),
                spec("biome_blend_optimizer", "Biome Blend Optimizer", "Reduce biome blending cost."),
                spec("fast_math", "Fast Math", "Lower-cost math paths where safe."),
                spec("chunk_build_queue", "Chunk Build Queue", "Prioritized chunk build queue."),
                spec("mesh_reuse", "Mesh Reuse", "Reuse static chunk mesh buffers."),
                spec("cloud_optimizer", "Cloud Optimizer", "Performance-first cloud renderer."),
                spec("weather_optimizer", "Weather Optimizer", "Rain/snow overdraw reduction."),
                spec("gpu_upload_budget", "GPU Upload Budget", "Budgeted texture uploads per frame."),
                spec("frame_pacing", "Frame Pacing", "Even frame pacing for smoothness."),
                spec("memory_guard", "Memory Guard", "Lightweight memory pressure controls."),
                spec("audio_mixer_opt", "Audio Mixer Opt", "Reduce audio thread spikes."),
                spec("tick_scheduler", "Tick Scheduler", "Micro-scheduling for heavy tasks.")
        ));

        registerCatalog(ModuleCategory.UTILITY, List.of(
                spec("auto_text", "Auto Text", "Preset quick-chat phrases."),
                spec("chat_timestamp", "Chat Timestamp", "Timestamp chat lines."),
                spec("party_tools", "Party Tools", "Party invite and status helpers."),
                spec("friend_notes", "Friend Notes", "Notes and tags per friend."),
                spec("nick_highlighter", "Nick Highlighter", "Highlight tracked usernames."),
                spec("auto_gg", "Auto GG", "Sends GG after matches."),
                spec("replay_bookmark", "Replay Bookmark", "Bookmark key moments."),
                spec("world_presets", "World Presets", "Per-world settings profiles."),
                spec("clipboard_chat", "Clipboard Chat", "Copy chat lines quickly."),
                spec("tool_swap_alert", "Tool Swap Alert", "Warn on wrong tool."),
                spec("craft_helper", "Craft Helper", "Recipe helper overlay."),
                spec("inventory_search", "Inventory Search", "Search items in inventory."),
                spec("container_preview", "Container Preview", "Peek container metadata."),
                spec("chat_mentions", "Chat Mentions", "Ping when your name appears."),
                spec("sound_profiles", "Sound Profiles", "Switch game sound profiles."),
                spec("smart_reply", "Smart Reply", "Quick-reply command helpers."),
                spec("server_switcher", "Server Switcher", "Fast server routing list."),
                spec("map_markers", "Map Markers", "Annotate map coordinates."),
                spec("day_counter", "Day Counter", "Track world day count."),
                spec("resource_timer", "Resource Timer", "Timed reminders for loops.")
        ));

        registerCatalog(ModuleCategory.PVP_ENHANCEMENTS, List.of(
                spec("hit_delay_indicator", "Hit Delay Indicator", "Attack cooldown visualization."),
                spec("rod_timer", "Rod Timer", "Fishing rod cooldown HUD."),
                spec("pearl_cooldown", "Pearl Cooldown", "Ender pearl timer display."),
                spec("projectile_predictor", "Projectile Predictor", "Legit projectile arc aid."),
                spec("wtap_assist", "W-Tap Assist", "Rhythm cue for W-tap timing."),
                spec("strafing_guide", "Strafing Guide", "Visual rhythm for strafes."),
                spec("block_hit_helper", "Blockhit Helper", "Blockhit timing assistant."),
                spec("sprint_reset_meter", "Sprint Reset Meter", "Tracks sprint reset timing."),
                spec("combo_break_alert", "Combo Break Alert", "Alert on combo loss risk."),
                spec("gapple_status", "Gapple Status", "Golden apple effect tracking."),
                spec("totem_tracker", "Totem Tracker", "Tracks totem pops in fights."),
                spec("duel_preset", "Duel Preset", "Quick preset for duel queues."),
                spec("hotbar_cycle_hint", "Hotbar Cycle Hint", "Visual item swap hint."),
                spec("shield_timer", "Shield Timer", "Shield cooldown visuals."),
                spec("arrow_counter", "Arrow Counter", "Arrow economy display."),
                spec("kb_feedback", "KB Feedback", "Knockback feedback overlay."),
                spec("spawn_protection_alert", "Spawn Protection Alert", "Spawn timer warnings."),
                spec("hit_sound_plus", "Hit Sound+", "Custom legit hit sounds."),
                spec("duel_history", "Duel History", "Recent duel stats board."),
                spec("fight_snapshot", "Fight Snapshot", "Post-fight summary card.")
        ));
    }

    private void registerCatalog(ModuleCategory category, List<ModuleSpec> specs) {
        for (ModuleSpec spec : specs) {
            register(new GenericModule(spec.id(), spec.name(), spec.description(), category, -1, false));
        }
    }

    private static ModuleSpec spec(String id, String name, String description) {
        return new ModuleSpec(id, name, description);
    }

    public void register(Module... modules) {
        for (Module module : modules) {
            modulesById.put(module.getId(), module);
        }
    }

    public Optional<Module> byId(String id) {
        return Optional.ofNullable(modulesById.get(id));
    }

    public List<Module> getModules() {
        return List.copyOf(modulesById.values());
    }

    public Map<ModuleCategory, Long> getCategoryCounts() {
        Map<ModuleCategory, Long> counts = new EnumMap<>(ModuleCategory.class);
        for (Module module : modulesById.values()) {
            counts.merge(module.getCategory(), 1L, Long::sum);
        }
        return counts;
    }

    public EventBus eventBus() {
        return eventBus;
    }

    private record ModuleSpec(String id, String name, String description) {}
}
