package com.eclectusstudio.pantheon.bootstrap.adapters;

import com.eclectusstudio.pantheon.common.data.cow_variant.CowVariant;
import io.papermc.paper.registry.data.CowVariantRegistryEntry;
import io.papermc.paper.registry.data.client.ClientTextureAsset;
import io.papermc.paper.registry.data.util.Conversions;
import net.minecraft.world.entity.variant.PriorityProvider;
import net.minecraft.world.entity.variant.SpawnContext;
import net.minecraft.world.entity.variant.SpawnPrioritySelectors;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class CowVariantAdapter {

    private CowVariantAdapter() {}

    private static final Field SPAWN_CONDITIONS_FIELD;

    static {
        try {
            Class<?> paperEntryClass = Class.forName("io.papermc.paper.registry.data.PaperCowVariantRegistryEntry");
            SPAWN_CONDITIONS_FIELD = paperEntryClass.getDeclaredField("spawnConditions");
            SPAWN_CONDITIONS_FIELD.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void apply(CowVariant variant, CowVariantRegistryEntry.Builder builder, Conversions conversions) {
        builder
                .clientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getAdultTexture())))
                .babyClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getBabyTexture())))
                .model(toModel(variant.getModelVariant()));

        applySpawnConditions(variant, builder, conversions);
    }

    private static CowVariantRegistryEntry.Model toModel(
            com.eclectusstudio.pantheon.common.data.cow_variant.CowModelVariant modelVariant
    ) {
        return switch (modelVariant) {
            case NORMAL -> CowVariantRegistryEntry.Model.NORMAL;
            case COLD -> CowVariantRegistryEntry.Model.COLD;
            case WARM -> CowVariantRegistryEntry.Model.WARM;
        };
    }

    private static void applySpawnConditions(CowVariant variant, CowVariantRegistryEntry.Builder builder, Conversions conversions) {
        List<PriorityProvider.Selector<SpawnContext, net.minecraft.world.entity.variant.SpawnCondition>> selectors =
                variant.getSpawnConditions().stream()
                        .flatMap(entry -> SpawnConditionTranslator.toSelectors(entry, conversions).stream())
                        .collect(Collectors.toList());

        SpawnPrioritySelectors nmsSelectors = new SpawnPrioritySelectors(selectors);

        try {
            SPAWN_CONDITIONS_FIELD.set(builder, nmsSelectors);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to set spawn conditions for cow variant " + variant.getLocation(), e);
        }
    }
}