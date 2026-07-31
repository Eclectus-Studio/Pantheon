package com.eclectusstudio.pantheon.common.data.painting_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class PaintingVariant {
    private final ResourceLocation assetID;

    private final int width, height;

    private final String title, author;

    public PaintingVariant(ResourceLocation assetID, int width, int height, String title, String author) {
        if(!(isInBlockRange(width) && isInBlockRange(height))){
            throw new IllegalArgumentException("Width and height must 1 and 16");
        }

        this.assetID = assetID;
        this.width = width;
        this.height = height;
        this.title = title;
        this.author = author;
    }

    public ResourceLocation getAssetID() {
        return assetID;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    private boolean isInBlockRange(int number) {
        return number >= 1 && number <= 16;
    }
}
