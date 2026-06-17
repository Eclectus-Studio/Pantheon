package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.resource.items.ItemModel;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.node.ItemModelNode;

public class ItemModelBuilder {

    private boolean handAnimationOnSwap = true;
    private boolean oversizedInGui = false;
    private float swapAnimationScale = 1.0f;

    private ItemModelNode root;

    public ItemModelBuilder root(
            ItemModelNode root
    ) {
        this.root = root;
        return this;
    }

    public ItemModelBuilder oversized() {
        this.oversizedInGui = true;
        return this;
    }

    public ItemModelBuilder noSwapAnimation() {
        this.handAnimationOnSwap = false;
        return this;
    }

    public ItemModelBuilder swapScale(
            float scale
    ) {
        this.swapAnimationScale = scale;
        return this;
    }

    public ItemModels build() {

        ItemModels model =
                new ItemModels(
                        new ItemModel(root)
                );

        model.setHandAnimationOnSwap(
                handAnimationOnSwap
        );

        model.setOversizedInGui(
                oversizedInGui
        );

        model.setSwapAnimationScale(
                swapAnimationScale
        );

        return model;
    }
}