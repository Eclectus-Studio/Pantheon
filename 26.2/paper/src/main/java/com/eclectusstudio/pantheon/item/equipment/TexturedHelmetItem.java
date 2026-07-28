package com.eclectusstudio.pantheon.item.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedEquipmentItem;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class TexturedHelmetItem extends TexturedEquipmentItem {
    public TexturedHelmetItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment, EquipmentSlot slot) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, slot);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }

    public TexturedHelmetItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, EquipmentSlot slot) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, slot);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }
}
