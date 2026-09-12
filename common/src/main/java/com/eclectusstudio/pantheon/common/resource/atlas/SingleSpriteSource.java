package com.eclectusstudio.pantheon.common.resource.atlas;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class SingleSpriteSource implements SpriteSource {

    private final ResourceLocation resource;
    private final ResourceLocation sprite;

    public SingleSpriteSource(
            ResourceLocation resource
    ) {
        this(resource, resource);
    }

    public SingleSpriteSource(
            ResourceLocation resource,
            ResourceLocation sprite
    ) {
        this.resource = resource;
        this.sprite = sprite;
    }

    @Override
    public String getType() {
        return "minecraft:single";
    }

    public ResourceLocation getResource() {
        return resource;
    }

    public ResourceLocation getSprite() {
        return sprite;
    }
}
