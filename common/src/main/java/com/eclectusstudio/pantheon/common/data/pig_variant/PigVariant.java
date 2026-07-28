package com.eclectusstudio.pantheon.common.data.pig_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

import java.util.List;

public class PigVariant {
    private final ResourceLocation location;

    private final ResourceLocation adultTexture;
    private final ResourceLocation babyTexture;

    private final PigModelVariant modelVariant;

    private final List<SpawnCondition> spawnConditions;

    public PigVariant(ResourceLocation location, ResourceLocation adultTexture, ResourceLocation babyTexture, PigModelVariant modelVariant, List<SpawnCondition> spawnConditions) {
        this.location = location;
        this.adultTexture = adultTexture;
        this.babyTexture = babyTexture;
        this.modelVariant = modelVariant;
        this.spawnConditions = spawnConditions;
    }

    public ResourceLocation getLocation() { return location; }
    public ResourceLocation getAdultTexture() { return adultTexture; }
    public ResourceLocation getBabyTexture() { return babyTexture; }
    public PigModelVariant getModelVariant() { return modelVariant; }
    public List<SpawnCondition> getSpawnConditions() { return spawnConditions; }
}