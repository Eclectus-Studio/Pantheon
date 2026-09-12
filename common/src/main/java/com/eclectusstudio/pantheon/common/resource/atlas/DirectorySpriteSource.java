package com.eclectusstudio.pantheon.common.resource.atlas;

public class DirectorySpriteSource implements SpriteSource {

    private final String source;
    private final String prefix;

    public DirectorySpriteSource(
            String source,
            String prefix
    ) {
        this.source = source;
        this.prefix = prefix;
    }

    @Override
    public String getType() {
        return "minecraft:directory";
    }

    public String getSource() {
        return source;
    }

    public String getPrefix() {
        return prefix;
    }
}
