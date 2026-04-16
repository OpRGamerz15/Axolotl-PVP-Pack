package com.thunderclient.module.modules.performance;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class ParticleReducerModule extends SimpleModule {
    public ParticleReducerModule() {
        super("particle_reducer", "Particle Reducer", "Throttles heavy particle effects.", ModuleCategory.PERFORMANCE, -1);
    }
}
