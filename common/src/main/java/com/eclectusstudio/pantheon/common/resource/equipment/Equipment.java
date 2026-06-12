package com.eclectusstudio.pantheon.common.resource.equipment;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Equipment {

    private final Map<EquipmentLayerType, List<EquipmentLayer>> layers =
            new EnumMap<>(EquipmentLayerType.class);

    public Equipment() {
    }

    public Equipment addLayer(
            EquipmentLayerType type,
            EquipmentLayer layer
    ) {
        layers.computeIfAbsent(type, t -> new ArrayList<>())
                .add(layer);

        return this;
    }

    public Map<EquipmentLayerType, List<EquipmentLayer>> getLayers() {
        return layers;
    }
}