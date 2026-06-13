package com.eclectusstudio.pantheon.common.serializer.items;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.items.*;
import com.eclectusstudio.pantheon.common.resource.items.node.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public final class ItemSerializer {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private ItemSerializer() {}

    public static void serialize(
            Path assetsFolder,
            ResourceLocation location,
            ItemModels item
    ) throws IOException {

        Path file = assetsFolder
                .resolve(location.getNamespace())
                .resolve("items")
                .resolve(location.getPath() + ".json");

        Files.createDirectories(file.getParent());

        JsonObject root = new JsonObject();

        root.addProperty(
                "hand_animation_on_swap",
                item.isHandAnimationOnSwap()
        );

        root.addProperty(
                "oversized_in_gui",
                item.isOversizedInGui()
        );

        root.addProperty(
                "swap_animation_scale",
                item.getSwapAnimationScale()
        );

        if (item.getModel() != null
                && item.getModel().getModel() != null) {

            root.add(
                    "model",
                    serializeNode(item.getModel().getModel())
            );
        }

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }

    private static JsonObject serializeNode(
            ItemModelNode node
    ) {

        JsonObject json = new JsonObject();

        json.addProperty(
                "type",
                node.type()
        );

        if (node instanceof EmptyNode) {
            return json;
        }

        if (node instanceof ModelNode model) {

            json.addProperty(
                    "model",
                    model.getModel().toString()
            );

            return json;
        }

        if (node instanceof CompositeNode composite) {

            JsonArray models = new JsonArray();

            for (ItemModelNode child :
                    composite.getModels()) {

                models.add(
                        serializeNode(child)
                );
            }

            json.add("models", models);

            return json;
        }

        if (node instanceof ConditionNode condition) {

            json.addProperty(
                    "property",
                    condition.getProperty()
            );

            json.add(
                    "on_true",
                    serializeNode(
                            condition.getOnTrue()
                    )
            );

            json.add(
                    "on_false",
                    serializeNode(
                            condition.getOnFalse()
                    )
            );

            return json;
        }

        if (node instanceof SelectNode select) {

            json.addProperty(
                    "property",
                    select.getProperty()
            );

            JsonArray cases = new JsonArray();

            for (SelectNode.Case c :
                    select.getCases()) {

                JsonObject caseJson =
                        new JsonObject();

                if (c.when instanceof List<?> list) {

                    JsonArray when =
                            new JsonArray();

                    for (Object value : list) {
                        when.add(
                                String.valueOf(value)
                        );
                    }

                    caseJson.add(
                            "when",
                            when
                    );

                } else {

                    caseJson.addProperty(
                            "when",
                            String.valueOf(c.when)
                    );
                }

                caseJson.add(
                        "model",
                        serializeNode(c.model)
                );

                cases.add(caseJson);
            }

            json.add("cases", cases);

            if (select.getFallback() != null) {

                json.add(
                        "fallback",
                        serializeNode(
                                select.getFallback()
                        )
                );
            }

            return json;
        }

        if (node instanceof RangeDispatchNode range) {

            json.addProperty(
                    "property",
                    range.getProperty()
            );

            JsonArray entries =
                    new JsonArray();

            for (RangeDispatchNode.Entry entry :
                    range.getEntries()) {

                JsonObject entryJson =
                        new JsonObject();

                entryJson.addProperty(
                        "threshold",
                        entry.threshold
                );

                entryJson.add(
                        "model",
                        serializeNode(
                                entry.model
                        )
                );

                entries.add(entryJson);
            }

            json.add(
                    "entries",
                    entries
            );

            return json;
        }

        if (node instanceof SpecialNode special) {

            JsonObject model =
                    new JsonObject();

            model.addProperty(
                    "type",
                    special.getSpecialType()
                            .name()
                            .toLowerCase()
            );

            if (special.getBase() != null) {

                model.addProperty(
                        "base",
                        special.getBase()
                );
            }

            json.add("model", model);

            return json;
        }

        throw new IllegalStateException(
                "Unknown node: "
                        + node.getClass()
        );
    }
}