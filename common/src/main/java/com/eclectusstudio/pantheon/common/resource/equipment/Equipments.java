package com.eclectusstudio.pantheon.common.resource.equipment;

import java.util.ArrayList;
import java.util.List;

public class Equipments {
    private List<Equipment> equipments = new ArrayList<>();

    public void addEquipement(Equipment equipment){
        equipments.add(equipment);
    }

    public List<Equipment> getEquipment() {
        return equipments;
    }
}
