package com.eclectusstudio.pantheon.common.resource.items;

import com.eclectusstudio.pantheon.common.resource.items.node.ItemModelNode;

public class ItemModel {

    private ItemModelNode model;

    public ItemModel(ItemModelNode model) {
        this.model = model;
    }

    public ItemModel() {}

    public ItemModelNode getModel() {
        return model;
    }
}