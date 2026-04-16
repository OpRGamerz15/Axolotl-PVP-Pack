package com.thunderclient.ui.theme;

public record ThunderTheme(int primaryColor, int secondaryColor, int accentColor, int shadowColor, int textColor) {
    public static ThunderTheme defaultTheme() {
        return new ThunderTheme(
                0xFF5B5EF9,
                0xFF00D4FF,
                0xFFB026FF,
                0x88000000,
                0xFFEAF3FF
        );
    }
}
