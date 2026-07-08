package com.eclectusstudio.pantheon.common.api.font;

import com.eclectusstudio.pantheon.common.resource.fonts.Font;

public class FontAPI {

    private final Font font = new Font();


    public static FontAPI create() {
        return new FontAPI();
    }


    public FontAPI rank(
            RankTemplate rank
    ) {

        font.addProvider(
                rank.build()
        );

        return this;
    }


    public Font build() {
        return font;
    }
}