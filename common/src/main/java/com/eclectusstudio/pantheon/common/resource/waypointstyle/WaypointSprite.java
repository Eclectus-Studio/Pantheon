package com.eclectusstudio.pantheon.common.resource.waypointstyle;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class WaypointSprite {

    private final ResourceLocation sprite;

    public WaypointSprite(ResourceLocation sprite) {
        this.sprite = sprite;
    }

    public ResourceLocation getSprite() {
        return sprite;
    }
}