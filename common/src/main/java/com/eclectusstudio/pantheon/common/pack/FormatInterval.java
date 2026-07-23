package com.eclectusstudio.pantheon.common.pack;

public record FormatInterval(
        float minInclusive,
        float maxInclusive
) implements FormatRange {}