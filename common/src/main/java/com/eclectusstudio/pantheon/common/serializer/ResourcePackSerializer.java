package com.eclectusstudio.pantheon.common.serializer;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.resource.atlas.Atlas;
import com.eclectusstudio.pantheon.common.resource.blockstate.BlockStateDefinition;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.common.resource.fonts.Font;
import com.eclectusstudio.pantheon.common.resource.language.Language;
import com.eclectusstudio.pantheon.common.resource.models.ItemModelDefinition;
import com.eclectusstudio.pantheon.common.resource.regioncompliance.RegionComplianceWarning;
import com.eclectusstudio.pantheon.common.resource.texture.TextureMeta;
import com.eclectusstudio.pantheon.common.resource.waypointstyle.WaypointStyle;
import com.eclectusstudio.pantheon.common.serializer.atlas.AtlasSerializer;
import com.eclectusstudio.pantheon.common.serializer.blockstate.BlockStateSerializer;
import com.eclectusstudio.pantheon.common.serializer.equipment.EquipmentSerializer;
import com.eclectusstudio.pantheon.common.serializer.font.FontSerializer;
import com.eclectusstudio.pantheon.common.serializer.items.ItemsSerializer;
import com.eclectusstudio.pantheon.common.serializer.language.LanguageSerializer;
import com.eclectusstudio.pantheon.common.serializer.models.ModelSerializer;
import com.eclectusstudio.pantheon.common.serializer.regioncompliance.RegionComplianceWarningSerializer;
import com.eclectusstudio.pantheon.common.serializer.sounds.SoundsSerializer;
import com.eclectusstudio.pantheon.common.serializer.texture.TextureMetaSerializer;
import com.eclectusstudio.pantheon.common.serializer.waypointstyle.WaypointStyleSerializer;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ResourcePackSerializer {

    public static void serialize(
            File root,
            ResourcePack pack
    ) throws IOException {

        PackMCMetaSerializer.serialize(
                root,
                pack.getMetadata()
        );

        ItemsSerializer.serialize(
                root.toPath().resolve("assets"),
                pack.getItems()
        );

        for (Map.Entry<ResourceLocation, ItemModelDefinition> entry : pack.getModels().entrySet()) {

            ModelSerializer.serialize(
                    root.toPath().resolve("assets"),
                    entry.getKey().getNamespace(),
                    entry.getKey().getPath(),
                    entry.getValue()
            );
        }

        for (Equipment equipment : pack.getEquipments().getEquipment()) {

            EquipmentSerializer.serialize(
                    root.toPath().resolve("assets"),
                    equipment.getLocation().getNamespace(),
                    equipment.getLocation().getPath(),
                    equipment
            );
        }

        for (Map.Entry<ResourceLocation, Font> entry :
                pack.getFonts().entrySet()) {

            FontSerializer.serialize(
                    root.toPath().resolve("assets"),
                    entry.getKey().getNamespace(),
                    entry.getKey().getPath(),
                    entry.getValue()
            );
        }

        SoundsSerializer.serialize(
                root.toPath().resolve("assets"),
                pack.getSoundsFile()
        );

        for (WaypointStyle waypointStyle :
                pack.getWaypointStyles()) {

            WaypointStyleSerializer.serialize(
                    root.toPath().resolve("assets"),
                    waypointStyle.getResourceLocation().getNamespace(),
                    waypointStyle.getResourceLocation().getPath(),
                    waypointStyle
            );
        }

        for (Map.Entry<Language, ResourceLocation> entry :
                pack.getLanguages().entrySet()) {

            LanguageSerializer.serialize(
                    root.toPath().resolve("assets"),
                    entry.getValue().getNamespace(),
                    entry.getKey()
            );
        }

        for (RegionComplianceWarning warning :
                pack.getRegionComplianceWarnings()) {

            RegionComplianceWarningSerializer.serialize(
                    root.toPath().resolve("assets"),
                    warning.getResourceLocation().getNamespace(),
                    pack.getRegionComplianceWarnings()
            );

            break;
        }

        for (Atlas atlas :
                pack.getAtlases()) {

            AtlasSerializer.serialize(
                    root.toPath().resolve("assets"),
                    atlas.getResourceLocation().getNamespace(),
                    atlas.getResourceLocation().getPath(),
                    atlas
            );
        }

        for (TextureMeta textureMeta :
                pack.getTextureMetas()) {

            TextureMetaSerializer.serialize(
                    root.toPath().resolve("assets"),
                    textureMeta
            );
        }

        for (BlockStateDefinition blockStateDefinition :
                pack.getBlockStateDefinitions()) {

            BlockStateSerializer.serialize(
                    root.toPath().resolve("assets"),
                    blockStateDefinition
            );
        }
    }
}