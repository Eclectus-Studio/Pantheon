package com.eclectusstudio.pantheon.common.resource.sounds;

public enum SoundType {
    FILE("file"),
    EVENT("event");

    private final String id;

    SoundType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}