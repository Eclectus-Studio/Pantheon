package com.eclectusstudio.pantheon.common.resource.blockstate;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class ModelVariant {

    private final ResourceLocation model;

    private int x;
    private int y;
    private int z;

    private boolean uvlock = false;
    private int weight = 1;

    public ModelVariant(ResourceLocation model) {
        this.model = model;
    }

    public ModelVariant rotation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public ModelVariant weight(int weight) {
        this.weight = weight;
        return this;
    }

    public ModelVariant uvlock(boolean uvlock) {
        this.uvlock = uvlock;
        return this;
    }

    public ResourceLocation getModel() {
        return model;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public boolean isUvlock() {
        return uvlock;
    }

    public int getWeight() {
        return weight;
    }
}
