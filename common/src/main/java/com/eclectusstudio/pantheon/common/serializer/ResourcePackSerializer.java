package com.eclectusstudio.pantheon.common.serializer;

import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.serializer.items.ItemsSerializer;

import java.io.File;
import java.io.IOException;

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
                root.toPath(),
                pack.getItems()
        );

        // ModelsSerializer.serialize(...)
        // LanguageSerializer.serialize(...)
        // TextureSerializer.serialize(...)
    }
}