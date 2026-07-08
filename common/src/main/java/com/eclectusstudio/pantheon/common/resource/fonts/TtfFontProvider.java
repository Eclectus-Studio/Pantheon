package com.eclectusstudio.pantheon.common.resource.fonts;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class TtfFontProvider extends FontProvider {

    private ResourceLocation file;
    private int oversample;
    private int[] shift = new int[2];
    private int size;
    private List<String> skip = new ArrayList<>();

    @Override
    public String getType() {
        return "ttf";
    }

    public ResourceLocation getFile() {
        return file;
    }

    public void setFile(ResourceLocation file) {
        this.file = file;
    }

    public int getOversample() {
        return oversample;
    }

    public void setOversample(int oversample) {
        this.oversample = oversample;
    }

    public int[] getShift() {
        return shift;
    }

    public void setShift(int[] shift) {
        this.shift = shift;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<String> getSkip() {
        return skip;
    }

    public void setSkip(List<String> skip) {
        this.skip = skip;
    }
}