package com.eclectusstudio.pantheon.common.resource.items.tints;

public record ConstantTint(
        int rgb
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:constant";
    }
}