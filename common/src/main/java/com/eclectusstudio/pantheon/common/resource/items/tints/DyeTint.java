package com.eclectusstudio.pantheon.common.resource.items.tints;

public record DyeTint(
        int defaultColor
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:dye";
    }
}