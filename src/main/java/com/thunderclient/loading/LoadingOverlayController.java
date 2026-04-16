package com.thunderclient.loading;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class LoadingOverlayController {
    private static final List<String> TIPS = List.of(
            "Tip: Use Zoom for ranged bow fights.",
            "Tip: Keep particles reduced for smoother PvP.",
            "Tip: Configure profiles for each server."
    );

    public String randomTip() {
        return TIPS.get(ThreadLocalRandom.current().nextInt(TIPS.size()));
    }
}
