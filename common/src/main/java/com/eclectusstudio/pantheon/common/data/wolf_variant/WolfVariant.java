package com.eclectusstudio.pantheon.common.data.wolf_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition.SpawnCondition;

import java.util.List;

public class WolfVariant {
    private final ResourceLocation location;

    private final WolfModel adultModel;
    private final WolfModel babyModel;

    private final List<SpawnCondition> spawnConditions;

    public WolfVariant(ResourceLocation location, WolfModel adultModel, WolfModel babyModel, List<SpawnCondition> spawnConditions) {
        this.location = location;
        this.adultModel = adultModel;
        this.babyModel = babyModel;
        this.spawnConditions = spawnConditions;
    }

    public ResourceLocation getLocation() { return location; }
    public WolfModel getAdultModel() { return adultModel; }
    public WolfModel getBabyModel() { return babyModel; }
    public List<SpawnCondition> getSpawnConditions() { return spawnConditions; }
}