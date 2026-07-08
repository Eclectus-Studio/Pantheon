package com.eclectusstudio.pantheon.common.resource.fonts;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class BitmapFontProvider extends FontProvider {

    private int ascent;
    private List<String> chars = new ArrayList<>();
    private ResourceLocation file;
    private Integer height;

    @Override
    public String getType() {
        return "bitmap";
    }

    public int getAscent() {
        return ascent;
    }

    public void setAscent(int ascent) {
        this.ascent = ascent;
    }

    public List<String> getChars() {
        return chars;
    }

    public void setChars(List<String> chars) {
        this.chars = chars;
    }

    public ResourceLocation getFile() {
        return file;
    }

    public void setFile(ResourceLocation file) {
        this.file = file;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}