package com.eclectusstudio.pantheon.common.api.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public final class SimpleItemModels {

    private SimpleItemModels() {}

    public static SimpleItem generated(
            ResourceLocation id
    ) {
        return new SimpleItem(
                id,
                VanillaModelParent.GENERATED
        );
    }

    public static SimpleItem handheld(
            ResourceLocation id
    ) {
        return new SimpleItem(
                id,
                VanillaModelParent.HANDHELD
        );
    }

    public static SimpleItem handheldRod(
            ResourceLocation id
    ) {
        return new SimpleItem(
                id,
                VanillaModelParent.HANDHELD_ROD
        );
    }
}