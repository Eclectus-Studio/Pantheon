package com.eclectusstudio.pantheon.common.pack;

import java.awt.*;

public record PackInfo(
        Component description,
        Integer packFormat,
        FormatRange supportedFormats,
        Version minFormat,
        Version maxFormat
) {}