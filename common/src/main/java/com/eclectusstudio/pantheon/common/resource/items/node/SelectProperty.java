package com.eclectusstudio.pantheon.common.resource.items.node;

public enum SelectProperty {
    MAIN_HAND("minecraft:main_hand"),
    CHARGE_TYPE("minecraft:charge_type"),
    TRIM_MATERIAL("minecraft:trim_material"),
    BLOCK_STATE("minecraft:block_state"),
    CUSTOM_MODEL_DATA("minecraft:custom_model_data"),
    DISPLAY_CONTEXT("minecraft:display_context"),
    LOCAL_TIME("minecraft:local_time"),
    CONTEXT_DIMENSION("minecraft:context_dimension"),
    CONTEXT_ENTITY_TYPE("minecraft:context_entity_type");

    private final String id;

    SelectProperty(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}