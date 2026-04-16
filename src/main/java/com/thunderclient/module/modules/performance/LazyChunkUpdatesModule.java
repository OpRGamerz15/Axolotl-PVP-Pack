package com.thunderclient.module.modules.performance;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class LazyChunkUpdatesModule extends SimpleModule {
    public LazyChunkUpdatesModule() {
        super("lazy_chunk_updates", "Lazy Chunk Updates", "Batches visual chunk updates.", ModuleCategory.PERFORMANCE, -1);
    }
}
