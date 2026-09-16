package com.eclectusstudio.pantheon.data.sulfur_cube_archetype;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class ContactDamage {
    private final float amount;
    private final boolean attributeToSource;
    private final ResourceLocation damageType;

    public ContactDamage(float amount, boolean attributeToSource, ResourceLocation damageType) {
        this.amount = amount;
        this.attributeToSource = attributeToSource;
        this.damageType = damageType;
    }

    public float getAmount() {
        return amount;
    }

    public boolean isAttributeToSource() {
        return attributeToSource;
    }

    public ResourceLocation getDamageType() {
        return damageType;
    }
}
