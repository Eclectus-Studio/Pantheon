package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

import com.eclectusstudio.pantheon.common.resource.sounds.SoundEvent;

public class SoundSetting {
    private final SoundEvent pushSound;
    private final SoundEvent hitSound;
    private final float pushSoundImpulseThreshold;
    private final float pushSoundCooldown;

    public SoundSetting(SoundEvent pushSound, SoundEvent hitSound, float pushSoundImpulseThreshold, float pushSoundCooldown) {
        this.pushSound = pushSound;
        this.hitSound = hitSound;
        this.pushSoundImpulseThreshold = pushSoundImpulseThreshold;
        this.pushSoundCooldown = pushSoundCooldown;
    }

    public SoundEvent getPushSound() { return pushSound; }
    public SoundEvent getHitSound() { return hitSound; }
    public float getPushSoundImpulseThreshold() { return pushSoundImpulseThreshold; }
    public float getPushSoundCooldown() { return pushSoundCooldown; }
}