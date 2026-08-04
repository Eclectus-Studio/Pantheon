package com.eclectusstudio.pantheon.common;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ResourcePackContext {
    public static void extractFolder(
            Class<?> sourceClass,
            String resourceFolder,
            Path destination
    ) throws IOException, URISyntaxException {

        if (!resourceFolder.endsWith("/")) {
            resourceFolder += "/";
        }

        CodeSource codeSource = sourceClass
                .getProtectionDomain()
                .getCodeSource();

        Path jarPath = Path.of(codeSource.getLocation().toURI());

        try (JarFile jar = new JarFile(jarPath.toFile())) {
            Enumeration<JarEntry> entries = jar.entries();

            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();

                String name = entry.getName();

                if (!name.startsWith(resourceFolder)) {
                    continue;
                }

                String relative = name.substring(resourceFolder.length());

                if (relative.isEmpty()) {
                    continue;
                }

                Path target = destination.resolve(relative);

                if (entry.isDirectory()) {
                    Files.createDirectories(target);
                } else {
                    Files.createDirectories(target.getParent());

                    try (InputStream in = jar.getInputStream(entry)) {
                        Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
        }
    }
}