package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

import com.eclectusstudio.pantheon.common.resource.sounds.SoundEvent;

public class SoundSetting {
    private final SoundEvent pushSound;
    private final SoundEvent hitSound;

    public SoundEvent getPushSound() {
        return pushSound;
    }

    public SoundEvent getHitSound() {
        return hitSound;
    }

    public SoundSetting(SoundEvent pushSound, SoundEvent hitSound) {
        this.pushSound = pushSound;
        this.hitSound = hitSound;
    }
}
