package com.eclectusstudio.pantheon.data.trim_material;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.language.TranslationKey;
import net.kyori.adventure.text.TextComponent;

public class TrimMaterial {
    private final ResourceLocation location;

    private final TranslationKey translationKey;
    private ResourceLocation overwriteArmorAssets;
    private final TextComponent description;

    public TrimMaterial(ResourceLocation location, TranslationKey translationKey, ResourceLocation overwriteArmorAssets, TextComponent description) {
        this.location = location;
        this.translationKey = translationKey;
        this.overwriteArmorAssets = overwriteArmorAssets;
        this.description = description;
    }

    public TrimMaterial(ResourceLocation location, TranslationKey translationKey, TextComponent description) {
        this.location = location;
        this.translationKey = translationKey;
        this.description = description;
    }

    public void setOverwriteArmorAssets(ResourceLocation overwriteArmorAssets) {
        this.overwriteArmorAssets = overwriteArmorAssets;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public TranslationKey getTranslationKey() {
        return translationKey;
    }

    public ResourceLocation getOverwriteArmorAssets() {
        return overwriteArmorAssets;
    }

    public TextComponent getDescription() {
        return description;
    }
}
