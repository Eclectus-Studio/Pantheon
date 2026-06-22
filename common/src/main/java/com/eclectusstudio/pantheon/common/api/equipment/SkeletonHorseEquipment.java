package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class SkeletonHorseEquipment extends Equipment {
    public SkeletonHorseEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.SKELETON_HORSE_SADDLE, location);
    }
}
