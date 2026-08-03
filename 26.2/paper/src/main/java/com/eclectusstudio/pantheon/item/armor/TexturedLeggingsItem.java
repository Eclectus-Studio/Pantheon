package com.eclectusstudio.pantheon.item.armor;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedArmorItem;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class TexturedLeggingsItem extends TexturedArmorItem {

    public TexturedLeggingsItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment, double armor, double armorToughness, int enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, EquipmentSlot.LEGS, armor, armorToughness, enchantability);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }

    public TexturedLeggingsItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, double armor, double armorToughness, int enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, EquipmentSlot.LEGS, armor, armorToughness, enchantability);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }
}
