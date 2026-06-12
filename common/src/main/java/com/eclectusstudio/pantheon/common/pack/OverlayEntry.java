package com.eclectusstudio.pantheon.common.pack;

public record OverlayEntry(
        String directory,
        Version version,
        FormatRange formats
) {}
