package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.resource.items.tints.*;

public final class Tints {

    private Tints() {}

    public static ConstantTint constant(int rgb) {
        return new ConstantTint(rgb);
    }

    public static DyeTint dye(int defaultColor) {
        return new DyeTint(defaultColor);
    }

    public static FireworkTint firework(int defaultColor) {
        return new FireworkTint(defaultColor);
    }

    public static GrassTint grass(
            float temperature,
            float downfall
    ) {
        return new GrassTint(
                temperature,
                downfall
        );
    }

    public static MapColorTint mapColor(
            int defaultColor
    ) {
        return new MapColorTint(defaultColor);
    }

    public static PotionTint potion(
            int defaultColor
    ) {
        return new PotionTint(defaultColor);
    }

    public static TeamTint team(
            int defaultColor
    ) {
        return new TeamTint(defaultColor);
    }

    public static CustomModelDataTint customModelData(
            int index,
            int defaultColor
    ) {
        return new CustomModelDataTint(
                index,
                defaultColor
        );
    }
}