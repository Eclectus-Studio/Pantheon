package com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public record ConditionTarget(ResourceLocation location, boolean isTag) {

    public static ConditionTarget id(ResourceLocation location) {
        return new ConditionTarget(location, false);
    }

    public static ConditionTarget tag(ResourceLocation location) {
        return new ConditionTarget(location, true);
    }
}