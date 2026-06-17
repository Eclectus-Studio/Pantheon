package com.eclectusstudio.pantheon.common.resource.items.tints;

public record PotionTint(
        int defaultColor
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:potion";
    }
}