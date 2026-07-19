package com.eclectusstudio.pantheon.common.serializer.sounds;

import com.eclectusstudio.pantheon.common.resource.sounds.SoundDefinition;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundEvent;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundType;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundsFile;
import com.google.gson.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public final class SoundsSerializer {

    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    private SoundsSerializer() {}

    public static void serialize(
            Path assetsFolder,
            SoundsFile soundsFile
    ) throws IOException {

        if (soundsFile == null
                || soundsFile.getLocation() == null
                || soundsFile.getSoundEvents().isEmpty()) {
            return;
        }

        JsonObject root = new JsonObject();

        for (SoundEvent event : soundsFile.getSoundEvents()) {

            if (event.getId() == null || event.getId().isBlank()) {
                throw new IllegalStateException(
                        "Encountered a SoundEvent without an id."
                );
            }

            root.add(
                    event.getId(),
                    serializeEvent(event)
            );
        }

        Path file = assetsFolder
                .resolve(soundsFile.getLocation().getNamespace())
                .resolve("sounds.json");

        Files.createDirectories(file.getParent());

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }

    private static JsonObject serializeEvent(
            SoundEvent event
    ) {

        JsonObject object = new JsonObject();

        if (event.isReplace()) {
            object.addProperty(
                    "replace",
                    true
            );
        }

        if (event.getSubtitle() != null) {
            object.addProperty(
                    "subtitle",
                    event.getSubtitle()
            );
        }

        if (event.getSounds() != null
                && !event.getSounds().isEmpty()) {

            JsonArray sounds = new JsonArray();

            for (SoundDefinition sound
                    : event.getSounds()) {

                sounds.add(
                        serializeSound(sound)
                );
            }

            object.add(
                    "sounds",
                    sounds
            );
        }

        return object;
    }

    private static JsonElement serializeSound(
            SoundDefinition sound
    ) {

        if (isSimple(sound)) {
            return new JsonPrimitive(
                    sound.getName()
            );
        }

        JsonObject object = new JsonObject();

        object.addProperty(
                "name",
                sound.getName()
        );

        if (sound.getVolume() != 1.0F) {
            object.addProperty(
                    "volume",
                    sound.getVolume()
            );
        }

        if (sound.getPitch() != 1.0F) {
            object.addProperty(
                    "pitch",
                    sound.getPitch()
            );
        }

        if (sound.getWeight() != 1) {
            object.addProperty(
                    "weight",
                    sound.getWeight()
            );
        }

        if (sound.isStream()) {
            object.addProperty(
                    "stream",
                    true
            );
        }

        if (sound.getAttenuationDistance() != 16) {
            object.addProperty(
                    "attenuation_distance",
                    sound.getAttenuationDistance()
            );
        }

        if (sound.isPreload()) {
            object.addProperty(
                    "preload",
                    true
            );
        }

        if (sound.getType() != null
                && sound.getType() != SoundType.FILE) {

            object.addProperty(
                    "type",
                    sound.getType().getId()
            );
        }

        return object;
    }

    private static boolean isSimple(
            SoundDefinition sound
    ) {

        return sound != null
                && sound.getName() != null
                && sound.getVolume() == 1.0F
                && sound.getPitch() == 1.0F
                && sound.getWeight() == 1
                && !sound.isStream()
                && sound.getAttenuationDistance() == 16
                && !sound.isPreload()
                && (sound.getType() == null
                || sound.getType() == SoundType.FILE);
    }
}