package com.eclectusstudio.pantheon.common.resource.items.tints;

public record CustomModelDataTint(
        int index,
        int defaultColor
) implements TintSource {

    @Override
    public String type() {
        return "minecraft:custom_model_data";
    }
}