package com.eclectusstudio.pantheon.common.pack;

public record FormatInterval(
        int minInclusive,
        int maxInclusive
) implements FormatRange {}