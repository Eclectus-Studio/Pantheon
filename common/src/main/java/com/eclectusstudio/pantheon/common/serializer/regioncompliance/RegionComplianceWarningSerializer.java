package com.eclectusstudio.pantheon.common.serializer.regioncompliance;

import com.eclectusstudio.pantheon.common.resource.regioncompliance.RegionComplianceWarning;
import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class RegionComplianceWarningSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private RegionComplianceWarningSerializer() {}

    public static void serialize(
            Path assetsFolder,
            String namespace,
            List<RegionComplianceWarning> warnings
    ) throws IOException {

        Path file =
                assetsFolder
                        .resolve(namespace)
                        .resolve("regional_compliancies.json");

        Files.createDirectories(file.getParent());

        JsonObject root =
                new JsonObject();

        for (RegionComplianceWarning warning : warnings) {

            JsonArray region =
                    root.has(warning.getRegion())
                            ? root.getAsJsonArray(warning.getRegion())
                            : new JsonArray();

            JsonObject object =
                    new JsonObject();

            if (warning.getDelay() != null) {
                object.addProperty(
                        "delay",
                        warning.getDelay()
                );
            }

            object.addProperty(
                    "period",
                    warning.getPeriod()
            );

            object.addProperty(
                    "title",
                    warning.getTitle()
            );

            object.addProperty(
                    "message",
                    warning.getMessage()
            );

            region.add(object);

            root.add(
                    warning.getRegion(),
                    region
            );
        }

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }
}
