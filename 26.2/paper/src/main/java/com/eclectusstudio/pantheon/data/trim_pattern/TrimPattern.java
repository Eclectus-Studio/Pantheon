package com.eclectusstudio.pantheon.data.trim_pattern;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import net.kyori.adventure.text.TextComponent;

public class TrimPattern {
    private final ResourceLocation location;

    private final ResourceLocation assetID;
    private final boolean decal;
    private final TextComponent description;

    public TrimPattern(ResourceLocation location, ResourceLocation assetID, boolean decal, TextComponent description) {
        this.location = location;
        this.assetID = assetID;
        this.decal = decal;
        this.description = description;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public ResourceLocation getAssetID() {
        return assetID;
    }

    public boolean isDecal() {
        return decal;
    }

    public TextComponent getDescription() {
        return description;
    }
}
