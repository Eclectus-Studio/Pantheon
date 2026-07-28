package com.eclectusstudio.pantheon.common.data.frog_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

import java.util.List;

public class FrogVariant {
    private final ResourceLocation location;

    private final ResourceLocation model;

    private final List<SpawnCondition> spawnConditions;

    public FrogVariant(ResourceLocation location, ResourceLocation model, List<SpawnCondition> spawnConditions) {
        this.location = location;
        this.model = model;
        this.spawnConditions = spawnConditions;
    }

    public ResourceLocation getLocation() { return location; }
    public ResourceLocation getModel() { return model; }
    public List<SpawnCondition> getSpawnConditions() { return spawnConditions; }
}