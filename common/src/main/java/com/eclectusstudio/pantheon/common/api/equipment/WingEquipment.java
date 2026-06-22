package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayer;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class WingEquipment extends Equipment {
    public WingEquipment(ResourceLocation location, boolean overwriteMojangTextures) {
        super(location);
        this.addLayer(EquipmentLayerType.WINGS, new EquipmentLayer(location, overwriteMojangTextures));
    }
}
