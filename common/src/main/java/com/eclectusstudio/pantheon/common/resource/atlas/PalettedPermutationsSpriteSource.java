package com.eclectusstudio.pantheon.common.resource.atlas;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PalettedPermutationsSpriteSource implements SpriteSource {

    private final List<ResourceLocation> textures = new ArrayList<>();
    private String separator = "_";
    private ResourceLocation paletteKey;
    private final Map<String, ResourceLocation> permutations =
            new LinkedHashMap<>();

    public PalettedPermutationsSpriteSource(
            ResourceLocation paletteKey
    ) {
        this.paletteKey = paletteKey;
    }

    @Override
    public String getType() {
        return "minecraft:paletted_permutations";
    }

    public PalettedPermutationsSpriteSource addTexture(
            ResourceLocation texture
    ) {
        textures.add(texture);

        return this;
    }

    public PalettedPermutationsSpriteSource setSeparator(
            String separator
    ) {
        this.separator = separator;

        return this;
    }

    public PalettedPermutationsSpriteSource addPermutation(
            String suffix,
            ResourceLocation palette
    ) {
        permutations.put(
                suffix,
                palette
        );

        return this;
    }

    public List<ResourceLocation> getTextures() {
        return textures;
    }

    public String getSeparator() {
        return separator;
    }

    public ResourceLocation getPaletteKey() {
        return paletteKey;
    }

    public Map<String, ResourceLocation> getPermutations() {
        return permutations;
    }
}
