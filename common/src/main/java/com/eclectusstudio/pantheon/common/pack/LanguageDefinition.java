package com.eclectusstudio.pantheon.common.pack;

public record LanguageDefinition(
        String name,
        String region,
        boolean bidirectional
) {}