package com.eclectusstudio.pantheon.common.resource.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import java.util.HashMap;
import java.util.Map;

public class ResourcePackItems {

    // The master registry map
    private  final Map<ResourceLocation, ItemModels> ITEM_MODELS_REGISTRY = new HashMap<>();

    /**
     * Registers a new item model.
     */
    public  void register(ResourceLocation location, ItemModels model) {
        if (ITEM_MODELS_REGISTRY.containsKey(location)) {
            throw new IllegalArgumentException("Duplicate item model registration for key: " + location);
        }
        ITEM_MODELS_REGISTRY.put(location, model);
    }

    /**
     * Retrieves an item model by its resource location.
     * Returns null if not found.
     */
    public  ItemModels getModel(ResourceLocation location) {
        return ITEM_MODELS_REGISTRY.get(location);
    }

    /**
     * Gets an unmodifiable view of all registered models (good practice for API safety).
     */
    public  Map<ResourceLocation, ItemModels> getAllModels() {
        return java.util.Collections.unmodifiableMap(ITEM_MODELS_REGISTRY);
    }
}