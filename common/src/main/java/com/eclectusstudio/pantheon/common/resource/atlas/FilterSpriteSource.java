package com.eclectusstudio.pantheon.common.resource.atlas;

public class FilterSpriteSource implements SpriteSource {

    private final String namespace;
    private final String path;

    public FilterSpriteSource(
            String namespace,
            String path
    ) {
        this.namespace = namespace;
        this.path = path;
    }

    public FilterSpriteSource(
            String path
    ) {
        this(null, path);
    }

    @Override
    public String getType() {
        return "minecraft:filter";
    }

    public String getNamespace() {
        return namespace;
    }

    public String getPath() {
        return path;
    }
}
