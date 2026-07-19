package com.eclectusstudio.pantheon.common.resource.sounds;

public class SoundDefinition {

    /**
     * Path to the sound or another event.
     */
    private String name;

    private float volume = 1.0F;
    private float pitch = 1.0F;
    private int weight = 1;
    private boolean stream;
    private int attenuationDistance = 16;
    private boolean preload;
    private SoundType type = SoundType.FILE;

    public SoundDefinition() {
    }

    public SoundDefinition(String name) {
        this.name = name;
    }

    public SoundDefinition(
            String name,
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }

    public int getAttenuationDistance() {
        return attenuationDistance;
    }

    public void setAttenuationDistance(int attenuationDistance) {
        this.attenuationDistance = attenuationDistance;
    }

    public boolean isPreload() {
        return preload;
    }

    public void setPreload(boolean preload) {
        this.preload = preload;
    }

    public SoundType getType() {
        return type;
    }

    public void setType(SoundType type) {
        this.type = type;
    }
}