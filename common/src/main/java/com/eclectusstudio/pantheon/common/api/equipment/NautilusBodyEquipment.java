package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class NautilusBodyEquipment extends Equipment {
    public NautilusBodyEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.NAUTILUS_BODY, location);
    }
}
