package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.HostedPack;
import com.eclectusstudio.pantheon.Pantheon;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.proxy.player.ResourcePackInfo;

public final class PlayerJoinEventHandler {

    private final Pantheon plugin;

    public PlayerJoinEventHandler(Pantheon plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void onJoin(PostLoginEvent event) {
        if (!HostedPack.isReady()) {
            plugin.getLogger().warn("HostedPack not initialized!");
            return;
        }

        ResourcePackInfo pack = plugin.getServer()
                .createResourcePackBuilder(HostedPack.getUrl())
                .setHash(HostedPack.getHash())
                .setShouldForce(true)
                .build();

        event.getPlayer().sendResourcePackOffer(pack);
    }
}