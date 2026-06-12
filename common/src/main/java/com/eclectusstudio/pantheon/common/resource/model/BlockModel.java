package com.eclectusstudio.pantheon.common.resource.model;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import java.util.*;

public class BlockModel {

    private ResourceLocation parent;

    private boolean ambientOcclusion = true;

    private Map<String, TextureRef> textures = new HashMap<>();

    private Map<BlockModelContext, ModelDisplay> display = new HashMap<>();

    private List<ModelElement> elements = new ArrayList<>();

    public BlockModel() {}

    public BlockModel parent(ResourceLocation parent) {
        this.parent = parent;
        return this;
    }

    public BlockModel addElement(ModelElement element) {
        elements.add(element);
        return this;
    }

    public BlockModel texture(String key, TextureRef ref) {
        textures.put(key, ref);
        return this;
    }

    public BlockModel display(BlockModelContext ctx, ModelDisplay transform) {
        display.put(ctx, transform);
        return this;
    }

    public BlockModel ambientOcclusion(boolean value) {
        this.ambientOcclusion = value;
        return this;
    }
}