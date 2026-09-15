package com.eclectusstudio.pantheon.common.serializer.texts;

import com.eclectusstudio.pantheon.common.resource.texts.Credits;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class CreditsSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private CreditsSerializer() {}

    public static void serialize(
            Path assetsFolder,
            Credits credits
    ) throws IOException {

        if (credits == null
                || credits.getLocation() == null
                || credits.getSections().isEmpty()) {
            return;
        }

        JsonArray root = new JsonArray();

        for (Credits.Section section :
                credits.getSections()) {

            root.add(
                    serializeSection(section)
            );
        }

        Path file = assetsFolder
                .resolve(
                        credits
                                .getLocation()
                                .getNamespace()
                )
                .resolve("credits.json");

        Files.createDirectories(
                file.getParent()
        );

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }

    private static JsonObject serializeSection(
            Credits.Section section
    ) {

        JsonObject object = new JsonObject();

        object.addProperty(
                "section",
                section.getSection()
        );

        JsonArray disciplines = new JsonArray();

        for (Credits.Discipline discipline :
                section.getDisciplines()) {

            disciplines.add(
                    serializeDiscipline(discipline)
            );
        }

        object.add(
                "disciplines",
                disciplines
        );

        return object;
    }

    private static JsonObject serializeDiscipline(
            Credits.Discipline discipline
    ) {

        JsonObject object = new JsonObject();

        object.addProperty(
                "discipline",
                discipline.getDiscipline()
        );

        JsonArray titles = new JsonArray();

        for (Credits.Title title :
                discipline.getTitles()) {

            titles.add(
                    serializeTitle(title)
            );
        }

        object.add(
                "titles",
                titles
        );

        return object;
    }

    private static JsonObject serializeTitle(
            Credits.Title title
    ) {

        JsonObject object = new JsonObject();

        object.addProperty(
                "title",
                title.getTitle()
        );

        JsonArray names = new JsonArray();

        for (String name :
                title.getNames()) {

            names.add(name);
        }

        object.add(
                "names",
                names
        );

        return object;
    }
}
