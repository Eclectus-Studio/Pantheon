package com.eclectusstudio.pantheon.common.resource.items;

public class ItemModels {

    private boolean handAnimationOnSwap = true;
    private boolean oversizedInGui = false;
    private float swapAnimationScale = 1.0f;

    private ItemModel model;

    public ItemModels(ItemModel model) {
        this.model = model;
    }

    public ItemModels() {}

    public ItemModel getModel() {
        return model;
    }
}