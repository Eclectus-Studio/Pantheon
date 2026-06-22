package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class HumanoidBabyEquipment extends Equipment {
    public HumanoidBabyEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.HUMANOID_BABY, location);
    }
}
