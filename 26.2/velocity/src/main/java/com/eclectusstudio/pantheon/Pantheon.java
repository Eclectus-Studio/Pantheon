package com.eclectusstudio.pantheon;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

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
        logger.info("Pantheon has started!");

        // Create the data folder if it doesn't exist
        try {
            java.nio.file.Files.createDirectories(dataDirectory);
        } catch (Exception e) {
            logger.error("Failed to create plugin data folder.", e);
        }
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