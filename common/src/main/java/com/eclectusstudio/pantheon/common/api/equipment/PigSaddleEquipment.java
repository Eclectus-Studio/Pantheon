package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class PigSaddleEquipment extends Equipment {
    public PigSaddleEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.PIG_SADDLE, location);
    }
}
