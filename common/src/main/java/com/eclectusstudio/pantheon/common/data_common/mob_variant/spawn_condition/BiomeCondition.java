package com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition;

import java.util.List;

public class BiomeCondition implements Condition {

    private final String type = "biome";
    private final List<ConditionTarget> biomes;

    public BiomeCondition(List<ConditionTarget> biomes) {
        this.biomes = biomes;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<ConditionTarget> getBiomes() {
        return biomes;
    }
}