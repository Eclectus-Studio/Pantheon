package com.eclectusstudio.pantheon.item.equipment;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import com.eclectusstudio.pantheon.item.TexturedEquipmentItem;

import io.papermc.paper.datacomponent.DataComponentTypes;

import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TexturedWingsItem extends TexturedEquipmentItem {


    public TexturedWingsItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, Equipment equipment) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, EquipmentSlot.CHEST);

        // Default Wing Settings
        this.setDamageOnHurt(true);
        this.setEquipOnInteract(true);
    }

    public TexturedWingsItem(ResourceLocation id, ItemStack itemStack, int maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, EquipmentSlot.CHEST);

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