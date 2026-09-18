package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

import org.bukkit.Material;
import org.bukkit.attribute.AttributeModifier;

import java.util.List;

public class SulfurCubeArchetype {
    private final Explosion explosion;
    private final SoundSetting soundSetting;
    private final ContactDamage contactDamage;

    private final AttributeModifier attributeModifier;

    private final boolean buoyant;
    private final List<Material> items;

    public SulfurCubeArchetype(Explosion explosion, SoundSetting soundSetting, ContactDamage contactDamage, AttributeModifier attributeModifier, boolean buoyant, List<Material> items) {
        this.explosion = explosion;
        this.soundSetting = soundSetting;
        this.contactDamage = contactDamage;
        this.attributeModifier = attributeModifier;
        this.buoyant = buoyant;
        this.items = items;
    }

    public SoundSetting getSoundSetting() {
        return soundSetting;
    }

    public Explosion getExplosion() {
        return explosion;
    }

    public List<Material> getItems() {
        return items;
    }

    public boolean isBuoyant() {
        return buoyant;
    }

    public AttributeModifier getAttributeModifier() {
        return attributeModifier;
    }

    public ContactDamage getContactDamage() {
        return contactDamage;
    }
}
