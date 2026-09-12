package com.eclectusstudio.pantheon.common.serializer.waypointstyle;

import com.eclectusstudio.pantheon.common.resource.waypointstyle.WaypointStyle;
import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class WaypointStyleSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private WaypointStyleSerializer() {}

    public static void serialize(
            Path assetsFolder,
            String namespace,
            String name,
            WaypointStyle style
    ) throws IOException {

        Path file =
                assetsFolder
                        .resolve(namespace)
                        .resolve("waypoint_style")
                        .resolve(name + ".json");

        Files.createDirectories(file.getParent());

        JsonObject root =
                new JsonObject();

        root.addProperty(
                "near_distance",
                style.getNearDistance()
        );

        root.addProperty(
                "far_distance",
                style.getFarDistance()
        );

        JsonArray sprites =
                new JsonArray();

        for (var sprite :
                style.getSprites()) {

            sprites.add(
                    sprite.toString()
            );
        }

        root.add(
                "sprites",
                sprites
        );

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }
}
