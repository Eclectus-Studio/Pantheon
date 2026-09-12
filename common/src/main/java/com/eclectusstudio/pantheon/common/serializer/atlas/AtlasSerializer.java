package com.eclectusstudio.pantheon.common.serializer.atlas;

import com.eclectusstudio.pantheon.common.resource.atlas.*;
import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public final class AtlasSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private AtlasSerializer() {}

    public static void serialize(
            Path assetsFolder,
            String namespace,
            String name,
            Atlas atlas
    ) throws IOException {

        Path file =
                assetsFolder
                        .resolve(namespace)
                        .resolve("atlases")
                        .resolve(name + ".json");

        Files.createDirectories(file.getParent());

        JsonObject root =
                new JsonObject();

        JsonArray sources =
                new JsonArray();

        for (SpriteSource source :
                atlas.getSources()) {

            sources.add(
                    serializeSource(source)
            );
        }

        root.add(
                "sources",
                sources
        );

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }

    private static JsonObject serializeSource(
            SpriteSource source
    ) {

        JsonObject object =
                new JsonObject();

        object.addProperty(
                "type",
                source.getType()
        );

        switch (source) {

            case DirectorySpriteSource directory ->
                    serializeDirectory(
                            object,
                            directory
                    );

            case SingleSpriteSource single ->
                    serializeSingle(
                            object,
                            single
                    );

            case FilterSpriteSource filter ->
                    serializeFilter(
                            object,
                            filter
                    );

            case UnstitchSpriteSource unstitch ->
                    serializeUnstitch(
                            object,
                            unstitch
                    );

            case PalettedPermutationsSpriteSource paletted ->
                    serializePaletted(
                            object,
                            paletted
                    );

            default ->
                    throw new IllegalStateException(
                            "Unknown sprite source: "
                                    + source.getClass()
                    );
        }

        return object;
    }

    private static void serializeDirectory(
            JsonObject object,
            DirectorySpriteSource source
    ) {

        object.addProperty(
                "source",
                source.getSource()
        );

        object.addProperty(
                "prefix",
                source.getPrefix()
        );
    }

    private static void serializeSingle(
            JsonObject object,
            SingleSpriteSource source
    ) {

        object.addProperty(
                "resource",
                source.getResource().toString()
        );

        if (!source.getSprite().equals(source.getResource())) {

            object.addProperty(
                    "sprite",
                    source.getSprite().toString()
            );
        }
    }

    private static void serializeFilter(
            JsonObject object,
            FilterSpriteSource source
    ) {

        if (source.getNamespace() != null) {

            object.addProperty(
                    "namespace",
                    source.getNamespace()
            );
        }

        if (source.getPath() != null) {

            object.addProperty(
                    "path",
                    source.getPath()
            );
        }
    }

    private static void serializeUnstitch(
            JsonObject object,
            UnstitchSpriteSource source
    ) {

        object.addProperty(
                "resource",
                source.getResource().toString()
        );

        object.addProperty(
                "divisor_x",
                source.getDivisorX()
        );

        object.addProperty(
                "divisor_y",
                source.getDivisorY()
        );

        JsonArray regions =
                new JsonArray();

        for (UnstitchSpriteSource.Region region :
                source.getRegions()) {

            JsonObject entry =
                    new JsonObject();

            entry.addProperty(
                    "sprite",
                    region.getSprite().toString()
            );

            entry.addProperty(
                    "x",
                    region.getX()
            );

            entry.addProperty(
                    "y",
                    region.getY()
            );

            entry.addProperty(
                    "width",
                    region.getWidth()
            );

            entry.addProperty(
                    "height",
                    region.getHeight()
            );

            regions.add(entry);
        }

        object.add(
                "regions",
                regions
        );
    }

    private static void serializePaletted(
            JsonObject object,
            PalettedPermutationsSpriteSource source
    ) {

        JsonArray textures =
                new JsonArray();

        for (var texture :
                source.getTextures()) {

            textures.add(
                    texture.toString()
            );
        }

        object.add(
                "textures",
                textures
        );

        if (!source.getSeparator().equals("_")) {

            object.addProperty(
                    "separator",
                    source.getSeparator()
            );
        }

        object.addProperty(
                "palette_key",
                source.getPaletteKey().toString()
        );

        JsonObject permutations =
                new JsonObject();

        for (Map.Entry<String, com.eclectusstudio.pantheon.common.ResourceLocation> entry :
                source.getPermutations().entrySet()) {

            permutations.addProperty(
                    entry.getKey(),
                    entry.getValue().toString()
            );
        }

        object.add(
                "permutations",
                permutations
        );
    }
}
