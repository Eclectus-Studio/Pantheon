package com.eclectusstudio.pantheon.data.banner_pattern;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class BannerPattern {
    private final ResourceLocation location;

    private final ResourceLocation assetID;

    public ResourceLocation getLocation() {
        return location;
    }

    public ResourceLocation getAssetID() {
        return assetID;
    }

    public BannerPattern(ResourceLocation location, ResourceLocation assetID) {
        this.location = location;
        this.assetID = assetID;
    }
}
