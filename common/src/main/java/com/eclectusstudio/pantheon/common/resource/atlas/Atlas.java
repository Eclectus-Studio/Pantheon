package com.eclectusstudio.pantheon.common.resource.atlas;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class Atlas {

    private final ResourceLocation resourceLocation;
    private final List<SpriteSource> sources = new ArrayList<>();

    public Atlas(ResourceLocation resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    public Atlas addSource(SpriteSource source) {
        sources.add(source);

        return this;
    }

    public ResourceLocation getResourceLocation() {
        return resourceLocation;
    }

    public List<SpriteSource> getSources() {
        return sources;
    }
}
