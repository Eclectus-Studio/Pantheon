package com.eclectusstudio.pantheon.common.api.font;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.fonts.BitmapFontProvider;

public class RankTemplate {

    private final char character;
    private final ResourceLocation texture;

    private int ascent = 7;
    private int height = 8;


    public RankTemplate(
            char character,
            ResourceLocation texture
    ) {
        this.character = character;
        this.texture = texture;
    }


    public RankTemplate ascent(int ascent) {
        this.ascent = ascent;
        return this;
    }


    public RankTemplate height(int height) {
        this.height = height;
        return this;
    }


    public BitmapFontProvider build() {

        BitmapFontProvider provider =
                new BitmapFontProvider();

        provider.setFile(texture);

        provider.setAscent(ascent);
        provider.setHeight(height);

        provider.getChars()
                .add(
                        String.valueOf(character)
                );

        return provider;
    }
}