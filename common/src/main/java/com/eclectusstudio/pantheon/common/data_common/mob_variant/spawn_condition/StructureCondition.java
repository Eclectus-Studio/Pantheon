package com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.List;

public class StructureCondition implements Condition {

    private final String type = "structure";

    /**
     * Structure IDs or tags.
     */
    private List<ResourceLocation> structures;

    public StructureCondition() {}

    public StructureCondition(List<ResourceLocation> structures) {
        this.structures = structures;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<ResourceLocation> getStructures() {
        return structures;
    }
}
