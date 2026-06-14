package com.eclectusstudio.pantheon.common.serializer;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;
import com.eclectusstudio.pantheon.common.serializer.items.ItemsSerializer;
import com.eclectusstudio.pantheon.common.serializer.models.ModelSerializer;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ResourcePackSerializer {

    public static void serialize(
            File root,
            ResourcePack pack
    ) throws IOException {

        PackMCMetaSerializer.serialize(
                root,
                pack.getPackMCMeta()
        );

        ItemsSerializer.serialize(
                root.toPath().resolve("assets"),
                pack.getItems()
        );

        for (Map.Entry<ResourceLocation, ItemModelDefinition> entry : pack.getModels().entrySet()) {

            ModelSerializer.serialize(
                    root.toPath().resolve("assets"),
                    entry.getKey().getNamespace(),
                    entry.getKey().getPath(),
                    entry.getValue()
            );
        }

        // LanguageSerializer.serialize(...)
        // TextureSerializer.serialize(...)
    }
}