package com.eclectusstudio.pantheon.common.data.cat_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

public class CatVariant {
    private final ResourceLocation location;

    private final ResourceLocation adultTexture;
    private final ResourceLocation babyTexture;

    private final SpawnCondition condition;

    public CatVariant(ResourceLocation location, ResourceLocation adultTexture, ResourceLocation babyTexture, SpawnCondition condition) {
        this.location = location;
        this.adultTexture = adultTexture;
        this.babyTexture = babyTexture;
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

    public SpawnCondition getCondition() {
        return condition;
    }
}
