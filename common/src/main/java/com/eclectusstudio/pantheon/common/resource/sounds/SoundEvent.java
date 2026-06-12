package com.eclectusstudio.pantheon.common.resource.sounds;

import java.util.ArrayList;
import java.util.List;

public class SoundEvent {

    private boolean replace = false;
    private String subtitle;

    private final List<Sound> sounds = new ArrayList<>();

    public SoundEvent() {
    }

    public SoundEvent(boolean replace, String subtitle) {
        this.replace = replace;
        this.subtitle = subtitle;
    }

    public SoundEvent addSound(Sound sound) {
        sounds.add(sound);
        return this;
    }

    public boolean isReplace() {
        return replace;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<Sound> getSounds() {
        return sounds;
    }
}