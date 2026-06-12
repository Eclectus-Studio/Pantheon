package com.eclectusstudio.pantheon.common.resource.sounds;

import java.util.LinkedHashMap;
import java.util.Map;

public class Sounds {

    private final Map<String, SoundEvent> soundEvents = new LinkedHashMap<>();

    public Sounds() {
    }

    public Sounds addEvent(String eventName, SoundEvent event) {
        soundEvents.put(eventName, event);
        return this;
    }

    public Map<String, SoundEvent> getSoundEvents() {
        return soundEvents;
    }
}