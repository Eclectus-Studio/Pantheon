package com.eclectusstudio.pantheon.common.resource.items.tints;

public record MapColorTint(
        int defaultColor
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:map_color";
    }
}