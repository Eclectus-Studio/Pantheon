package com.eclectusstudio.pantheon.common.resource.sounds;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class SoundsFile {

    /**
     * Resource location of this sounds.json.
     */
    private ResourceLocation location;

    private final List<SoundEvent> soundEvents = new ArrayList<>();

    public SoundsFile() {
    }

    public SoundsFile(ResourceLocation location) {
        this.location = location;
    }

    public SoundsFile(
            ResourceLocation location,
            List<SoundEvent> soundEvents
    ) {
        this.location = location;

        if (soundEvents != null) {
            this.soundEvents.addAll(soundEvents);
        }
    }

    public void register(SoundEvent event) {

        for (SoundEvent existing : soundEvents) {

            if (existing.getId().equals(event.getId())) {
                throw new IllegalArgumentException(
                        "Duplicate sound event '" + event.getId() + "'."
                );
            }
        }

        soundEvents.add(event);
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public void setLocation(ResourceLocation location) {
        this.location = location;
    }

    public List<SoundEvent> getSoundEvents() {
        return soundEvents;
    }
}