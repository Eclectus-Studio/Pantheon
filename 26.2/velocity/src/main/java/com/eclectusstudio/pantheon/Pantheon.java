package com.eclectusstudio.pantheon;

import com.eclectusstudio.pantheon.event.ServerLoadEventHandler;
import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Plugin(
        id = "pantheon",
        name = "Pantheon",
        version = "1.0.0",
        authors = {"EclectusStudio"}
)
public class Pantheon {

    private final ProxyServer server;
    private final Logger logger;
    private final Path dataDirectory;

    @Inject
    public Pantheon(
            ProxyServer server,
            Logger logger,
            @DataDirectory Path dataDirectory
    ) {
        this.server = server;
        this.logger = logger;
        this.dataDirectory = dataDirectory;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        try {
            Files.createDirectories(dataDirectory);
        } catch (IOException e) {
            logger.error("Failed to create plugin data folder.", e);
            return;
        }

        Config.init(this);

        server.getEventManager().register(this, new ServerLoadEventHandler(this));
    }

    public ProxyServer getServer() {
        return server;
    }

    public Logger getLogger() {
        return logger;
    }

    public Path getDataDirectory() {
        return dataDirectory;
    }
}