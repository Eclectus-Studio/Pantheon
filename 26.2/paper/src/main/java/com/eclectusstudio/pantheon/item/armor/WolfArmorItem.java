package com.eclectusstudio.pantheon.item.armor;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedArmorItem;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class WolfArmorItem extends TexturedArmorItem {
    public WolfArmorItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment, EquipmentSlot slot, double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, slot, armor, armorToughness);
        this.setAllowedEntity(EntityType.WOLF);
    }

    public WolfArmorItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, EquipmentSlot slot, double armor, double armorToughness) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, slot, armor, armorToughness);
        this.setAllowedEntity(EntityType.WOLF);
    }
}
