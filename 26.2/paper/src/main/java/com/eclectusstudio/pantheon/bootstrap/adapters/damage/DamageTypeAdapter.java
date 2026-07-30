package com.eclectusstudio.pantheon.bootstrap.adapters.damage;

import com.eclectusstudio.pantheon.common.data.damage_type.DamageType;
import com.eclectusstudio.pantheon.common.resource.language.TranslationKey;
import io.papermc.paper.registry.data.DamageTypeRegistryEntry;

public final class DamageTypeAdapter {

    private DamageTypeAdapter() {}

    public static void apply(DamageType damageType, DamageTypeRegistryEntry.Builder builder) {
        builder
                .messageId(toMessageId(damageType.getDeathMessage()))
                .exhaustion(damageType.getExhaustion())
                .damageScaling(toDamageScaling(damageType.getScaling()))
                .damageEffect(toDamageEffect(damageType.getEffect()))
                .deathMessageType(toDeathMessageType(damageType.getDeathMessageType()));
    }

    private static String toMessageId(TranslationKey deathMessage) {
        // Inferred accessor — swap this if TranslationKey's real shape differs.
        return deathMessage.getKey();
    }

    private static org.bukkit.damage.DamageScaling toDamageScaling(
            com.eclectusstudio.pantheon.common.data.damage_type.DamageScaling scaling
    ) {
        return switch (scaling) {
            case NEVER -> org.bukkit.damage.DamageScaling.NEVER;
            case ALWAYS -> org.bukkit.damage.DamageScaling.ALWAYS;
            case WHEN_CAUSED_BY_LIVING_NON_PLAYER -> org.bukkit.damage.DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER;
        };
    }

    private static org.bukkit.damage.DamageEffect toDamageEffect(
            com.eclectusstudio.pantheon.common.data.damage_type.DamageEffect effect
    ) {
        return switch (effect) {
            case HURT -> org.bukkit.damage.DamageEffect.HURT;
            case THORNS -> org.bukkit.damage.DamageEffect.THORNS;
            case DROWNING -> org.bukkit.damage.DamageEffect.DROWNING;
            case BURNING -> org.bukkit.damage.DamageEffect.BURNING;
            case POKING -> org.bukkit.damage.DamageEffect.POKING;
            case FREEZING -> org.bukkit.damage.DamageEffect.FREEZING;
        };
    }

    private static org.bukkit.damage.DeathMessageType toDeathMessageType(
            com.eclectusstudio.pantheon.common.data.damage_type.DeathMessageType type
    ) {
        return switch (type) {
            case DEFAULT -> org.bukkit.damage.DeathMessageType.DEFAULT;
            case FALL_VARIANTS -> org.bukkit.damage.DeathMessageType.FALL_VARIANTS;
            case INTENTIONAL_GAME_DESIGN -> org.bukkit.damage.DeathMessageType.INTENTIONAL_GAME_DESIGN;
        };
    }
}