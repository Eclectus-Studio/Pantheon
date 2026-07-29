package com.eclectusstudio.pantheon.item.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedEquipmentItem;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class TexturedSaddle extends TexturedEquipmentItem {
    public TexturedSaddle(ResourceLocation id, ItemStack itemStack, Equipment equipment) {
        super(id, itemStack, 0, null, equipment, EquipmentSlot.SADDLE);
    }

    public TexturedSaddle(ResourceLocation id, ItemStack itemStack, ResourceLocation equipmentResourceLocation) {
        super(id, itemStack, 0, null, equipmentResourceLocation, EquipmentSlot.SADDLE);
    }
}
