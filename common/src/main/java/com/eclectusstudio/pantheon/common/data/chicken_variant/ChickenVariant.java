package com.eclectusstudio.pantheon.common.data.chicken_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

import java.util.List;

public class ChickenVariant {
    private final ResourceLocation location;

    private final ResourceLocation adultTexture;
    private final ResourceLocation babyTexture;

    private final ChickenModelVariant modelVariant;

    private final List<SpawnCondition> spawnConditions;

    public ChickenVariant(ResourceLocation location, ResourceLocation adultTexture, ResourceLocation babyTexture, ChickenModelVariant modelVariant, List<SpawnCondition> spawnConditions) {
        this.location = location;
        this.adultTexture = adultTexture;
        this.babyTexture = babyTexture;
        this.modelVariant = modelVariant;
        this.spawnConditions = spawnConditions;
    }

    public ResourceLocation getLocation() { return location; }
    public ResourceLocation getAdultTexture() { return adultTexture; }
    public ResourceLocation getBabyTexture() { return babyTexture; }
    public ChickenModelVariant getModelVariant() { return modelVariant; }
    public List<SpawnCondition> getSpawnConditions() { return spawnConditions; }
}