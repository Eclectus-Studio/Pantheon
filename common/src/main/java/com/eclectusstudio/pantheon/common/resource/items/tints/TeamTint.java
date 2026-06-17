package com.eclectusstudio.pantheon.common.resource.items.tints;

public record TeamTint(
        int defaultColor
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:team";
    }
}