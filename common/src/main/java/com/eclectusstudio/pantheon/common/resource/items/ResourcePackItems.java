package com.eclectusstudio.pantheon.common.resource.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResourcePackItems {

    private final Map<ResourceLocation, ItemModels> itemModels =
            new HashMap<>();

    public void register(
            ResourceLocation location,
            ItemModels model
    ) {
        itemModels.put(location, model);
    }

    public ItemModels getModel(
            ResourceLocation location
    ) {
        return itemModels.get(location);
    }

    public Map<ResourceLocation, ItemModels> getAllModels() {
        return Collections.unmodifiableMap(itemModels);
    }
}