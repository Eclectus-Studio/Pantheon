package com.eclectusstudio.pantheon.common.serializer.equipment;

import com.eclectusstudio.pantheon.common.resource.equipment.DyeableEquipmentLayer;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayer;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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

        JsonObject root = new JsonObject();
        JsonObject layersObject = new JsonObject();

        for (Map.Entry<EquipmentLayerType, List<EquipmentLayer>> entry
                : equipment.getLayers().entrySet()) {

            JsonArray layerArray = new JsonArray();

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

                layerArray.add(layerObject);
            }

            layersObject.add(
                    entry.getKey().getId(),
                    layerArray
            );
        }

        root.add(
                "layers",
                layersObject
        );

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }
}