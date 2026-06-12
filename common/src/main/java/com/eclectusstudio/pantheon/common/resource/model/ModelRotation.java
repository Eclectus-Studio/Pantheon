package com.eclectusstudio.pantheon.common.resource.model;

public class ModelRotation {

    public enum Axis { X, Y, Z }

    private float[] origin;
    private Axis axis;
    private float angle;
    private boolean rescale;

    public ModelRotation origin(float x, float y, float z) {
        this.origin = new float[]{x,y,z};
        return this;
    }

    public ModelRotation axis(Axis axis) {
        this.axis = axis;
        return this;
    }

    public ModelRotation angle(float angle) {
        this.angle = angle;
        return this;
    }
}