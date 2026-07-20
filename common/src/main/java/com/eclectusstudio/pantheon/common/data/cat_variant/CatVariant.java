package com.eclectusstudio.pantheon.common.data.cat_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

import java.util.List;

public class CatVariant {
    private final ResourceLocation location;

    private final ResourceLocation adultTexture;
    private final ResourceLocation babyTexture;

    private final List<SpawnCondition> spawnConditions;

    public CatVariant(ResourceLocation location, ResourceLocation adultTexture, ResourceLocation babyTexture, List<SpawnCondition> spawnConditions) {
        this.location = location;
        this.adultTexture = adultTexture;
        this.babyTexture = babyTexture;
        this.spawnConditions = spawnConditions;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public ResourceLocation getAdultTexture() {
        return adultTexture;
    }

    public ResourceLocation getBabyTexture() {
        return babyTexture;
    }

    public List<SpawnCondition> getSpawnConditions() {
        return spawnConditions;
    }
}