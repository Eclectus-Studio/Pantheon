package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.Config;
import com.eclectusstudio.pantheon.HostedPack;
import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.ResourcePacks;
import com.eclectusstudio.pantheon.common.serializer.ResourcePackSerializer;
import com.eclectusstudio.pantheon.common.utils.ResourcePackZipper;
import com.eclectusstudio.pantheon.utils.FileUtils;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class ServerLoadEventHandler {

    private final Pantheon plugin;
    private static HttpServer server;

    public ServerLoadEventHandler(Pantheon plugin) {
        this.plugin = plugin;
    }

    @Subscribe
    public void onProxyInitialize(ProxyInitializeEvent event) {

        plugin.getServer().getEventManager()
                .fire(new BuildResourcePackEvent())
                .join();

        File packFolder = new File(plugin.getDataDirectory().toFile(), "generated_pack");

        FileUtils.deleteRecursively(packFolder);
        packFolder.mkdirs();

        File assetsFolder = new File(packFolder, "assets");
        assetsFolder.mkdirs();

        plugin.getServer().getEventManager()
                .fire(new CopyAssetsEvent(assetsFolder))
                .join();


        for (ResourcePack pack : ResourcePacks.getPacks()) {
            try {
                ResourcePackSerializer.serialize(packFolder, pack);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        File packFile = new File(plugin.getDataDirectory().toFile(), "resourcepack.zip");

        try {
            ResourcePackZipper.zipContents(packFolder, packFile);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        if (!Config.PackHostingEnabled) {
            return;
        }

        try {
            startPackHosting(packFile);

            HostedPack.set(
                    "https://" + Config.PackHostingAddress + ":" + Config.PackHostingPort + "/resourcepack.zip",
                    sha1(packFile)
            );

            plugin.getLogger().info("Resource pack ready.");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
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

        plugin.getLogger().info(
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
