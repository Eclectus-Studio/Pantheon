package com.eclectusstudio.pantheon.common;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ResourcePackContext {
    public static void extractFolder(String resourceFolder, Path destination)
            throws IOException, URISyntaxException, ClassNotFoundException {

        Class<?> caller = getCallerClass();

        if (!resourceFolder.endsWith("/")) {
            resourceFolder += "/";
        }

        CodeSource codeSource =
                caller.getProtectionDomain().getCodeSource();

        Path jarPath = Path.of(codeSource.getLocation().toURI());

        try (JarFile jar = new JarFile(jarPath.toFile())) {

            var entries = jar.entries();

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
                    continue;
                }

                Files.createDirectories(target.getParent());

                try (InputStream in = jar.getInputStream(entry)) {
                    Files.copy(in, target,
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    private static Class<?> getCallerClass()
            throws ClassNotFoundException {

        StackTraceElement[] stack = Thread.currentThread().getStackTrace();

        // 0 = Thread.getStackTrace
        // 1 = getCallerClass
        // 2 = extractFolder
        // 3 = actual caller

        String callerClassName = stack[3].getClassName();

        return Class.forName(callerClassName);
    }
}