package com.eclectusstudio.pantheon.common.serializer.font;

import com.eclectusstudio.pantheon.common.resource.fonts.*;
import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public final class FontSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private FontSerializer() {}

    public static void serialize(
            Path assetsFolder,
            String namespace,
            String name,
            Font font
    ) throws IOException {

        Path file =
                assetsFolder
                        .resolve(namespace)
                        .resolve("font")
                        .resolve(name + ".json");

        Files.createDirectories(file.getParent());

        JsonObject root =
                new JsonObject();

        JsonArray providers =
                new JsonArray();

        for (FontProvider provider :
                font.getProviders()) {

            providers.add(
                    serializeProvider(provider)
            );
        }

        root.add(
                "providers",
                providers
        );

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }


    private static JsonObject serializeProvider(
            FontProvider provider
    ) {

        JsonObject object =
                new JsonObject();

        object.addProperty(
                "type",
                provider.getType()
        );


        if (provider.getFilter() != null) {

            object.add(
                    "filter",
                    serializeFilter(
                            provider.getFilter()
                    )
            );
        }


        switch (provider) {

            case BitmapFontProvider bitmap ->
                    serializeBitmap(
                            object,
                            bitmap
                    );

            case SpaceFontProvider space ->
                    serializeSpace(
                            object,
                            space
                    );

            case TtfFontProvider ttf ->
                    serializeTtf(
                            object,
                            ttf
                    );

            case UnihexFontProvider unihex ->
                    serializeUnihex(
                            object,
                            unihex
                    );

            case ReferenceFontProvider reference ->
                    serializeReference(
                            object,
                            reference
                    );

            default ->
                    throw new IllegalStateException(
                            "Unknown font provider: "
                                    + provider.getClass()
                    );
        }

        return object;
    }


    private static JsonObject serializeFilter(
            FontFilter filter
    ) {

        JsonObject object =
                new JsonObject();

        if (filter.getUniform() != null) {

            object.addProperty(
                    "uniform",
                    filter.getUniform()
            );
        }

        if (filter.getJp() != null) {

            object.addProperty(
                    "jp",
                    filter.getJp()
            );
        }

        return object;
    }


    private static void serializeBitmap(
            JsonObject object,
            BitmapFontProvider provider
    ) {

        object.addProperty(
                "ascent",
                provider.getAscent()
        );

        JsonArray chars =
                new JsonArray();

        for (String line :
                provider.getChars()) {

            chars.add(line);
        }

        object.add(
                "chars",
                chars
        );


        if (provider.getFile() != null) {

            object.addProperty(
                    "file",
                    provider.getFile().toString()
            );
        }


        if (provider.getHeight() != null) {

            object.addProperty(
                    "height",
                    provider.getHeight()
            );
        }
    }


    private static void serializeSpace(
            JsonObject object,
            SpaceFontProvider provider
    ) {

        JsonObject advances =
                new JsonObject();


        for (Map.Entry<String, Integer> entry :
                provider.getAdvances().entrySet()) {

            advances.addProperty(
                    entry.getKey(),
                    entry.getValue()
            );
        }


        object.add(
                "advances",
                advances
        );
    }


    private static void serializeTtf(
            JsonObject object,
            TtfFontProvider provider
    ) {

        if (provider.getFile() != null) {

            object.addProperty(
                    "file",
                    provider.getFile().toString()
            );
        }


        object.addProperty(
                "oversample",
                provider.getOversample()
        );


        if (provider.getShift() != null) {

            JsonArray shift =
                    new JsonArray();

            for (int value :
                    provider.getShift()) {

                shift.add(value);
            }

            object.add(
                    "shift",
                    shift
            );
        }


        object.addProperty(
                "size",
                provider.getSize()
        );


        if (!provider.getSkip().isEmpty()) {

            JsonArray skip =
                    new JsonArray();

            for (String value :
                    provider.getSkip()) {

                skip.add(value);
            }

            object.add(
                    "skip",
                    skip
            );
        }
    }


    private static void serializeUnihex(
            JsonObject object,
            UnihexFontProvider provider
    ) {

        if (provider.getHexFile() != null) {

            object.addProperty(
                    "hex_file",
                    provider.getHexFile().toString()
            );
        }


        if (!provider.getSizeOverrides().isEmpty()) {

            JsonArray overrides =
                    new JsonArray();

            for (UnihexSizeOverride override :
                    provider.getSizeOverrides()) {

                JsonObject entry =
                        new JsonObject();

                entry.addProperty(
                        "from",
                        override.getFrom()
                );

                entry.addProperty(
                        "to",
                        override.getTo()
                );

                entry.addProperty(
                        "left",
                        override.getLeft()
                );

                entry.addProperty(
                        "right",
                        override.getRight()
                );

                overrides.add(entry);
            }

            object.add(
                    "size_overrides",
                    overrides
            );
        }
    }


    private static void serializeReference(
            JsonObject object,
            ReferenceFontProvider provider
    ) {

        if (provider.getId() != null) {

            object.addProperty(
                    "id",
                    provider.getId().toString()
            );
        }
    }
}