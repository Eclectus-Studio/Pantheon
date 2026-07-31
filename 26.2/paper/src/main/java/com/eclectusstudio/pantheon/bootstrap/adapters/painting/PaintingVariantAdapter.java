package com.eclectusstudio.pantheon.bootstrap.adapters.painting;

import com.eclectusstudio.pantheon.common.data.painting_variant.PaintingVariant;
import io.papermc.paper.registry.data.PaintingVariantRegistryEntry;
import net.kyori.adventure.text.Component;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class PaintingVariantAdapter {

    private PaintingVariantAdapter() {}

    public static void apply(PaintingVariant variant, PaintingVariantRegistryEntry.Builder builder) {
        builder
                .width(variant.getWidth())
                .height(variant.getHeight())
                .assetId(toKey(variant.getAssetID()));

        if (variant.getTitle() != null) {
            builder.title(Component.text(variant.getTitle()));
        }

        if (variant.getAuthor() != null) {
            builder.author(Component.text(variant.getAuthor()));
        }
    }
}