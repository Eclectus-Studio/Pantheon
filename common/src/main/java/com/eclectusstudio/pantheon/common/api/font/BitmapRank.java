package com.eclectusstudio.pantheon.common.api.font;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.fonts.BitmapFontProvider;


public final class BitmapRank {


    private BitmapRank(){}


    public static BitmapFontProvider create(
            RankTemplate template,
            ResourceLocation texture
    ) {

        BitmapFontProvider provider =
                new BitmapFontProvider();


        provider.setFile(texture);

        provider.setAscent(
                template.getAscent()
        );

        provider.setHeight(
                template.getHeight()
        );


        provider.getChars()
                .add(
                        template.getCharacter()
                );


        return provider;
    }
}