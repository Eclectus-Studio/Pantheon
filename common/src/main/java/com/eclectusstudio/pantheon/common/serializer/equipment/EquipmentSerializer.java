package com.eclectusstudio.pantheon.common.serializer.equipment;

import com.eclectusstudio.pantheon.common.resource.equipment.DyeableEquipmentLayer;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayer;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public final class EquipmentSerializer {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private EquipmentSerializer() {}

    public static void serialize(
            Path assetsFolder,
            String namespace,
            String name,
            Equipment equipment
    ) throws IOException {

        Path file = assetsFolder
                .resolve(namespace)
                .resolve("equipment")
                .resolve(name + ".json");

        Files.createDirectories(file.getParent());

        // Load existing data exists
        JsonObject root;
        if (Files.exists(file)) {
            try (var reader = Files.newBufferedReader(file)) {
                root = JsonParser.parseReader(reader).getAsJsonObject();
            } catch (Exception e) {
                // If the file is corrupted/empty, fallback to a clean object
                root = new JsonObject();
            }
        } else {
            root = new JsonObject();
        }

        JsonObject layersObject;
        if (root.has("layers") && root.get("layers").isJsonObject()) {
            layersObject = root.getAsJsonObject("layers");
        } else {
            layersObject = new JsonObject();
            root.add("layers", layersObject);
        }

        // Process and merge incoming layers
        for (Map.Entry<EquipmentLayerType, List<EquipmentLayer>> entry
                : equipment.getLayers().entrySet()) {

            String layerKey = entry.getKey().getId();

            // Get the existing array for this layer type (e.g., "humanoid"), or create a new one
            JsonArray layerArray;
            if (layersObject.has(layerKey) && layersObject.get(layerKey).isJsonArray()) {
                layerArray = layersObject.getAsJsonArray(layerKey);
            } else {
                layerArray = new JsonArray();
                layersObject.add(layerKey, layerArray);
            }

            for (EquipmentLayer layer : entry.getValue()) {

                JsonObject layerObject = new JsonObject();

                layerObject.addProperty(
                        "texture",
                        layer.getTexture().toString()
                );

                DyeableEquipmentLayer dyeable = layer.getDyeable();

                if (dyeable != null) {

                    JsonObject dyeableObject = new JsonObject();

                    if (dyeable.getColorWhenUndyed() != null) {
                        dyeableObject.addProperty(
                                "color_when_undyed",
                                dyeable.getColorWhenUndyed()
                        );
                    }

                    layerObject.add(
                            "dyeable",
                            dyeableObject
                    );
                }

                if (layer.isUsePlayerTexture()) {
                    layerObject.addProperty(
                            "use_player_texture",
                            true
                    );
                }

                // Append the new layer to the existing array
                layerArray.add(layerObject);
            }
        }

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }
}