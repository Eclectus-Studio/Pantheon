package com.eclectusstudio.pantheon.common.resource.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Equipment {
    private final ResourceLocation location;

    private final Map<EquipmentLayerType, List<EquipmentLayer>> layers =
            new EnumMap<>(EquipmentLayerType.class);

    public Equipment(ResourceLocation location) {
        this.location = location;
    }

    public Equipment addLayer(
            EquipmentLayerType type,
            EquipmentLayer layer
    ) {
        layers.computeIfAbsent(type, t -> new ArrayList<>())
                .add(layer);

        return this;
    }

    public Equipment addSimpleLayer(
            EquipmentLayerType type,
            ResourceLocation location
    ) {
        layers.computeIfAbsent(type, t -> new ArrayList<>())
                .add(new EquipmentLayer(location));

        return this;
    }

    public Map<EquipmentLayerType, List<EquipmentLayer>> getLayers() {
        return layers;
    }

    public ResourceLocation getLocation() {
        return location;
    }
}