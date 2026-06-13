package com.eclectusstudio.pantheon.common;

import java.util.ArrayList;
import java.util.List;public class ResourcePacks {
    private static List<ResourcePack> packs = new ArrayList<>();

    public static void addPack(ResourcePack pack){
        packs.add(pack);
    }

    public static List<ResourcePack> getPacks() {
        return packs;
    }
}