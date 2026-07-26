package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;

public abstract class TexturedWeaponItem extends DurableTexturedItem {

    private final double attackDamage;
    private final double attackSpeed;

    protected TexturedWeaponItem(
            ResourceLocation id,
            ItemStack itemStack,
            int maxDurability,
            ItemStack repairMaterial,
            double attackDamage,
            double attackSpeed
    ) {
        super(id, itemStack, maxDurability, repairMaterial);

        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    public double getAttackDamage() {
        return attackDamage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public ItemStack createStack(){
        ItemStack itemStack = super.createStack().clone();
        ItemMeta itemMeta = itemStack.getItemMeta();

        double damageToBeApplied = attackDamage - getDefaultDamage(itemStack.getType());
        double attackSpeedToBeApplied = attackSpeed - getDefaultAttackSpeed(itemStack.getType());

        //TODO attributes here

        return itemStack;
    }

    public double getDefaultAttackSpeed(Material material) {
        Collection<AttributeModifier> modifiers = material.getDefaultAttributeModifiers(EquipmentSlot.HAND)
                .get(Attribute.ATTACK_SPEED);

        double attackSpeed = 4.0; // Base player attack speed

        if (modifiers == null || modifiers.isEmpty()) {
            return attackSpeed;
        }

        // Sum up the modifiers (vanilla tools will have negative numbers here)
        for (AttributeModifier modifier : modifiers) {
            if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
                attackSpeed += modifier.getAmount();
            }
        }

        return attackSpeed;
    }

    private double getDefaultDamage(Material material) {
        // 1. Fetch default modifiers for the item type
        Collection<AttributeModifier> modifiers = material.getDefaultAttributeModifiers(EquipmentSlot.HAND)
                .get(Attribute.ATTACK_DAMAGE);

        if (modifiers == null || modifiers.isEmpty()) {
            return 1.0; // Default base damage for an empty hand/generic block
        }

        // 2. Sum up the default values (usually just one modifier exists)
        double damage = 1.0; // Base entity attack damage starts at 1.0
        for (AttributeModifier modifier : modifiers) {
            if (modifier.getOperation() == AttributeModifier.Operation.ADD_NUMBER) {
                damage += modifier.getAmount();
            }
        }

        return damage;
    }
}