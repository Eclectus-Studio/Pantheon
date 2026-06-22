package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class HorseBodyEquipment extends Equipment {
    public HorseBodyEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.HORSE_BODY, location);
    }
}
