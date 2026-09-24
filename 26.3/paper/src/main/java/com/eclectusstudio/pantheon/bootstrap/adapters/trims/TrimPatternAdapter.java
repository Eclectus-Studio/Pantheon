package com.eclectusstudio.pantheon.bootstrap.adapters.trims;

import com.eclectusstudio.pantheon.data.trim_pattern.TrimPattern;
import io.papermc.paper.registry.data.TrimPatternRegistryEntry;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public class TrimPatternAdapter {

    private TrimPatternAdapter (){}

    public static void apply(TrimPattern trimPattern, TrimPatternRegistryEntry.Builder builder) {
        builder
                .assetId(toKey(trimPattern.getAssetID()))
                .decal(trimPattern.isDecal())
                .description(trimPattern.getDescription());
    }
}
