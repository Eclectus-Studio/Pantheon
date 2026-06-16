package com.eclectusstudio.pantheon.common.serializer;

import com.eclectusstudio.pantheon.common.PackMCMeta;
import com.eclectusstudio.pantheon.common.pack.*;
import com.google.gson.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public final class PackMCMetaSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private PackMCMetaSerializer() {}

    public static void serialize(
            File packRoot,
            PackMCMeta meta
    ) throws IOException {

        JsonObject root = new JsonObject();

        serializePack(root, meta);
        serializeFeatures(root, meta);
        serializeFilter(root, meta);
        serializeOverlays(root, meta);
        serializeLanguages(root, meta);

        File output =
                new File(packRoot, "pack.mcmeta");

        try (FileWriter writer =
                     new FileWriter(output)) {

            GSON.toJson(root, writer);
        }
    }

    private static void serializePack(
            JsonObject root,
            PackMCMeta meta
    ) {

        JsonObject pack = new JsonObject();

        if (meta.getDescription() != null) {
            pack.addProperty(
                    "description",
                    meta.getDescription()
            );
        }

        if (meta.getPackFormat() != null) {
            pack.addProperty(
                    "pack_format",
                    meta.getPackFormat()
            );
        }

        if (meta.getSupportedFormats() != null) {

            FormatRange range =
                    meta.getSupportedFormats();

            if (range instanceof FormatInterval interval) {

                pack.addProperty(
                        "min_format",
                        interval.minInclusive()
                );

                pack.addProperty(
                        "max_format",
                        interval.maxInclusive()
                );
            }

            pack.add(
                    "supported_formats",
                    serializeFormatRange(range)
            );
        }

        root.add("pack", pack);
    }

    private static void serializeFeatures(
            JsonObject root,
            PackMCMeta meta
    ) {

        if (meta.getFeatures().isEmpty()) {
            return;
        }

        JsonObject features =
                new JsonObject();

        JsonArray enabled =
                new JsonArray();

        for (String feature :
                meta.getFeatures()) {

            enabled.add(feature);
        }

        features.add(
                "enabled",
                enabled
        );

        root.add(
                "features",
                features
        );
    }

    private static void serializeFilter(
            JsonObject root,
            PackMCMeta meta
    ) {

        if (meta.getFilters().isEmpty()) {
            return;
        }

        JsonObject filter =
                new JsonObject();

        JsonArray block =
                new JsonArray();

        for (FilterRule rule :
                meta.getFilters()) {

            JsonObject entry =
                    new JsonObject();

            if (rule.namespace() != null) {
                entry.addProperty(
                        "namespace",
                        rule.namespace()
                );
            }

            if (rule.path() != null) {
                entry.addProperty(
                        "path",
                        rule.path()
                );
            }

            block.add(entry);
        }

        filter.add(
                "block",
                block
        );

        root.add(
                "filter",
                filter
        );
    }

    private static void serializeOverlays(
            JsonObject root,
            PackMCMeta meta
    ) {

        if (meta.getOverlays().isEmpty()) {
            return;
        }

        JsonObject overlays =
                new JsonObject();

        JsonArray entries =
                new JsonArray();

        for (OverlayEntry overlay :
                meta.getOverlays()) {

            JsonObject entry =
                    new JsonObject();

            entry.addProperty(
                    "directory",
                    overlay.directory()
            );

            if (overlay.formats() instanceof
                    FormatInterval interval) {

                entry.addProperty(
                        "min_format",
                        interval.minInclusive()
                );

                entry.addProperty(
                        "max_format",
                        interval.maxInclusive()
                );
            }

            entry.add(
                    "formats",
                    serializeFormatRange(
                            overlay.formats()
                    )
            );

            entries.add(entry);
        }

        overlays.add(
                "entries",
                entries
        );

        root.add(
                "overlays",
                overlays
        );
    }

    private static void serializeLanguages(
            JsonObject root,
            PackMCMeta meta
    ) {

        Map<String, LanguageDefinition> languages =
                meta.getLanguages();

        if (languages.isEmpty()) {
            return;
        }

        JsonObject language =
                new JsonObject();

        languages.forEach((code, def) -> {

            JsonObject lang =
                    new JsonObject();

            lang.addProperty(
                    "name",
                    def.name()
            );

            lang.addProperty(
                    "region",
                    def.region()
            );

            lang.addProperty(
                    "bidirectional",
                    def.bidirectional()
            );

            language.add(
                    code,
                    lang
            );
        });

        root.add(
                "language",
                language
        );
    }

    private static JsonElement serializeFormatRange(
            FormatRange range
    ) {

        if (range instanceof SingleFormat single) {
            return new JsonPrimitive(
                    single.value()
            );
        }

        if (range instanceof FormatInterval interval) {

            JsonObject obj =
                    new JsonObject();

            obj.addProperty(
                    "min_inclusive",
                    interval.minInclusive()
            );

            obj.addProperty(
                    "max_inclusive",
                    interval.maxInclusive()
            );

            return obj;
        }

        throw new IllegalStateException(
                "Unknown format range type: "
                        + range.getClass()
        );
    }
}