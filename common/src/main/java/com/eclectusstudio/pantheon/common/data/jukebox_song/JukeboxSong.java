package com.eclectusstudio.pantheon.common.data.jukebox_song;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundEvent;

public class JukeboxSong {
    private final ResourceLocation location;

    private final String soundID;

    private final String description;

    private final float length_in_seconds;

    private final int comparator_output;

    public JukeboxSong(ResourceLocation location, String soundID, String description, float lengthInSeconds, int comparatorOutput) {
        this.location = location;
        this.soundID = soundID;
        this.description = description;
        length_in_seconds = lengthInSeconds;
        if (!(comparatorOutput >= 0 && comparatorOutput <= 15)) {
            throw new IllegalStateException("Redstone output MUST be between or 0 and 15");
        }
        comparator_output = comparatorOutput;
    }

    public JukeboxSong(ResourceLocation location, SoundEvent soundID, String description, float lengthInSeconds, int comparatorOutput) {
        this.location = location;
        this.soundID = soundID.getId();
        this.description = description;
        length_in_seconds = lengthInSeconds;
        if (!(comparatorOutput >= 0 && comparatorOutput <= 15)) {
            throw new IllegalStateException("Redstone output MUST be between or 0 and 15");
        }
        comparator_output = comparatorOutput;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public String getSoundID() {
        return soundID;
    }

    public String getDescription() {
        return description;
    }

    public float getLength_in_seconds() {
        return length_in_seconds;
    }

    public int getComparator_output() {
        return comparator_output;
    }
}
