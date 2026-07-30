package com.eclectusstudio.pantheon.bootstrap.adapters.variants;

import com.eclectusstudio.pantheon.common.data.pig_variant.PigVariant;
import io.papermc.paper.registry.data.PigVariantRegistryEntry;
import io.papermc.paper.registry.data.client.ClientTextureAsset;
import io.papermc.paper.registry.data.util.Conversions;
import net.minecraft.world.entity.variant.PriorityProvider;
import net.minecraft.world.entity.variant.SpawnContext;
import net.minecraft.world.entity.variant.SpawnPrioritySelectors;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class PigVariantAdapter {

    private PigVariantAdapter() {}

    private static final Field SPAWN_CONDITIONS_FIELD;

    static {
        try {
            Class<?> paperEntryClass = Class.forName("io.papermc.paper.registry.data.PaperPigVariantRegistryEntry");
            SPAWN_CONDITIONS_FIELD = paperEntryClass.getDeclaredField("spawnConditions");
            SPAWN_CONDITIONS_FIELD.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void apply(PigVariant variant, PigVariantRegistryEntry.Builder builder, Conversions conversions) {
        builder
                .clientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getAdultTexture())))
                .babyClientTextureAsset(ClientTextureAsset.clientTextureAsset(toKey(variant.getBabyTexture())))
                .model(toModel(variant.getModelVariant()));

        applySpawnConditions(variant, builder, conversions);
    }

    private static PigVariantRegistryEntry.Model toModel(
            com.eclectusstudio.pantheon.common.data.pig_variant.PigModelVariant modelVariant
    ) {
        return switch (modelVariant) {
            case NORMAL -> PigVariantRegistryEntry.Model.NORMAL;
            case COLD -> PigVariantRegistryEntry.Model.COLD;
        };
    }

    private static void applySpawnConditions(PigVariant variant, PigVariantRegistryEntry.Builder builder, Conversions conversions) {
        List<PriorityProvider.Selector<SpawnContext, net.minecraft.world.entity.variant.SpawnCondition>> selectors =
                variant.getSpawnConditions().stream()
                        .flatMap(entry -> SpawnConditionTranslator.toSelectors(entry, conversions).stream())
                        .collect(Collectors.toList());

        SpawnPrioritySelectors nmsSelectors = new SpawnPrioritySelectors(selectors);

        try {
            SPAWN_CONDITIONS_FIELD.set(builder, nmsSelectors);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Failed to set spawn conditions for pig variant " + variant.getLocation(), e);
        }
    }
}