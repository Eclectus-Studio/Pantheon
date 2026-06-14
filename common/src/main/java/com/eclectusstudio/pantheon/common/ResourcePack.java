package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;

import java.util.HashMap;
import java.util.Map;

public class ResourcePack {

    private final PackMCMeta packMCMeta;
    private final ResourcePackItems items;
    private final Map<ResourceLocation, ItemModelDefinition> models = new HashMap<>();

    public ResourcePack(
            PackMCMeta packMCMeta,
            ResourcePackItems items
    ) {
        this.packMCMeta = packMCMeta;
        this.items = items;
    }

    public PackMCMeta getPackMCMeta() {
        return packMCMeta;
    }

    public ResourcePackItems getItems() {
        return items;
    }

    public void registerModel(ResourceLocation id, ItemModelDefinition model) {
        models.put(id, model);
    }

    public Map<ResourceLocation, ItemModelDefinition> getModels() {
        return models;
    }
}