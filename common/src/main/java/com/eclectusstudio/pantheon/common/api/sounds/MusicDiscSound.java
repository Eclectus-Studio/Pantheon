package com.eclectusstudio.pantheon.common.api.sounds;

import com.eclectusstudio.pantheon.common.resource.sounds.SoundDefinition;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundEvent;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundType;

public class MusicDiscSound extends SoundEvent {

    public MusicDiscSound(String namespace, String name) {
        super("music_disc." + name);

        String soundPath = namespace + ":music/" + name;

        SoundDefinition definition = new SoundDefinition();
        definition.setName(soundPath);
        definition.setType(SoundType.FILE);
        definition.setStream(true);
        definition.setVolume(1.0F);
        definition.setPitch(1.0F);
        definition.setWeight(1);
        definition.setAttenuationDistance(16);
        definition.setPreload(false);

        getSounds().add(definition);
    }
}