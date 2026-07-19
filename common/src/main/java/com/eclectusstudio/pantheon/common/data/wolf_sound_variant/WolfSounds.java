package com.eclectusstudio.pantheon.common.data.wolf_sound_variant;

import com.eclectusstudio.pantheon.common.resource.sounds.SoundEvent;

public class WolfSounds {
    private final String ambientSound;
    private final String deathSound;
    private final String growlSound;
    private final String hurtSound;
    private final String pantSound;
    private final String whineSound;

    public WolfSounds(String ambientSound, String deathSound, String growlSound, String hurtSound, String pantSound, String whineSound) {
        this.ambientSound = ambientSound;
        this.deathSound = deathSound;
        this.growlSound = growlSound;
        this.hurtSound = hurtSound;
        this.pantSound = pantSound;
        this.whineSound = whineSound;
    }

    public WolfSounds(SoundEvent ambientSound, SoundEvent deathSound, SoundEvent growlSound, SoundEvent hurtSound, SoundEvent pantSound, SoundEvent whineSound) {
        this.ambientSound = ambientSound.getId();
        this.deathSound = deathSound.getId();
        this.growlSound = growlSound.getId();
        this.hurtSound = hurtSound.getId();
        this.pantSound = pantSound.getId();
        this.whineSound = whineSound.getId();
    }

    public String getAmbientSound() {
        return ambientSound;
    }

    public String getDeathSound() {
        return deathSound;
    }

    public String getGrowlSound() {
        return growlSound;
    }

    public String getHurtSound() {
        return hurtSound;
    }

    public String getPantSound() {
        return pantSound;
    }

    public String getWhineSound() {
        return whineSound;
    }
}
