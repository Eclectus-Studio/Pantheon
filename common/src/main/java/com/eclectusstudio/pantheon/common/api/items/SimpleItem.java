package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.resource.items.ItemModel;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.node.ModelNode;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;
import com.eclectusstudio.pantheon.common.resource.models.ModelTextures;

public class SimpleItem {

    private final ResourceLocation id;
    private final ModelParent parent;

    public SimpleItem(
            ResourceLocation id,
            ModelParent parent
    ) {
        this.id = id;
        this.parent = parent;
    }

    public ResourceLocation id() {
        return id;
    }

    public ItemModels createItemModels() {

        return new ItemModels(
                new ItemModel(
                        new ModelNode(
                                new ResourceLocation(
                                        id.getNamespace(),
                                        "item/" + id.getPath()
                                )
                        )
                )
        );
    }

    public ItemModelDefinition createDefinition() {

        ItemModelDefinition definition =
                new ItemModelDefinition(
                        parent.id()
                );

        ModelTextures textures =
                new ModelTextures();

        textures.set(
                "layer0",
                id.getNamespace()
                        + ":item/"
                        + id.getPath()
        );

        definition.setTextures(textures);

        return definition;
    }

    public void register(
            ResourcePack pack
    ) {

        pack.addItem(
                id,
                createItemModels()
        );

        pack.addModel(
                id,
                createDefinition()
        );
    }
}