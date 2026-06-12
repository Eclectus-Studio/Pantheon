package com.eclectusstudio.pantheon.common.resource.equipment;

public enum EquipmentLayerType {

    WOLF_BODY("wolf_body"),
    HORSE_BODY("horse_body"),
    LLAMA_BODY("llama_body"),

    HUMANOID("humanoid"),
    HUMANOID_LEGGINGS("humanoid_leggings"),
    HUMANOID_BABY("humanoid_baby"),

    WINGS("wings"),

    PIG_SADDLE("pig_saddle"),
    STRIDER_SADDLE("strider_saddle"),

    CAMEL_SADDLE("camel_saddle"),
    CAMEL_HUSK_SADDLE("camel_husk_saddle"),

    HORSE_SADDLE("horse_saddle"),
    DONKEY_SADDLE("donkey_saddle"),
    MULE_SADDLE("mule_saddle"),

    SKELETON_HORSE_SADDLE("skeleton_horse_saddle"),
    ZOMBIE_HORSE_SADDLE("zombie_horse_saddle"),

    HAPPY_GHAST_BODY("happy_ghast_body"),

    NAUTILUS_BODY("nautilus_body"),
    NAUTILUS_SADDLE("nautilus_saddle");

    private final String id;

    EquipmentLayerType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}