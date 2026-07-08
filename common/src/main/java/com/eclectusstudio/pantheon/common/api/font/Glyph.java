package com.eclectusstudio.pantheon.common.api.font;

public class Glyph {

    private final int width;
    private final int height;

    private final boolean[][] pixels;


    public Glyph(
            int width,
            int height
    ) {

        this.width = width;
        this.height = height;

        pixels =
                new boolean[height][width];
    }


    public Glyph pixel(
            int x,
            int y
    ) {

        pixels[y][x] = true;

        return this;
    }


    public boolean[][] pixels() {
        return pixels;
    }
}