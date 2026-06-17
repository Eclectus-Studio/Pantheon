package com.eclectusstudio.pantheon.common;

import java.util.Objects;

public class ResourceLocation {
    private final String namespace;
    private final String path;

    public ResourceLocation(String namespace, String path){
        this.namespace = namespace;
        this.path = path;
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }

    public static ResourceLocation fromString(
            String value
    ) {

        String[] split =
                value.split(":", 2);

        if (split.length != 2) {
            throw new IllegalArgumentException(
                    "Invalid resource location: " + value
            );
        }

        return new ResourceLocation(
                split[0],
                split[1]
        );
    }

    // Crucial for HashMap lookups
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceLocation that = (ResourceLocation) o;
        return Objects.equals(namespace, that.namespace) &&
                Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, path);
    }

    // Helpful for debugging logs
    @Override
    public String toString() {
        return namespace + ":" + path;
    }
}