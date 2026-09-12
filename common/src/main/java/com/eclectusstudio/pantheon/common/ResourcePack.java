package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.resource.fonts.Font;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipments;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;
import com.eclectusstudio.pantheon.common.resource.language.Language;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundsFile;
import com.eclectusstudio.pantheon.common.resource.waypointstyle.WaypointStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ResourcePack {

    private final PackMCMeta metadata;

    private final ResourcePackItems items;
    private final Map<ResourceLocation, ItemModelDefinition> models;
    private final Equipments equipments;

    private final Map<ResourceLocation, Font> fonts;

    private SoundsFile soundsFile;

    private final List<WaypointStyle> waypointStyles;

    private final Map<Language, ResourceLocation> languages;

    public ResourcePack(PackMCMeta meta) {

        this.metadata = meta;

        this.equipments = new Equipments();
        this.items = new ResourcePackItems();
        this.models = new HashMap<>();

        this.fonts = new HashMap<>();
        waypointStyles = new ArrayList<>();
        languages = new HashMap<>();
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


    public ResourcePack addFont(
            ResourceLocation id,
            Font font
    ) {

        fonts.put(
                id,
                font
        );

        return this;
    }

    public ResourcePack addWaypointStyle(WaypointStyle style){
        waypointStyles.add(style);

        return this;
    }

    public ResourcePack addLanguage(Language language, ResourceLocation location){
        languages.put(language, location);

        return this;
    }

    public void setSoundsFile(SoundsFile soundsFile) {
        this.soundsFile = soundsFile;
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

    public Map<ResourceLocation, Font> getFonts() {
        return fonts;
    }

    public SoundsFile getSoundsFile() {
        return soundsFile;
    }

    public List<WaypointStyle> getWaypointStyles() {
        return waypointStyles;
    }

    public Map<Language, ResourceLocation> getLanguages() {
        return languages;
    }
}