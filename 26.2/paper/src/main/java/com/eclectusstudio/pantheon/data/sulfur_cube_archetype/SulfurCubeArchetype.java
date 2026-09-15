package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

import org.bukkit.Material;
import org.bukkit.attribute.AttributeModifier;

import java.util.List;

public class SulfurCubeArchetype {
    private Explosion explosion;
    private SoundSetting soundSetting;

    private AttributeModifier attributeModifier;

    private boolean buoyant;
    private List<Material> items;

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
}
