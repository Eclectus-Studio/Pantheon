package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.Config;
import com.eclectusstudio.pantheon.HostedPack;
import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.ResourcePacks;
import com.eclectusstudio.pantheon.common.serializer.ResourcePackSerializer;
import com.eclectusstudio.pantheon.common.utils.ResourcePackZipper;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import com.eclectusstudio.pantheon.utils.FileUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.codec.digest.DigestUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerLoadEvent;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class ServerLoadEventHandler implements Listener {

    private static HttpServer server;

    @EventHandler
    public void onStart(ServerLoadEvent e) {
        buildPack();
    }

    private void buildPack(){
        if(!Config.PackGenerationOnProxy){
            long startTime = System.nanoTime();

            Bukkit.getPluginManager().callEvent(
                    new BuildResourcePackEvent()
            );

            File packFolder = new File(
                    Pantheon.pantheon.getDataFolder(),
                    "generated_pack"
            );

            FileUtils.deleteRecursively(packFolder);
            packFolder.mkdirs();

            File assetsFolder = new File(
                    packFolder,
                    "assets"
            );

            assetsFolder.mkdirs();

            Bukkit.getPluginManager().callEvent(
                    new CopyAssetsEvent(assetsFolder)
            );

            Bukkit.getPluginManager().callEvent(
                    new SubmitItemsEvent()
            );

            ItemRegistry.lock();

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

            File packFile = new File(
                    Pantheon.pantheon.getDataFolder(),
                    "resourcepack.zip"
            );

            try {
                ResourcePackZipper.zipContents(
                        packFolder,
                        packFile
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            if (Config.PackHostingEnabled) {
                try {
                    startPackHosting(packFile);

                    byte[] hash = sha1(packFile);

                    String url =
                            "https://"
                                    + Config.PackHostingAddress
                                    + ":"
                                    + Config.PackHostingPort
                                    + "/resourcepack.zip";

                    HostedPack.set(
                            url,
                            hash
                    );

                    Pantheon.pantheon.getLogger().info(
                            "Resource pack available at: " + url
                    );

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }

            double elapsedMs = (System.nanoTime() - startTime) / 1_000_000.0;
            Pantheon.pantheon.getLogger().info(
                    String.format("Resource pack generated in %.2f ms", elapsedMs)
            );
        }
    }

    private void startPackHosting(File packFile) throws IOException {

        if (server != null) {
            server.stop(0);
        }

        server = HttpServer.create(
                new InetSocketAddress(
                        Config.PackHostingPort
                ),
                0
        );

        server.createContext(
                "/resourcepack.zip",
                (HttpExchange exchange) -> {

                    if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                        exchange.sendResponseHeaders(
                                405,
                                -1
                        );
                        return;
                    }

                    byte[] data =
                            Files.readAllBytes(
                                    packFile.toPath()
                            );

                    exchange.getResponseHeaders().add(
                            "Content-Type",
                            "application/zip"
                    );

                    exchange.sendResponseHeaders(
                            200,
                            data.length
                    );

                    try (OutputStream os =
                                 exchange.getResponseBody()) {
                        os.write(data);
                    }
                }
        );

        server.start();

        Pantheon.pantheon.getLogger().info(
                "Hosting resource pack on port "
                        + Config.PackHostingPort
        );
    }

    private static byte[] sha1(File file) {

        byte[] hash = null;
        try {
            hash = DigestUtils.sha1(
                    Files.newInputStream(file.toPath())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return hash;
    }

    public static void stopHosting() {

        if (server != null) {
            server.stop(0);
            server = null;
        }
    }
}