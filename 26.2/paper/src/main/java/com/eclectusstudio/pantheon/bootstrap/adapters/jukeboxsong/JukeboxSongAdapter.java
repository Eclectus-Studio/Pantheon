package com.eclectusstudio.pantheon.bootstrap.adapters.jukeboxsong;

import com.eclectusstudio.pantheon.common.data.jukebox_song.JukeboxSong;
import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.data.JukeboxSongRegistryEntry;
import net.kyori.adventure.text.Component;
import org.bukkit.Sound;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class JukeboxSongAdapter {

    private JukeboxSongAdapter() {}

    public static void apply(JukeboxSong song, JukeboxSongRegistryEntry.Builder builder) {
        ResourceLocation soundLocation = ResourceLocation.fromString(song.getSoundID());
        TypedKey<Sound> soundKey = TypedKey.create(RegistryKey.SOUND_EVENT, toKey(soundLocation));

        builder
                .soundEvent(soundKey)
                .description(Component.text(song.getDescription()))
                .lengthInSeconds(song.getLength_in_seconds())
                .comparatorOutput(song.getComparator_output());
    }
}