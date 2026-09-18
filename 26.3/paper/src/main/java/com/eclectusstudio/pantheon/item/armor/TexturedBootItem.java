package com.eclectusstudio.pantheon.item.armor;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedArmorItem;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class TexturedBootItem extends TexturedArmorItem {
    public TexturedBootItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment, double armor, double armorToughness, int enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, EquipmentSlot.FEET, armor, armorToughness, enchantability);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }

    public TexturedBootItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, double armor, double armorToughness, int enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, EquipmentSlot.FEET, armor, armorToughness, enchantability);

        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }
}
