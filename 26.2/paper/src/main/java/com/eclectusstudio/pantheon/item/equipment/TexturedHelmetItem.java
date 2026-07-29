package com.eclectusstudio.pantheon.item.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedArmorItem;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class TexturedHelmetItem extends TexturedArmorItem {
    public TexturedHelmetItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment, double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, EquipmentSlot.HEAD, armor, armorToughness);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }

    public TexturedHelmetItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, EquipmentSlot.HEAD, armor, armorToughness);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }
}
