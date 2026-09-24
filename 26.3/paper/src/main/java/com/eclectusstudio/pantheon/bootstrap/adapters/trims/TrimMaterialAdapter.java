package com.eclectusstudio.pantheon.bootstrap.adapters.trims;

import com.eclectusstudio.pantheon.data.trim_material.TrimMaterial;
import io.papermc.paper.registry.data.TrimMaterialRegistryEntry;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class TrimMaterialAdapter {

    private TrimMaterialAdapter() {}

    public static void apply(TrimMaterial trimMaterial, TrimMaterialRegistryEntry.Builder builder) {
        builder
                .paletteId(toKey(trimMaterial.getPaletteId()))
                .description(trimMaterial.getDescription());
    }
}