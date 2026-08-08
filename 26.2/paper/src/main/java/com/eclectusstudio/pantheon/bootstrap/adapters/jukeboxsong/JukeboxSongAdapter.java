package com.eclectusstudio.pantheon.bootstrap.adapters.jukeboxsong;

import com.eclectusstudio.pantheon.common.data.jukebox_song.JukeboxSong;
import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.registry.data.JukeboxSongRegistryEntry;
import io.papermc.paper.registry.data.SoundEventRegistryEntry;
import net.kyori.adventure.text.Component;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class JukeboxSongAdapter {

    private JukeboxSongAdapter() {}

    public static void apply(JukeboxSong song, JukeboxSongRegistryEntry.Builder builder) {
        ResourceLocation soundLocation = ResourceLocation.fromString(song.getSoundID());
        var soundKey = toKey(soundLocation);

        builder
                .soundEvent(factory -> {
                    SoundEventRegistryEntry.Builder soundBuilder = factory.empty();
                    soundBuilder.location(soundKey);
                    // fixedRange left unset (null) — optional per the interface, only needed
                    // if this sound should ignore normal distance falloff (e.g. always audible).
                })
                .description(Component.text(song.getDescription()))
                .lengthInSeconds(song.getLength_in_seconds())
                .comparatorOutput(song.getComparator_output());
    }
}