package com.eclectusstudio.pantheon.common.data.cow_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

public class CowVariant {
    private final ResourceLocation location;

    private final ResourceLocation adultTexture;
    private final ResourceLocation babyTexture;

    private final CowModelVariant modelVariant;

    private final SpawnCondition condition;

    public CowVariant(ResourceLocation location, ResourceLocation adultTexture, ResourceLocation babyTexture, CowModelVariant modelVariant, SpawnCondition condition) {
        this.location = location;
        this.adultTexture = adultTexture;
        this.babyTexture = babyTexture;
        this.modelVariant = modelVariant;
        this.condition = condition;
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

    public CowModelVariant getModelVariant() {
        return modelVariant;
    }

    public SpawnCondition getCondition() {
        return condition;
    }
}
