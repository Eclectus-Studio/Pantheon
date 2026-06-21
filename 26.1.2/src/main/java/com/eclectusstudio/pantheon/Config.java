package com.eclectusstudio.pantheon;

public class Config {

    public static boolean PackHostingEnabled;
    public static int PackHostingPort;
    public static String PackHostingAddress;

    public static void init() {
        PackHostingEnabled =
                Pantheon.pantheon.getConfig().getBoolean(
                        "pack-hosting-enabled",
                        false
                );

        PackHostingPort =
                Pantheon.pantheon.getConfig().getInt(
                        "pack-hosting-port",
                        8080
                );

        PackHostingAddress =
                Pantheon.pantheon.getConfig().getString(
                        "pack-hosting-address",
                        "localhost"
                );
    }
}