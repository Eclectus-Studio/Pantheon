package com.eclectusstudio.pantheon.data.decoratedpotpattern;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class DecoratedPotPattern {
    private final ResourceLocation location;

    private final ResourceLocation assetID;

    public DecoratedPotPattern(ResourceLocation location, ResourceLocation assetID) {
        this.location = location;
        this.assetID = assetID;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public ResourceLocation getAssetID() {
        return assetID;
    }
}
