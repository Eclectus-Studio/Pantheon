package com.eclectusstudio.pantheon.common.resource.items.node;

public class SpecialNode implements ItemModelNode {

    public enum SpecialType {
        BANNER,
        BED,
        BELL,
        BOOK,
        CHEST,
        CONDUIT,
        DECORATED_POT,
        HEAD,
        PLAYER_HEAD,
        SHIELD,
        SHULKER_BOX,
        TRIDENT
    }

    private SpecialType specialType;
    private String base;

    @Override
    public String type() {
        return "minecraft:special";
    }

    public SpecialNode(SpecialType specialType) {
        this.specialType = specialType;
    }

    public SpecialNode(SpecialType specialType, String base) {
        this.specialType = specialType;
        this.base = base;
    }
}