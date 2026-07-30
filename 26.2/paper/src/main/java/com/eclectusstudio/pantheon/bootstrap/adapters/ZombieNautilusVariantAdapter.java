package com.eclectusstudio.pantheon.bootstrap.adapters;

import com.eclectusstudio.pantheon.common.data.zombie_nautilus_variant.ZombieNautilusVariant;
import io.papermc.paper.registry.data.ZombieNautilusVariantRegistryEntry;
import io.papermc.paper.registry.data.client.ClientTextureAsset;
import io.papermc.paper.registry.data.util.Conversions;
import net.minecraft.world.entity.variant.PriorityProvider;
import net.minecraft.world.entity.variant.SpawnContext;
import net.minecraft.world.entity.variant.SpawnPrioritySelectors;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class ZombieNautilusVariantAdapter {

    private ZombieNautilusVariantAdapter() {}

    private static final Field SPAWN_CONDITIONS_FIELD;

    static {
        try {
            Class<?> paperEntryClass = Class.forName("io.papermc.paper.registry.data.PaperZombieNautilusVariantRegistryEntry");
            SPAWN_CONDITIONS_FIELD = paperEntryClass.getDeclaredField("spawnConditions");
            SPAWN_CONDITIONS_FIELD.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void apply(ZombieNautilusVariant variant, ZombieNautilusVariantRegistryEntry.Builder builder, Conversions conversions) {
        builder
                .clientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getTexture())))
                .model(toModel(variant.getModelVariant()));

        applySpawnConditions(variant, builder, conversions);
    }

    private static ZombieNautilusVariantRegistryEntry.Model toModel(
            com.eclectusstudio.pantheon.common.data.zombie_nautilus_variant.ZombieNautilusModelVariant modelVariant
    ) {
        return switch (modelVariant) {
            case NORMAL -> ZombieNautilusVariantRegistryEntry.Model.NORMAL;
            case WARM -> ZombieNautilusVariantRegistryEntry.Model.WARM;
        };
    }

    private static void applySpawnConditions(ZombieNautilusVariant variant, ZombieNautilusVariantRegistryEntry.Builder builder, Conversions conversions) {
        List<PriorityProvider.Selector<SpawnContext, net.minecraft.world.entity.variant.SpawnCondition>> selectors =
                variant.getSpawnConditions().stream()
                        .flatMap(entry -> SpawnConditionTranslator.toSelectors(entry, conversions).stream())
                        .collect(Collectors.toList());

        SpawnPrioritySelectors nmsSelectors = new SpawnPrioritySelectors(selectors);

        try {
            SPAWN_CONDITIONS_FIELD.set(builder, nmsSelectors);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to set spawn conditions for zombie nautilus variant " + variant.getLocation(), e);
        }
    }
}