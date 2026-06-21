package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.Config;
import com.eclectusstudio.pantheon.HostedPack;
import com.eclectusstudio.pantheon.Pantheon;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!HostedPack.isReady()) {
            Pantheon.pantheon.getLogger().warning(
                    "HostedPack not initialized!"
            );
            return;
        }

        player.setResourcePack(
                HostedPack.getUrl(),
                HostedPack.getHash(),
                true
        );
    }
}