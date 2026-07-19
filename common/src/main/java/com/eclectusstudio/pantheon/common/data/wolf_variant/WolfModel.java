package com.eclectusstudio.pantheon.common.data.wolf_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class WolfModel {
    private final ResourceLocation angry;
    private final ResourceLocation tame;
    private final ResourceLocation wild;

    public WolfModel(ResourceLocation angry, ResourceLocation tame, ResourceLocation wild) {
        this.angry = angry;
        this.tame = tame;
        this.wild = wild;
    }

    public ResourceLocation getAngry() {
        return angry;
    }

    public ResourceLocation getTame() {
        return tame;
    }

    public ResourceLocation getWild() {
        return wild;
    }
}
