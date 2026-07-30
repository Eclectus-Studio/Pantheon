package com.eclectusstudio.pantheon.bootstrap.adapters;

import com.eclectusstudio.pantheon.common.data.wolf_variant.WolfVariant;
import io.papermc.paper.registry.data.WolfVariantRegistryEntry;
import io.papermc.paper.registry.data.client.ClientTextureAsset;
import io.papermc.paper.registry.data.util.Conversions;
import net.minecraft.world.entity.variant.PriorityProvider;
import net.minecraft.world.entity.variant.SpawnContext;
import net.minecraft.world.entity.variant.SpawnPrioritySelectors;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class WolfVariantAdapter {

    private WolfVariantAdapter() {}

    private static final Field SPAWN_CONDITIONS_FIELD;

    static {
        try {
            Class<?> paperEntryClass = Class.forName("io.papermc.paper.registry.data.PaperWolfVariantRegistryEntry");
            SPAWN_CONDITIONS_FIELD = paperEntryClass.getDeclaredField("spawnConditions");
            SPAWN_CONDITIONS_FIELD.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void apply(WolfVariant variant, WolfVariantRegistryEntry.Builder builder, Conversions conversions) {
        builder
                .angryClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getAdultModel().getAngry())))
                .wildClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getAdultModel().getWild())))
                .tameClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getAdultModel().getTame())))
                .babyAngryClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getBabyModel().getAngry())))
                .babyWildClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getBabyModel().getWild())))
                .babyTameClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getBabyModel().getTame())));

        applySpawnConditions(variant, builder, conversions);
    }

    private static void applySpawnConditions(WolfVariant variant, WolfVariantRegistryEntry.Builder builder, Conversions conversions) {
        List<PriorityProvider.Selector<SpawnContext, net.minecraft.world.entity.variant.SpawnCondition>> selectors =
                variant.getSpawnConditions().stream()
                        .flatMap(entry -> SpawnConditionTranslator.toSelectors(entry, conversions).stream())
                        .collect(Collectors.toList());

        SpawnPrioritySelectors nmsSelectors = new SpawnPrioritySelectors(selectors);

        try {
            SPAWN_CONDITIONS_FIELD.set(builder, nmsSelectors);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to set spawn conditions for wolf variant " + variant.getLocation(), e);
        }
    }
}