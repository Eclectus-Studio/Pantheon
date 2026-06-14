package com.eclectusstudio.pantheon.common.serializer;

import com.eclectusstudio.pantheon.common.PackMCMeta;
import com.eclectusstudio.pantheon.common.pack.*;
import com.google.gson.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class PackMCMetaSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    public static void serialize(
            File packRoot,
            PackMCMeta meta
    ) throws IOException {

        JsonObject root = new JsonObject();

        if (meta.getPack() != null) {
            serializePack(root, meta.getPack());
        }

        if (meta.getFeatures() != null) {
            serializeFeatures(root, meta.getFeatures());
        }

        if (meta.getFilter() != null) {
            serializeFilter(root, meta.getFilter());
        }

        if (meta.getOverlays() != null) {
            serializeOverlays(root, meta.getOverlays());
        }

        if (meta.getLanguage() != null
                && !meta.getLanguage().isEmpty()) {
            serializeLanguages(root, meta.getLanguage());
        }

        File out = new File(packRoot, "pack.mcmeta");

        try (FileWriter writer = new FileWriter(out)) {
            GSON.toJson(root, writer);
        }
    }

    private static void serializePack(
            JsonObject root,
            PackInfo info
    ) {

        JsonObject pack = new JsonObject();

        if (info.description() != null) {
            pack.addProperty(
                    "description",
                    info.description().toString()
            );
        }

        if (info.packFormat() != null) {
            pack.addProperty(
                    "pack_format",
                    info.packFormat()
            );
        }

        writeVersion(
                pack,
                "min_format",
                info.format()
        );

        writeVersion(
                pack,
                "max_format",
                info.format()
        );

        if (info.supportedFormats() != null) {
            pack.add(
                    "supported_formats",
                    serializeFormatRange(
                            info.supportedFormats()
                    )
            );
        }

        root.add("pack", pack);
    }

    private static void serializeFeatures(
            JsonObject root,
            Features features
    ) {

        if (features.enabled() == null
                || features.enabled().isEmpty()) {
            return;
        }

        JsonObject obj = new JsonObject();

        JsonArray enabled = new JsonArray();

        for (String feature : features.enabled()) {
            enabled.add(feature);
        }

        obj.add("enabled", enabled);

        root.add("features", obj);
    }

    private static void serializeFilter(
            JsonObject root,
            Filter filter
    ) {

        if (filter.block() == null
                || filter.block().isEmpty()) {
            return;
        }

        JsonObject obj = new JsonObject();

        JsonArray block = new JsonArray();

        filter.block().forEach(location -> {

            JsonObject entry = new JsonObject();

            if (location.getNamespace() != null) {
                entry.addProperty(
                        "namespace",
                        location.getNamespace()
                );
            }

            if (location.getPath() != null) {
                entry.addProperty(
                        "path",
                        location.getPath()
                );
            }

            block.add(entry);
        });

        obj.add("block", block);

        root.add("filter", obj);
    }

    private static void serializeOverlays(
            JsonObject root,
            Overlays overlays
    ) {
        JsonObject obj = new JsonObject();

        JsonArray entries = new JsonArray();

        for (OverlayEntry overlay :
                overlays.entries()) {

            JsonObject entry = new JsonObject();

            entry.addProperty(
                    "directory",
                    overlay.directory()
            );

            writeVersion(
                    entry,
                    "min_format",
                    overlay.version()
            );

            writeVersion(
                    entry,
                    "max_format",
                    overlay.version()
            );

            if (overlay.formats() != null) {
                entry.add(
                        "formats",
                        serializeFormatRange(
                                overlay.formats()
                        )
                );
            }

            entries.add(entry);
        }

        obj.add("entries", entries);

        root.add("overlays", obj);
    }

    private static void serializeLanguages(
            JsonObject root,
            Map<String, LanguageDefinition> languages
    ) {

        if (languages.isEmpty()) {
            return;
        }

        JsonObject language = new JsonObject();

        languages.forEach((code, definition) -> {

            JsonObject lang = new JsonObject();

            if (definition.name() != null) {
                lang.addProperty(
                        "name",
                        definition.name()
                );
            }

            if (definition.region() != null) {
                lang.addProperty(
                        "region",
                        definition.region()
                );
            }

            lang.addProperty(
                    "bidirectional",
                    definition.bidirectional()
            );

            language.add(code, lang);
        });

        root.add("language", language);
    }

    private static JsonElement serializeFormatRange(
            FormatRange range
    ) {

        if (range instanceof SingleFormat single) {
            return new JsonPrimitive(
                    single.value()
            );
        }

        FormatInterval interval =
                (FormatInterval) range;

        JsonObject obj = new JsonObject();

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

    private static void writeVersion(
            JsonObject parent,
            String key,
            Version version
    ) {

        JsonArray arr = new JsonArray();

        arr.add(version.major());
        arr.add(version.minor());

        parent.add(key, arr);
    }
}