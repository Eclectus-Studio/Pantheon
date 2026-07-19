package com.eclectusstudio.pantheon.common.resource.sounds;

import java.util.ArrayList;
import java.util.List;

public class SoundEvent {

    /**
     * Example: entity.wolf.howl
     */
    private String id;

    private boolean replace;
    private String subtitle;

    private final List<SoundDefinition> sounds = new ArrayList<>();

    public SoundEvent() {
    }

    public SoundEvent(String id) {
        this.id = id;
    }

    public SoundEvent(
            String id,
            boolean replace,
            String subtitle,
            List<SoundDefinition> sounds
    ) {
        this.id = id;
        this.replace = replace;
        this.subtitle = subtitle;

        if (sounds != null) {
            this.sounds.addAll(sounds);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<SoundDefinition> getSounds() {
        return sounds;
    }
}