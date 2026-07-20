package com.eclectusstudio.pantheon.bootstrap.adapters;

import com.eclectusstudio.pantheon.common.data.cat_variant.CatVariant;
import io.papermc.paper.registry.data.CatTypeRegistryEntry;
import io.papermc.paper.registry.data.client.ClientTextureAsset;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class CatVariantAdapter {

    private CatVariantAdapter() {}

    public static void apply(CatVariant variant, CatTypeRegistryEntry.Builder builder) {
        builder
                .clientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getAdultTexture())))
                .babyClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getBabyTexture())));
    }
}