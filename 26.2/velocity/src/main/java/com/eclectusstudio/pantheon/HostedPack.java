package com.eclectusstudio.pantheon;

public final class HostedPack {

    private static String url;
    private static byte[] hash;

    public static String getUrl() {
        return url;
    }

    public static byte[] getHash() {
        return hash;
    }

    public static void set(String url, byte[] hash) {
        HostedPack.url = url;
        HostedPack.hash = hash;
    }

    public static boolean isReady() {
        return url != null
                && !url.isBlank()
                && hash != null
                && hash.length == 20;
    }
}