package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class HorseSaddleEquipment extends Equipment {
    public HorseSaddleEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.HORSE_SADDLE, location);
    }
}
