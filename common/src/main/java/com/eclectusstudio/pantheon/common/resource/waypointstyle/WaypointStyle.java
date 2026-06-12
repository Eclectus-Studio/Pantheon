package com.eclectusstudio.pantheon.common.resource.waypointstyle;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class WaypointStyle {

    private int nearDistance = 128;
    private int farDistance = 332;

    private final List<ResourceLocation> sprites = new ArrayList<>();

    public WaypointStyle() {
    }

    public WaypointStyle(int nearDistance, int farDistance) {
        this.nearDistance = nearDistance;
        this.farDistance = farDistance;
    }

    public WaypointStyle addSprite(ResourceLocation sprite) {
        sprites.add(sprite);
        return this;
    }

    public int getNearDistance() {
        return nearDistance;
    }

    public int getFarDistance() {
        return farDistance;
    }

    public List<ResourceLocation> getSprites() {
        return sprites;
    }

    /**
     * Distance between each sprite transition.
     */
    public double getTransitionDistance() {
        if (sprites.isEmpty()) {
            return 0;
        }

        return (double) (farDistance - nearDistance) / sprites.size();
    }
}