package com.eclectusstudio.pantheon.common.resource.model;

import java.util.HashMap;
import java.util.Map;

public class ModelElement {

    private float[] from;
    private float[] to;

    private ModelRotation rotation;

    private boolean shade = true;
    private int lightEmission = 0;

    private Map<String, ModelFace> faces = new HashMap<>();

    public ModelElement from(float x, float y, float z) {
        this.from = new float[]{x,y,z};
        return this;
    }

    public ModelElement to(float x, float y, float z) {
        this.to = new float[]{x,y,z};
        return this;
    }

    public ModelElement face(String side, ModelFace face) {
        faces.put(side, face);
        return this;
    }

    public ModelElement rotation(ModelRotation rotation) {
        this.rotation = rotation;
        return this;
    }
}