package com.eclectusstudio.pantheon;

import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.yaml.NodeStyle;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class Config {

    public static boolean PackHostingEnabled;
    public static int PackHostingPort;
    public static String PackHostingAddress;

    public static void init(Pantheon plugin) {
        Path configPath = plugin.getDataDirectory().resolve("config.yml");

        try {
            Files.createDirectories(plugin.getDataDirectory());

            // Copy the default config from resources if it doesn't exist.
            if (Files.notExists(configPath)) {
                try (var in = Pantheon.class.getResourceAsStream("/config.yml")) {
                    if (in == null) {
                        throw new IllegalStateException("config.yml not found in plugin resources.");
                    }
                    Files.copy(in, configPath);
                }
            }

            YamlConfigurationLoader loader = YamlConfigurationLoader.builder()
                    .path(configPath)
                    .nodeStyle(NodeStyle.BLOCK)
                    .build();

            ConfigurationNode root = loader.load();

            PackHostingEnabled = root.node("pack-hosting-enabled").getBoolean(false);
            PackHostingPort = root.node("pack-hosting-port").getInt(8080);
            PackHostingAddress = root.node("pack-hosting-address").getString("localhost");

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.yml", e);
        }
    }

    private Config() {
    }
}