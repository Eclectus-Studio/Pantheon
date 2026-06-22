package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class MuleSaddleEquipment extends Equipment {
    public MuleSaddleEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.MULE_SADDLE, location);
    }
}
