package com.eclectusstudio.pantheon.common.data_common.mob_variant.spawn_condition;

import java.util.List;

public class StructureCondition implements Condition {

    private final String type = "structure";
    private final List<ConditionTarget> structures;

    public StructureCondition(List<ConditionTarget> structures) {
        this.structures = structures;
    }

    @Override
    public String getType() {
        return type;
    }

    public List<ConditionTarget> getStructures() {
        return structures;
    }
}