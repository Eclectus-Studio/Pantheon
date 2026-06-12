package com.eclectusstudio.pantheon.common.resource.equipment;

public class DyeableEquipmentLayer {

    private Integer colorWhenUndyed;

    public DyeableEquipmentLayer() {
    }

    public DyeableEquipmentLayer(Integer colorWhenUndyed) {
        this.colorWhenUndyed = colorWhenUndyed;
    }

    public Integer getColorWhenUndyed() {
        return colorWhenUndyed;
    }
}