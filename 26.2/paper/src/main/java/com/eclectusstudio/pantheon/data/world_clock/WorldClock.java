package com.eclectusstudio.pantheon.data.world_clock;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class WorldClock {
    private final ResourceLocation location;

    public WorldClock(ResourceLocation location) {
        this.location = location;
    }

    public ResourceLocation getLocation() {
        return location;
    }
}
