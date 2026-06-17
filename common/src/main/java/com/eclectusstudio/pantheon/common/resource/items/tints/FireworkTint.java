package com.eclectusstudio.pantheon.common.resource.items.tints;

public record FireworkTint(
        int defaultColor
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:firework";
    }
}