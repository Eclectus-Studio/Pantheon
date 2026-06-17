package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;
import com.eclectusstudio.pantheon.common.resource.models.ModelTextures;

public class SimpleItemBuilder {

    private final ModelParent parent;

    private final ModelTextures textures =
            new ModelTextures();

    public SimpleItemBuilder(
            ModelParent parent
    ) {
        this.parent = parent;
    }

    public SimpleItemBuilder texture(
            String layer,
            String texture
    ) {
        textures.set(layer, texture);
        return this;
    }

    public ItemModelDefinition build() {

        ItemModelDefinition definition =
                new ItemModelDefinition(
                        parent.id()
                );

        definition.setTextures(textures);

        return definition;
    }
}