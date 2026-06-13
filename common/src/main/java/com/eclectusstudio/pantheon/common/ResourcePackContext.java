package com.eclectusstudio.pantheon.common;

import java.io.*;
import java.net.URL;
import java.nio.file.*;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ResourcePackContext {

    private final File root;
    private final ClassLoader loader;

    public ResourcePackContext(File root, ClassLoader loader) {
        this.root = root;
        this.loader = loader;
    }

    public void importFolder(String namespace, String jarPath) {

        try {

            Enumeration<URL> resources =
                    loader.getResources(jarPath);

            while (resources.hasMoreElements()) {

                URL url = resources.nextElement();

                if (url.getProtocol().equals("jar")) {

                    String path = url.getPath();

                    String jarFilePath =
                            path.substring(5, path.indexOf("!"));

                    try (JarFile jar = new JarFile(jarFilePath)) {

                        Enumeration<JarEntry> entries =
                                jar.entries();

                        while (entries.hasMoreElements()) {

                            JarEntry entry = entries.nextElement();

                            if (entry.isDirectory()) continue;

                            if (!entry.getName().startsWith(jarPath)) continue;

                            String relative =
                                    entry.getName().substring(jarPath.length());

                            copyEntry(
                                    jar,
                                    entry,
                                    namespace,
                                    relative
                            );
                        }
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to import jar folder: " + jarPath, e);
        }
    }

    private void copyEntry(
            JarFile jar,
            JarEntry entry,
            String namespace,
            String relativePath
    ) throws IOException {

        InputStream in =
                jar.getInputStream(entry);

        File out = new File(
                root,
                "assets/" + namespace + "/" + relativePath
        );

        out.getParentFile().mkdirs();

        Files.copy(
                in,
                out.toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );
    }
}