package com.eclectusstudio.pantheon.common.data.wolf_sound_variant;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class WolfSoundVariant {
    private final ResourceLocation location;

    private final WolfSounds adultSounds;
    private final WolfSounds babySounds;

    public WolfSoundVariant(ResourceLocation location, WolfSounds adultSounds, WolfSounds babySounds) {
        this.location = location;
        this.adultSounds = adultSounds;
        this.babySounds = babySounds;
    }

    public ResourceLocation getLocation() {
        return location;
    }

    public WolfSounds getAdultSounds() {
        return adultSounds;
    }

    public WolfSounds getBabySounds() {
        return babySounds;
    }
}
