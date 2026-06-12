package com.eclectusstudio.pantheon.common.resource.items.node;

import java.util.List;

public class CompositeNode implements ItemModelNode {

    private List<ItemModelNode> models;

    @Override
    public String type() {
        return "minecraft:composite";
    }

    public CompositeNode(List<ItemModelNode> models) {
        this.models = models;
    }

    public List<ItemModelNode> getModels() {
        return models;
    }
}