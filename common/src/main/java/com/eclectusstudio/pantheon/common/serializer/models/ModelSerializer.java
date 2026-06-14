package com.eclectusstudio.pantheon.common.serializer.models;

import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ModelSerializer {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public static void serialize(
            Path assetsFolder,
            String namespace,
            String name,
            ItemModelDefinition model
    ) throws IOException {

        Path file = assetsFolder
                .resolve(namespace)
                .resolve("models/item")
                .resolve(name + ".json");

        Files.createDirectories(file.getParent());

        JsonObject root = new JsonObject();

        if (model.getParent() != null) {
            root.addProperty("parent", model.getParent().toString());
        }

        if (model.getTextures() != null) {
            JsonObject textures = new JsonObject();
            model.getTextures().getAll()
                    .forEach(textures::addProperty);
            root.add("textures", textures);
        }

        if (model.getDisplay() != null) {
            JsonObject display = new JsonObject();

            model.getDisplay().getAll().forEach((k, v) -> {
                JsonObject t = new JsonObject();

                if (v.rotation != null) t.add("rotation", GSON.toJsonTree(v.rotation));
                if (v.translation != null) t.add("translation", GSON.toJsonTree(v.translation));
                if (v.scale != null) t.add("scale", GSON.toJsonTree(v.scale));

                display.add(k, t);
            });

            root.add("display", display);
        }

        Files.writeString(file, GSON.toJson(root));
    }
}