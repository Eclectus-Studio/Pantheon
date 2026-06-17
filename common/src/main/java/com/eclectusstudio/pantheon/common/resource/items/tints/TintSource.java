package com.eclectusstudio.pantheon.common.resource.items.tints;

public sealed interface TintSource
        permits ConstantTint,
        DyeTint,
        FireworkTint,
        GrassTint,
        MapColorTint,
        PotionTint,
        TeamTint,
        CustomModelDataTint {

    String type();

}