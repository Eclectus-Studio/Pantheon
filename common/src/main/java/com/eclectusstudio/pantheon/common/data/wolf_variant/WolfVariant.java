package com.eclectusstudio.pantheon.common.data.wolf_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class WolfVariant {
    private final ResourceLocation location;

    private final WolfModel adultModel;
    private final WolfModel babyModel;

    public WolfVariant(ResourceLocation location, WolfModel adultModel, WolfModel babyModel) {
        this.location = location;
        this.adultModel = adultModel;
        this.babyModel = babyModel;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public WolfModel getAdultModel() {
        return adultModel;
    }

    public WolfModel getBabyModel() {
        return babyModel;
    }
}
