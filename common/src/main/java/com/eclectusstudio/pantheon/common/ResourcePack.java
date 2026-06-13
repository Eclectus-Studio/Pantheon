package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;

public class ResourcePack {

    private final PackMCMeta packMCMeta;
    private final ResourcePackItems items;

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
}