package com.eclectusstudio.pantheon.common.resource.fonts;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class ReferenceFontProvider extends FontProvider {

    private ResourceLocation id;

    @Override
    public String getType() {
        return "reference";
    }

    public ResourceLocation getId() {
        return id;
    }

    public void setId(ResourceLocation id) {
        this.id = id;
    }
}