package com.eclectusstudio.pantheon.utils;

import java.io.File;

public final class FileUtils {

    public static void deleteRecursively(File file) {
        if (!file.exists()) {
            return;
        }

        if (file.isDirectory()) {
            File[] children = file.listFiles();

            if (children != null) {
                for (File child : children) {
                    deleteRecursively(child);
                }
            }
        }

        file.delete();
    }
}