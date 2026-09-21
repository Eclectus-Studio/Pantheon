package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;

public class AttributeEntry {
    private final Attribute attribute;
    private final AttributeModifier modifier;

    public AttributeEntry(Attribute attribute, AttributeModifier modifier) {
        this.attribute = attribute;
        this.modifier = modifier;
    }

    public Attribute getAttribute() { return attribute; }
    public AttributeModifier getModifier() { return modifier; }
}