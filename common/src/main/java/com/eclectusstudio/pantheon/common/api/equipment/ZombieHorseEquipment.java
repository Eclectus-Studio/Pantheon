package com.eclectusstudio.pantheon.common.api.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.EquipmentLayerType;

public class ZombieHorseEquipment extends Equipment {
    public ZombieHorseEquipment(ResourceLocation location) {
        super(location);
        this.addSimpleLayer(EquipmentLayerType.ZOMBIE_HORSE_SADDLE, location);
    }
}
