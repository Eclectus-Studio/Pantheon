package com.eclectusstudio.pantheon.common.resource.items;

public class ItemModels {

    private boolean handAnimationOnSwap = true;
    private boolean oversizedInGui = false;
    private float swapAnimationScale = 1.0f;

    private ItemModel model;

    public ItemModels(ItemModel model) {
        this.model = model;
    }

    public ItemModels() {
    }

    public boolean isHandAnimationOnSwap() {
        return handAnimationOnSwap;
    }

    public void setHandAnimationOnSwap(boolean handAnimationOnSwap) {
        this.handAnimationOnSwap = handAnimationOnSwap;
    }

    public boolean isOversizedInGui() {
        return oversizedInGui;
    }

    public void setOversizedInGui(boolean oversizedInGui) {
        this.oversizedInGui = oversizedInGui;
    }

    public float getSwapAnimationScale() {
        return swapAnimationScale;
    }

    public void setSwapAnimationScale(float swapAnimationScale) {
        this.swapAnimationScale = swapAnimationScale;
    }

    public ItemModel getModel() {
        return model;
    }

    public void setModel(ItemModel model) {
        this.model = model;
    }
}