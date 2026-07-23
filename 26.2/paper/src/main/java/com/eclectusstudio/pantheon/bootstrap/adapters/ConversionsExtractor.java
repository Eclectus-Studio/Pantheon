package com.eclectusstudio.pantheon.bootstrap.adapters;

import io.papermc.paper.registry.data.util.Conversions;

import java.lang.reflect.Field;

public final class ConversionsExtractor {

    private ConversionsExtractor() {}

    private static final Field CONVERSIONS_FIELD;

    static {
        try {
            Class<?> apiWritableRegistryClass = Class.forName("io.papermc.paper.registry.WritableCraftRegistry$ApiWritableRegistry");
            CONVERSIONS_FIELD = apiWritableRegistryClass.getDeclaredField("conversions");
            CONVERSIONS_FIELD.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Conversions from(Object registry) {
        try {
            return (Conversions) CONVERSIONS_FIELD.get(registry);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException(
                    "Failed to extract freeze-scoped Conversions from registry of type " + registry.getClass().getName(), e
            );
        }
    }
}