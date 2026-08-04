package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.common.resource.equipment.Equipment;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.EquipmentSlotGroup;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TexturedArmorItem extends TexturedEquipmentItem{
    private final double armor;
    private final double armorToughness;
    private final Integer enchantability;

    public TexturedArmorItem(ResourceLocation id, ItemStack itemStack, Integer maxDamage, ItemStack repairIngredient, Equipment equipment, EquipmentSlot slot, double armor, double armorToughness, Integer enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipment, slot);
        this.armor = armor;
        this.armorToughness = armorToughness;
        this.enchantability = enchantability;
    }

    public TexturedArmorItem(ResourceLocation id, ItemStack itemStack, Integer maxDamage, ItemStack repairIngredient, ResourceLocation equipmentResourceLocation, EquipmentSlot slot, double armor, double armorToughness, Integer enchantability) {
        super(id, itemStack, maxDamage, repairIngredient, equipmentResourceLocation, slot);
        this.armor = armor;
        this.armorToughness = armorToughness;
        this.enchantability = enchantability;
    }

    public double getArmor() {
        return armor;
    }

    public double getArmorToughness() {
        return armorToughness;
    }

    @Override
    public ItemStack createStack(){
        ItemStack itemStack = super.getItemStack().clone();
        ItemMeta meta = itemStack.getItemMeta();

        if (meta != null) {
            NamespacedKey armorKey = new NamespacedKey(getId().getNamespace(), "armor");
            NamespacedKey armorToughnessKey = new NamespacedKey(getId().getNamespace(), "armor_toughness");

            AttributeModifier.Operation operation = AttributeModifier.Operation.ADD_NUMBER;

            EquipmentSlotGroup slotGroup = EquipmentSlotGroup.ARMOR;

            AttributeModifier armorModifier = new AttributeModifier(armorKey, armor, operation, slotGroup);
            AttributeModifier armorToughnessModifier = new AttributeModifier(armorToughnessKey, armorToughness, operation, slotGroup);

            meta.addAttributeModifier(Attribute.ARMOR, armorModifier);
            meta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, armorToughnessModifier);

            if(enchantability != null) {
                meta.setEnchantable(enchantability);
            }

            itemStack.setItemMeta(meta);
        }

        return itemStack;
    }
}
