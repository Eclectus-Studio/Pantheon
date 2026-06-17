package com.eclectusstudio.pantheon.common.resource.items.tints;

public record GrassTint(
        float temperature,
        float downfall
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:grass";
    }
}