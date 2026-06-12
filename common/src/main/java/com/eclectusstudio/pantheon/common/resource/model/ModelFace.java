package com.eclectusstudio.pantheon.common.resource.model;

public class ModelFace {

    private float[] uv;
    private String texture; // "#texture"
    private String cullface;

    private int rotation = 0;
    private int tintIndex = -1;

    public ModelFace texture(String texture) {
        this.texture = texture;
        return this;
    }

    public ModelFace uv(float x1, float y1, float x2, float y2) {
        this.uv = new float[]{x1,y1,x2,y2};
        return this;
    }
}