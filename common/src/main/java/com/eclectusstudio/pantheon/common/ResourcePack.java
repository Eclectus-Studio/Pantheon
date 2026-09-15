package com.eclectusstudio.pantheon.common;

import com.eclectusstudio.pantheon.common.resource.atlas.Atlas;
import com.eclectusstudio.pantheon.common.resource.blockstate.BlockStateDefinition;
import com.eclectusstudio.pantheon.common.resource.fonts.Font;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipments;
import com.eclectusstudio.pantheon.common.resource.items.ItemModels;
import com.eclectusstudio.pantheon.common.resource.items.ResourcePackItems;
import com.eclectusstudio.pantheon.common.resource.language.Language;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;
import com.eclectusstudio.pantheon.common.resource.regioncompliance.RegionComplianceWarning;
import com.eclectusstudio.pantheon.common.resource.sounds.SoundsFile;
import com.eclectusstudio.pantheon.common.resource.texture.TextureMeta;
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
    
    private final List<RegionComplianceWarning> regionComplianceWarnings;

    private final List<Atlas> atlases;

    private final List<TextureMeta> textureMetas;

    private final List<BlockStateDefinition> blockStateDefinitions;

    public ResourcePack(PackMCMeta meta) {

        this.metadata = meta;

        this.equipments = new Equipments();
        this.items = new ResourcePackItems();
        this.models = new HashMap<>();

        this.fonts = new HashMap<>();
        waypointStyles = new ArrayList<>();
        languages = new HashMap<>();
        regionComplianceWarnings = new ArrayList<>();
        atlases = new ArrayList<>();
        textureMetas = new ArrayList<>();
        blockStateDefinitions = new ArrayList<>();
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

    public ResourcePack addRegionComplianceWarning(RegionComplianceWarning regionComplianceWarning){
        regionComplianceWarnings.add(regionComplianceWarning);

        return this;
    }

    public ResourcePack addAtlas(Atlas atlas) {
        atlases.add(atlas);

        return this;
    }

    public ResourcePack addTextureMeta(TextureMeta textureMeta){
        textureMetas.add(textureMeta);

        return this;
    }

    public ResourcePack addBlockStateDefinition(BlockStateDefinition blockStateDefinition){
        blockStateDefinitions.add(blockStateDefinition);

        return this;
    }

    public ResourcePack setSoundsFile(SoundsFile soundsFile) {
        this.soundsFile = soundsFile;

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

    public List<RegionComplianceWarning> getRegionComplianceWarnings() {
        return regionComplianceWarnings;
    }

    public List<Atlas> getAtlases() {
        return atlases;
    }

    public List<TextureMeta> getTextureMetas() {
        return textureMetas;
    }

    public List<BlockStateDefinition> getBlockStateDefinitions() {
        return blockStateDefinitions;
    }
}