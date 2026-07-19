package com.eclectusstudio.pantheon.common.data.frog_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

public class FrogVariant {
    private final ResourceLocation location;

    private final ResourceLocation model;

    private final SpawnCondition condition;

    public FrogVariant(ResourceLocation location, ResourceLocation model, SpawnCondition condition) {
        this.location = location;
        this.model = model;
        this.condition = condition;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public ResourceLocation getModel() {
        return model;
    }

    public SpawnCondition getCondition() {
        return condition;
    }
}
