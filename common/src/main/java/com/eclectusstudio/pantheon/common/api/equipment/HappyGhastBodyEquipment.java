package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class HappyGhastBodyEquipment extends Equipment {
    public HappyGhastBodyEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.HAPPY_GHAST_BODY, location);
    }
}
