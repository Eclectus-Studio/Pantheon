package com.eclectusstudio.pantheon.common.serializer.language;

import com.eclectusstudio.pantheon.common.resource.language.Language;
import com.eclectusstudio.pantheon.common.resource.language.TranslationResult;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class LanguageSerializer {

    private static final Gson GSON =
            new GsonBuilder()
                    .setPrettyPrinting()
                    .create();

    private LanguageSerializer() {}

    public static void serialize(
            Path assetsFolder,
            String namespace,
            Language language
    ) throws IOException {

        Path file =
                assetsFolder
                        .resolve(namespace)
                        .resolve("lang")
                        .resolve(language.getLanguage().name() + ".json");

        Files.createDirectories(file.getParent());

        JsonObject root =
                new JsonObject();

        for (TranslationResult translation :
                language.getTranslations()) {

            root.addProperty(
                    translation.getKey().getKey(),
                    translation.getResult()
            );
        }

        Files.writeString(
                file,
                GSON.toJson(root)
        );
    }
}
