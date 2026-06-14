package com.eclectusstudio.pantheon.common.pack;

public record PackInfo(
        String description,
        Integer packFormat,
        FormatRange supportedFormats,
        Version format
) {}