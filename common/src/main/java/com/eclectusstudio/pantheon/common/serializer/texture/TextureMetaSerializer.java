package com.eclectusstudio.pantheon.common.serializer.texture;

import com.eclectusstudio.pantheon.common.resource.texture.Animation;
import com.eclectusstudio.pantheon.common.resource.texture.Frame;
import com.eclectusstudio.pantheon.common.resource.texture.Gui;
import com.eclectusstudio.pantheon.common.resource.texture.Scaling;
import com.eclectusstudio.pantheon.common.resource.texture.TextureMeta;
import com.eclectusstudio.pantheon.common.resource.texture.Villager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class TextureMetaSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private TextureMetaSerializer() {}

    public static void serialize(
            Path assetsFolder,
            TextureMeta textureMeta
    ) throws IOException {

        Path file =
                assetsFolder
                        .resolve(
                                textureMeta
                                        .getLocation()
                                        .getNamespace()
                        )
                        .resolve("textures")
                        .resolve(
                                textureMeta
                                        .getLocation()
                                        .getPath()
                                        + ".mcmeta"
                        );

        Files.createDirectories(
                file.getParent()
        );

        JsonObject root =
                new JsonObject();

        if (textureMeta.getAnimation() != null) {
            root.add(
                    "animation",
                    serializeAnimation(
                            textureMeta.getAnimation()
                    )
            );
        }

        if (textureMeta.getVillager() != null) {
            root.add(
                    "villager",
                    serializeVillager(
                            textureMeta.getVillager()
                    )
            );
        }

        if (textureMeta.getGui() != null) {
            root.add(
                    "gui",
                    serializeGui(
                            textureMeta.getGui()
                    )
            );
        }

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }

    private static JsonObject serializeAnimation(
            Animation animation
    ) {

        JsonObject json =
                new JsonObject();

        if (animation.getInterpolate() != null) {
            json.addProperty(
                    "interpolate",
                    animation.getInterpolate()
            );
        }

        if (animation.getWidth() != null) {
            json.addProperty(
                    "width",
                    animation.getWidth()
            );
        }

        if (animation.getHeight() != null) {
            json.addProperty(
                    "height",
                    animation.getHeight()
            );
        }

        if (animation.getFrametime() != null) {
            json.addProperty(
                    "frametime",
                    animation.getFrametime()
            );
        }

        if (animation.getFrames() != null) {

            JsonArray frames =
                    new JsonArray();

            for (Frame frame :
                    animation.getFrames()) {

                if (frame.getTime() == null) {

                    frames.add(
                            frame.getIndex()
                    );

                } else {

                    JsonObject frameObject =
                            new JsonObject();

                    frameObject.addProperty(
                            "index",
                            frame.getIndex()
                    );

                    frameObject.addProperty(
                            "time",
                            frame.getTime()
                    );

                    frames.add(
                            frameObject
                    );
                }
            }

            json.add(
                    "frames",
                    frames
            );
        }

        return json;
    }

    private static JsonObject serializeVillager(
            Villager villager
    ) {

        JsonObject json =
                new JsonObject();

        if (villager.getHat() != null) {

            json.addProperty(
                    "hat",
                    switch (villager.getHat()) {
                        case FULL -> "full";
                        case PARTIAL -> "partial";
                        case DEFAULT -> "default";
                    }
            );
        }

        return json;
    }

    private static JsonObject serializeGui(
            Gui gui
    ) {

        JsonObject json =
                new JsonObject();

        if (gui.getScaling() != null) {

            json.add(
                    "scaling",
                    serializeScaling(
                            gui.getScaling()
                    )
            );
        }

        return json;
    }

    private static JsonObject serializeScaling(
            Scaling scaling
    ) {

        JsonObject json =
                new JsonObject();

        if (scaling.getType() != null) {

            json.addProperty(
                    "type",
                    switch (scaling.getType()) {
                        case STRETCH -> "stretch";
                        case TILE -> "tile";
                        case NINE_SLICE -> "nine_slice";
                    }
            );
        }

        if (scaling.getWidth() != null) {
            json.addProperty(
                    "width",
                    scaling.getWidth()
            );
        }

        if (scaling.getHeight() != null) {
            json.addProperty(
                    "height",
                    scaling.getHeight()
            );
        }

        if (scaling.getStretchInner() != null) {
            json.addProperty(
                    "stretch_inner",
                    scaling.getStretchInner()
            );
        }

        if (scaling.getBorder() != null) {
            json.addProperty(
                    "border",
                    scaling.getBorder()
            );
        }

        return json;
    }
}
