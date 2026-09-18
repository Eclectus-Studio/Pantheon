package com.eclectusstudio.pantheon.utils;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import org.bukkit.NamespacedKey;

public class LocationToNamespaceKey {
    public static NamespacedKey toKey(ResourceLocation location){
        return new NamespacedKey(location.getNamespace(), location.getPath());
    }
}
