package com.eclectusstudio.pantheon.bootstrap.adapters.suflurcubearchetype;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.data.sulfur_cube_archetype.AttributeEntry;
import com.eclectusstudio.pantheon.data.sulfur_cube_archetype.ContactDamage;
import com.eclectusstudio.pantheon.data.sulfur_cube_archetype.Explosion;
import com.eclectusstudio.pantheon.data.sulfur_cube_archetype.KnockbackModifier;
import com.eclectusstudio.pantheon.data.sulfur_cube_archetype.SoundSetting;
import com.eclectusstudio.pantheon.data.sulfur_cube_archetype.SulfurCubeArchetype;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.data.SulfurCubeArchetypeRegistryEntry;
import org.bukkit.Sound;
import org.bukkit.damage.DamageType;

import java.util.List;
import java.util.stream.Collectors;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public final class SulfurCubeArchetypeAdapter {
    // TODO finish

    private SulfurCubeArchetypeAdapter() {}

    public static void apply(SulfurCubeArchetype archetype, SulfurCubeArchetypeRegistryEntry.Builder builder) {
        builder
                .buoyant(archetype.isBuoyant())
                .knockbackModifiers(toKnockbackModifiers(archetype.getKnockbackModifier()))
                .soundSettings(toSoundSettings(archetype.getSoundSetting()))
                .attributeModifiers(toAttributeEntries(List.of(archetype.getAttributeEntry())));

        // items(...) still pending — needs RegistryKeySet's public construction API confirmed
        // before List<Material> can be converted into a RegistryKeySet<ItemType>.

        if (archetype.getExplosion() != null) {
            builder.explosion(toExplosionSettings(archetype.getExplosion()));
        }

        if (archetype.getContactDamage() != null) {
            builder.contactDamage(toContactDamage(archetype.getContactDamage()));
        }
    }

    private static SulfurCubeArchetypeRegistryEntry.ExplosionSettings toExplosionSettings(Explosion explosion) {
        return SulfurCubeArchetypeRegistryEntry.ExplosionSettings.of(
                explosion.getPower(),
                explosion.isCausesFire(),
                explosion.getFuse()
        );
    }

    private static SulfurCubeArchetypeRegistryEntry.ContactDamage toContactDamage(ContactDamage contactDamage) {
        TypedKey<DamageType> damageTypeKey = TypedKey.create(RegistryKey.DAMAGE_TYPE, toKey(contactDamage.getDamageType()));

        return SulfurCubeArchetypeRegistryEntry.ContactDamage.of(
                damageTypeKey,
                contactDamage.getAmount(),
                contactDamage.isAttributeToSource()
        );
    }

    private static SulfurCubeArchetypeRegistryEntry.KnockbackModifiers toKnockbackModifiers(KnockbackModifier modifier) {
        return SulfurCubeArchetypeRegistryEntry.KnockbackModifiers.of(
                modifier.getHorizontalPower(),
                modifier.getVerticalPower()
        );
    }

    private static SulfurCubeArchetypeRegistryEntry.SoundSettings toSoundSettings(SoundSetting setting) {
        TypedKey<Sound> hitSound = TypedKey.create(
                RegistryKey.SOUND_EVENT,
                toKey(ResourceLocation.fromString(setting.getHitSound().getId()))
        );
        TypedKey<Sound> pushSound = TypedKey.create(
                RegistryKey.SOUND_EVENT,
                toKey(ResourceLocation.fromString(setting.getPushSound().getId()))
        );

        return SulfurCubeArchetypeRegistryEntry.SoundSettings.of(
                hitSound,
                pushSound,
                setting.getPushSoundImpulseThreshold(),
                setting.getPushSoundCooldown()
        );
    }

    private static List<SulfurCubeArchetypeRegistryEntry.AttributeEntry> toAttributeEntries(List<AttributeEntry> entries) {
        return entries.stream()
                .map(SulfurCubeArchetypeAdapter::toAttributeEntry)
                .collect(Collectors.toList());
    }

    private static SulfurCubeArchetypeRegistryEntry.AttributeEntry toAttributeEntry(AttributeEntry entry) {
        TypedKey<org.bukkit.attribute.Attribute> attributeKey = TypedKey.create(
                RegistryKey.ATTRIBUTE,
                entry.getAttribute().key()
        );

        return SulfurCubeArchetypeRegistryEntry.AttributeEntry.of(attributeKey, entry.getModifier());
    }
}