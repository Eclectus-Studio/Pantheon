package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.items.ItemModel;
import com.eclectusstudio.pantheon.common.resource.items.node.DisplayContext;
import com.eclectusstudio.pantheon.common.resource.items.node.ModelNode;
import com.eclectusstudio.pantheon.common.resource.items.node.SelectNode;
import com.eclectusstudio.pantheon.common.resource.items.node.SelectProperty;

import java.util.List;

public class SimpleItemModelInInventory {
    private final ResourceLocation inInventory;
    private final ResourceLocation restOfTimeModel;

    public SimpleItemModelInInventory(ResourceLocation inInventory, ResourceLocation restOfTimeModel){
        this.inInventory = inInventory;
        this.restOfTimeModel = restOfTimeModel;
    }

    public ItemModel build() {
        return new ItemModel(
                new SelectNode(
                        SelectProperty.DISPLAY_CONTEXT,
                        List.of(
                                new SelectNode.Case(
                                        DisplayContext.GUI.id(),
                                        new ModelNode(inInventory)
                                )
                        ),
                        new ModelNode(restOfTimeModel)
                )
        );
    }
}
