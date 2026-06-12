package com.eclectusstudio.pantheon.common.resource.model;

public class ModelDisplay {

    private float[] rotation = new float[3];
    private float[] translation = new float[3];
    private float[] scale = new float[]{1,1,1};

    public ModelDisplay rotation(float x, float y, float z) {
        this.rotation = new float[]{x,y,z};
        return this;
    }

    public ModelDisplay translation(float x, float y, float z) {
        this.translation = new float[]{x,y,z};
        return this;
    }

    public ModelDisplay scale(float x, float y, float z) {
        this.scale = new float[]{x,y,z};
        return this;
    }
}