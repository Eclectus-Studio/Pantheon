package com.eclectusstudio.pantheon.common.resource.items;

public class ItemTransformation {

    public float[] matrix; // 16 floats OR decomposed form later

    public ItemTransformation(float[] matrix) {
        this.matrix = matrix;
    }
}