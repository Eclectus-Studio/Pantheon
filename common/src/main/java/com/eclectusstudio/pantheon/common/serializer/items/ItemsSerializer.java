package com.eclectusstudio.pantheon.common.serializer.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public final class ItemsSerializer {

    public static void serialize(
            Path assetsFolder,
            ResourcePackItems items
    ) throws IOException {

        Path itemModelsFolder = assetsFolder
                .resolve("models")
                .resolve("item");

        for (Map.Entry<ResourceLocation, ItemModels> entry :
                items.getAllModels().entrySet()) {

            ItemSerializer.serialize(
                    itemModelsFolder,
                    entry.getKey(),
                    entry.getValue()
            );
        }
    }
}