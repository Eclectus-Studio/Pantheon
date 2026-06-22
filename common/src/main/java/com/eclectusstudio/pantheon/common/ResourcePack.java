package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipments;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;

import java.util.HashMap;
import java.util.Map;

public final class ResourcePack {

    private final PackMCMeta metadata;
    private final ResourcePackItems items;
    private final Map<ResourceLocation, ItemModelDefinition> models;
    private final Equipments equipments;

    public ResourcePack(PackMCMeta meta, Equipments equipments) {
        this.metadata=meta;
        this.equipments = equipments;
        this.items = new ResourcePackItems();
        this.models = new HashMap<>();
    }

    /*
     * Assets
     */

    public ResourcePack addItem(
            ResourceLocation id,
            ItemModels itemModels
    ) {

        items.register(
                id,
                itemModels
        );

        return this;
    }

    public ResourcePack addModel(
            ResourceLocation id,
            ItemModelDefinition model
    ) {

        models.put(
                id,
                model
        );

        return this;
    }

    public ResourcePack addEquipment(
            Equipment equipment
    ) {
        equipments.addEquipement(equipment);
        return this;
    }

    /*
     * Getters
     */

    public PackMCMeta getMetadata() {
        return metadata;
    }

    public ResourcePackItems getItems() {
        return items;
    }

    public Map<ResourceLocation, ItemModelDefinition> getModels() {
        return models;
    }

    public Equipments getEquipments() {
        return equipments;
    }
}