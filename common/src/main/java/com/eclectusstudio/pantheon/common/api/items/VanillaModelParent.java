package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public enum VanillaModelParent implements ModelParent {

    GENERATED("minecraft:item/generated"),
    HANDHELD("minecraft:item/handheld"),

    HANDHELD_ROD("minecraft:item/handheld_rod"),

    TEMPLATE_SPAWN_EGG("minecraft:item/template_spawn_egg"),

    TEMPLATE_BANNER("minecraft:item/template_banner"),
    TEMPLATE_BED("minecraft:item/template_bed"),
    TEMPLATE_SHULKER_BOX("minecraft:item/template_shulker_box"),
    TEMPLATE_SKULL("minecraft:item/template_skull"),

    TEMPLATE_CANDLE("minecraft:item/template_candle"),

    TEMPLATE_TWO_LAYERED_ITEM("minecraft:item/template_two_layered_item"),
    TEMPLATE_THREE_LAYERED_ITEM("minecraft:item/template_three_layered_item");

    private final ResourceLocation id;

    VanillaModelParent(String id) {
        this.id = ResourceLocation.fromString(id);
    }

    @Override
    public ResourceLocation id() {
        return id;
    }
}