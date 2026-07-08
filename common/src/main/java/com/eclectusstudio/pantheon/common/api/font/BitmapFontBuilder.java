package com.eclectusstudio.pantheon.common.api.font;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.fonts.*;

import java.util.ArrayList;

public class BitmapFontBuilder {


    private final BitmapFontProvider provider;


    public BitmapFontBuilder(
            ResourceLocation texture
    ) {

        provider =
                new BitmapFontProvider();

        provider.setFile(texture);
        provider.setAscent(7);
        provider.setHeight(8);
    }


    public BitmapFontBuilder glyph(
            String character
    ) {

        provider.getChars()
                .add(character);

        return this;
    }


    public BitmapFontProvider build() {

        return provider;
    }
}