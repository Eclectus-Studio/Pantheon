package com.eclectusstudio.pantheon.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public final class ResourcePackZipper {

    public static void zipContents(
            File sourceDirectory,
            File zipFile
    ) throws IOException {

        try (
                ZipOutputStream zos =
                        new ZipOutputStream(
                                new FileOutputStream(zipFile)
                        )
        ) {

            File[] children =
                    sourceDirectory.listFiles();

            if (children == null) {
                return;
            }

            for (File child : children) {
                addToZip(
                        child,
                        child.getName(),
                        zos
                );
            }
        }
    }

    private static void addToZip(
            File file,
            String entryName,
            ZipOutputStream zos
    ) throws IOException {

        if (file.isDirectory()) {

            File[] children = file.listFiles();

            if (children != null) {

                for (File child : children) {

                    addToZip(
                            child,
                            entryName + "/" + child.getName(),
                            zos
                    );
                }
            }

            return;
        }

        zos.putNextEntry(
                new ZipEntry(entryName)
        );

        Files.copy(
                file.toPath(),
                zos
        );

        zos.closeEntry();
    }
}