package com.eclectusstudio.pantheon.common.resource.model;

public class TextureRef {

    private final String value;
    private final boolean forceTranslucent;

    public TextureRef(String value) {
        this.value = value;
        this.forceTranslucent = false;
    }

    public TextureRef(String value, boolean forceTranslucent) {
        this.value = value;
        this.forceTranslucent = forceTranslucent;
    }
}