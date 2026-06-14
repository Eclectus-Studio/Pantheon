package com.eclectusstudio.pantheon.common.resource.models;

import java.util.HashMap;
import java.util.Map;

public class ModelTextures {

    private final Map<String, String> textures = new HashMap<>();

    public void set(String key, String value) {
        textures.put(key, value);
    }

    public Map<String, String> getAll() {
        return textures;
    }
}