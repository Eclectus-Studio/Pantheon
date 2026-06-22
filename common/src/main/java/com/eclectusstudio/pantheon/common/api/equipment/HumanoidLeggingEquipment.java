package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class HumanoidLeggingEquipment extends Equipment {
    public HumanoidLeggingEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.HUMANOID_LEGGINGS, location);
    }
}
