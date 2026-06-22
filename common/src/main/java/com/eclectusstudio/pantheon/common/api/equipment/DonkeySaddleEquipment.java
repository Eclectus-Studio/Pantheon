package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class DonkeySaddleEquipment extends Equipment {
    public DonkeySaddleEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.DONKEY_SADDLE, location);
    }
}
