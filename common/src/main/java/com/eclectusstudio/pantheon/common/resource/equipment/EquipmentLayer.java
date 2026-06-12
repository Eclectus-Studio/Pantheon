package com.eclectusstudio.pantheon.common.resource.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;

public class EquipmentLayer {

    private ResourceLocation texture;

    private DyeableEquipmentLayer dyeable;

    private boolean usePlayerTexture = false;

    public EquipmentLayer(ResourceLocation texture) {
        this.texture = texture;
    }

    public EquipmentLayer(
            ResourceLocation texture,
            DyeableEquipmentLayer dyeable,
            boolean usePlayerTexture
    ) {
        this.texture = texture;
        this.dyeable = dyeable;
        this.usePlayerTexture = usePlayerTexture;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public DyeableEquipmentLayer getDyeable() {
        return dyeable;
    }

    public boolean isUsePlayerTexture() {
        return usePlayerTexture;
    }
}