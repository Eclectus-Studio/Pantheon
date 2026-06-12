package com.eclectusstudio.pantheon.common.resource.sounds;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class Sound {

    private ResourceLocation name;

    private float volume = 1.0F;
    private float pitch = 1.0F;
    private int weight = 1;

    private boolean stream = false;
    private int attenuationDistance = 16;
    private boolean preload = false;

    private SoundType type = SoundType.FILE;

    public Sound(ResourceLocation name) {
        this.name = name;
    }

    public Sound(
            ResourceLocation name,
            float volume,
            float pitch,
            int weight,
            boolean stream,
            int attenuationDistance,
            boolean preload,
            SoundType type
    ) {
        this.name = name;
        this.volume = volume;
        this.pitch = pitch;
        this.weight = weight;
        this.stream = stream;
        this.attenuationDistance = attenuationDistance;
        this.preload = preload;
        this.type = type;
    }

    public ResourceLocation getName() {
        return name;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isStream() {
        return stream;
    }

    public int getAttenuationDistance() {
        return attenuationDistance;
    }

    public boolean isPreload() {
        return preload;
    }

    public SoundType getType() {
        return type;
    }
}