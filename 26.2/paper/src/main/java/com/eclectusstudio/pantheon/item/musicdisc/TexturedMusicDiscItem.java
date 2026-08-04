package com.eclectusstudio.pantheon.item.musicdisc;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedItem;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.JukeboxPlayable;
import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import org.bukkit.JukeboxSong;
import org.bukkit.inventory.ItemStack;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class TexturedMusicDiscItem extends TexturedItem {
    private final JukeboxSong song;

    public TexturedMusicDiscItem(ResourceLocation id, ItemStack itemStack, ResourceLocation songLocation) {
        super(id, itemStack);
        song = RegistryAccess.registryAccess().getRegistry(RegistryKey.JUKEBOX_SONG).getOrThrow(toKey(songLocation));
    }

    public JukeboxSong getSong() {
        return song;
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack();

        stack.setData(DataComponentTypes.JUKEBOX_PLAYABLE, JukeboxPlayable.jukeboxPlayable(song));

        return stack;
    }
}
