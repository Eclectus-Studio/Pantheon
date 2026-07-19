package com.eclectusstudio.pantheon.common.data.zombie_nautilus_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

public class ZombieNautilusVariant {
    private final ResourceLocation location;

    private final ResourceLocation texture;

    private final ZombieNautilusModelVariant modelVariant;

    private final SpawnCondition condition;

    public ZombieNautilusVariant(ResourceLocation location, ResourceLocation texture, ZombieNautilusModelVariant modelVariant, SpawnCondition condition) {
        this.location = location;
        this.texture = texture;
        this.modelVariant = modelVariant;
        this.condition = condition;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public ZombieNautilusModelVariant getModelVariant() {
        return modelVariant;
    }

    public SpawnCondition getCondition() {
        return condition;
    }
}