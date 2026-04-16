package com.thunderclient.cosmetics.skin;

import java.nio.file.Path;

public record SkinEntry(String id, SkinSource source, String value) {
    public static SkinEntry local(String id, Path path) {
        return new SkinEntry(id, SkinSource.LOCAL_FILE, path.toString());
    }

    public static SkinEntry url(String id, String url) {
        return new SkinEntry(id, SkinSource.URL, url);
    }
}
