package com.eclectusstudio.pantheon.common.serializer.blockstate;

import com.eclectusstudio.pantheon.common.resource.blockstate.BlockStateDefinition;
import com.eclectusstudio.pantheon.common.resource.blockstate.Condition;
import com.eclectusstudio.pantheon.common.resource.blockstate.ModelVariant;
import com.eclectusstudio.pantheon.common.resource.blockstate.MultipartRule;
import com.eclectusstudio.pantheon.common.resource.blockstate.VariantGroup;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public final class BlockStateSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private BlockStateSerializer() {}

    public static void serialize(
            Path assetsFolder,
            BlockStateDefinition definition
    ) throws IOException {

        Path file =
                assetsFolder
                        .resolve(
                                definition
                                        .getLocation()
                                        .getNamespace()
                        )
                        .resolve("blockstates")
                        .resolve(
                                definition
                                        .getLocation()
                                        .getPath()
                                        + ".json"
                        );

        Files.createDirectories(file.getParent());

        JsonObject root = new JsonObject();

        if (definition.getVariants() != null) {

            JsonObject variants = new JsonObject();

            for (Map.Entry<String, VariantGroup> entry :
                    definition.getVariants().entrySet()) {

                variants.add(
                        entry.getKey(),
                        serializeVariantGroup(entry.getValue())
                );
            }

            root.add("variants", variants);
        }

        if (definition.getMultipart() != null) {

            JsonArray multipart = new JsonArray();

            for (MultipartRule rule :
                    definition.getMultipart()) {

                multipart.add(
                        serializeMultipartRule(rule)
                );
            }

            root.add("multipart", multipart);
        }

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }

    private static JsonElement serializeVariantGroup(
            VariantGroup group
    ) {

        if (group.getVariants().size() == 1) {

            return serializeModelVariant(
                    group.getVariants().get(0)
            );
        }

        JsonArray models = new JsonArray();

        for (ModelVariant variant :
                group.getVariants()) {

            models.add(
                    serializeModelVariant(variant)
            );
        }

        return models;
    }

    private static JsonObject serializeModelVariant(
            ModelVariant variant
    ) {

        JsonObject json = new JsonObject();

        json.addProperty(
                "model",
                variant.getModel().toString()
        );

        if (variant.getX() != 0) {
            json.addProperty(
                    "x",
                    variant.getX()
            );
        }

        if (variant.getY() != 0) {
            json.addProperty(
                    "y",
                    variant.getY()
            );
        }

        if (variant.getZ() != 0) {
            json.addProperty(
                    "z",
                    variant.getZ()
            );
        }

        if (variant.isUvlock()) {
            json.addProperty(
                    "uvlock",
                    true
            );
        }

        if (variant.getWeight() != 1) {
            json.addProperty(
                    "weight",
                    variant.getWeight()
            );
        }

        return json;
    }

    private static JsonObject serializeMultipartRule(
            MultipartRule rule
    ) {

        JsonObject json = new JsonObject();

        if (rule.getWhen() != null) {

            json.add(
                    "when",
                    serializeCondition(rule.getWhen())
            );
        }

        json.add(
                "apply",
                serializeVariantGroup(rule.getApply())
        );

        return json;
    }

    private static JsonObject serializeCondition(
            Condition condition
    ) {

        JsonObject json = new JsonObject();

        if (condition.getOr() != null) {

            JsonArray conditions = new JsonArray();

            for (Condition child :
                    condition.getOr()) {

                conditions.add(
                        serializeCondition(child)
                );
            }

            json.add("OR", conditions);

            return json;
        }

        if (condition.getAnd() != null) {

            JsonArray conditions = new JsonArray();

            for (Condition child :
                    condition.getAnd()) {

                conditions.add(
                        serializeCondition(child)
                );
            }

            json.add("AND", conditions);

            return json;
        }

        for (Map.Entry<String, String> entry :
                condition.getStates().entrySet()) {

            json.addProperty(
                    entry.getKey(),
                    entry.getValue()
            );
        }

        return json;
    }
}
