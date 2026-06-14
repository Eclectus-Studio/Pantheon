package com.eclectusstudio.pantheon.common.resource.models;

import java.util.HashMap;
import java.util.Map;

public class ModelDisplay {

    private final Map<String, Transform> transforms = new HashMap<>();

    public void set(String context, Transform transform) {
        transforms.put(context, transform);
    }

    public Map<String, Transform> getAll() {
        return transforms;
    }

    public static class Transform {
        public float[] rotation;
        public float[] translation;
        public float[] scale;
    }
}