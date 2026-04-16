package com.thunderclient.module.modules.utility;

import com.thunderclient.module.ModuleCategory;
import com.thunderclient.module.SimpleModule;

public final class ChatPlusModule extends SimpleModule {
    public ChatPlusModule() {
        super("chat_plus", "Chat+", "Adds chat timestamps and quality-of-life actions.", ModuleCategory.UTILITY, -1);
    }
}
