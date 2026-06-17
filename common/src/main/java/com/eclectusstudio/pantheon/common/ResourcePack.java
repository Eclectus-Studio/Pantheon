package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.pack.*;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;

import java.util.HashMap;
import java.util.Map;

public final class ResourcePack {

    private final PackMCMeta metadata;
    private final ResourcePackItems items;
    private final Map<ResourceLocation, ItemModelDefinition> models;

    public ResourcePack() {
        this.metadata = PackMCMeta.builder().build();
        this.items = new ResourcePackItems();
        this.models = new HashMap<>();
    }

    /*
     * Assets
     */

    public ResourcePack addItem(
            ResourceLocation id,
            ItemModels itemModels
    ) {

        items.register(
                id,
                itemModels
        );

        return this;
    }

    public ResourcePack addModel(
            ResourceLocation id,
            ItemModelDefinition model
    ) {

        models.put(
                id,
                model
        );

        return this;
    }

    /*
     * Getters
     */

    public PackMCMeta getMetadata() {
        return metadata;
    }

    public ResourcePackItems getItems() {
        return items;
    }

    public Map<ResourceLocation, ItemModelDefinition> getModels() {
        return models;
    }
}