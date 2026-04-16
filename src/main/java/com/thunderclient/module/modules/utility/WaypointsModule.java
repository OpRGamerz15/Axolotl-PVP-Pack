package com.thunderclient.module.modules.utility;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class WaypointsModule extends SimpleModule {
    public WaypointsModule() {
        super("waypoints", "Waypoints", "Manage waypoints per world/server.", ModuleCategory.UTILITY, -1);
    }
}
