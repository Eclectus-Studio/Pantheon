package com.eclectusstudio.pantheon.data.dimension_type;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class DimensionType {
    private final ResourceLocation location;

    public DimensionType(ResourceLocation location) {
        this.location = location;
    }

    public ResourceLocation getLocation() {
        return location;
    }
}
