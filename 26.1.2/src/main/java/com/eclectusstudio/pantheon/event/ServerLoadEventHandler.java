package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.ResourcePacks;
import com.eclectusstudio.pantheon.common.serializer.ResourcePackSerializer;
import com.eclectusstudio.pantheon.common.utils.ResourcePackZipper;
import com.eclectusstudio.pantheon.utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import java.io.File;
import java.io.IOException;

public class ServerLoadEventHandler implements Listener {
    @EventHandler
    public void onStart(ServerLoadEvent e) {
        Bukkit.getPluginManager().callEvent(new BuildResourcePackEvent());

        File packFolder =
                new File(
                        Pantheon.pantheon.getDataFolder(),
                        "generated_pack"
                );

        FileUtils.deleteRecursively(packFolder);

        packFolder.mkdirs();

        for (ResourcePack pack : ResourcePacks.getPacks()) {

            try {
                ResourcePackSerializer.serialize(
                        packFolder,
                        pack
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        try {
            ResourcePackZipper.zipContents(
                    packFolder,
                    new File(
                            Pantheon.pantheon.getDataFolder(),
                            "resourcepack.zip"
                    )
            );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}