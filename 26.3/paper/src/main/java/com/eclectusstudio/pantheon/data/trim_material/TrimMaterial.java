package com.eclectusstudio.pantheon.data.trim_material;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import net.kyori.adventure.text.TextComponent;

public class TrimMaterial {
    private final ResourceLocation location;

    private final ResourceLocation paletteId;
    private final TextComponent description;

    public TrimMaterial(ResourceLocation location, ResourceLocation paletteId, TextComponent description) {
        this.location = location;
        this.paletteId = paletteId;
        this.description = description;
    }

    public ResourceLocation getLocation() { return location; }
    public ResourceLocation getPaletteId() { return paletteId; }
    public TextComponent getDescription() { return description; }
}