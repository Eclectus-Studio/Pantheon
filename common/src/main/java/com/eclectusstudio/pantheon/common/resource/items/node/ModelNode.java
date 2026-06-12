package com.eclectusstudio.pantheon.common.resource.items.node;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.List;

public class ModelNode implements ItemModelNode {

    private ResourceLocation model;
    private List<Object> tints; //TODO TintSource (we'll refine)

    @Override
    public String type() {
        return "minecraft:model";
    }

    public ModelNode(ResourceLocation model) {
        this.model = model;
    }

    public ModelNode(ResourceLocation model, List<Object> tints) {
        this.model = model;
        this.tints = tints;
    }

    public ResourceLocation getModel() {
        return model;
    }

    public List<Object> getTints() {
        return tints;
    }
}