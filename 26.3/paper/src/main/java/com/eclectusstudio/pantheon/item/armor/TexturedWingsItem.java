package com.eclectusstudio.pantheon.item.armor;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedArmorItem;

import io.papermc.paper.datacomponent.DataComponentTypes;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TexturedWingsItem extends TexturedArmorItem {
    public TexturedWingsItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment, double armor, double armorToughness, int enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, EquipmentSlot.CHEST, armor, armorToughness, enchantability);

        // Default Wing Settings
        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }

    public TexturedWingsItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, double armor, double armorToughness, int enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, EquipmentSlot.CHEST, armor, armorToughness, enchantability);

        // Default Wing Settings
        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }

    @Override
    public ItemStack createStack() {
        ItemStack stack = super.createStack();
        ItemMeta meta = stack.getItemMeta();

        stack.setData(DataComponentTypes.GLIDER);

        return stack;
    }
}