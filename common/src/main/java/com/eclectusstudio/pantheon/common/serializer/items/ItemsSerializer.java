package com.eclectusstudio.pantheon.common.serializer.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;
import com.eclectusstudio.pantheon.common.serializer.items.ItemSerializer;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public final class ItemsSerializer {

    public static void serialize(
            Path assetsFolder,
            ResourcePackItems items
    ) throws IOException {

        for (Map.Entry<ResourceLocation, ItemModels> entry :
                items.getAllModels().entrySet()) {

            ItemSerializer.serialize(
                    assetsFolder,
                    entry.getKey(),
                    entry.getValue()
            );
        }
    }
}