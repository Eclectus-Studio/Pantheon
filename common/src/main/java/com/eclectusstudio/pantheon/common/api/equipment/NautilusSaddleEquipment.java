package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class NautilusSaddleEquipment extends Equipment {
    public NautilusSaddleEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.NAUTILUS_SADDLE, location);
    }
}
