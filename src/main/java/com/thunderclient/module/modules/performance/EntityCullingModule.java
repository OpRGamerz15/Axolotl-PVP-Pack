package com.thunderclient.module.modules.performance;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class EntityCullingModule extends SimpleModule {
    public EntityCullingModule() {
        super("entity_culling", "Entity Culling", "Skips rendering off-screen entities.", ModuleCategory.PERFORMANCE, -1);
    }
}
