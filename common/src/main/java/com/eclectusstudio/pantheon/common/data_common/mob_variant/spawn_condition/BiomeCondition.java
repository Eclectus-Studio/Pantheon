package com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.List;

public class BiomeCondition implements Condition {

    private final String type = "biome";

    private List<ResourceLocation> biomes;

    public BiomeCondition(List<ResourceLocation> biomes) {
        this.biomes = biomes;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<ResourceLocation> getBiomes() {
        return biomes;
    }
}