package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class WolfBodyEquipment extends Equipment {
    public WolfBodyEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.WOLF_BODY, location);
    }
}
