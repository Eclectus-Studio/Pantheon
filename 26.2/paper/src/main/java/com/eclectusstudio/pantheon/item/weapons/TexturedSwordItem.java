package com.eclectusstudio.pantheon.item.weapons;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedWeaponItem;
import org.bukkit.inventory.ItemStack;

public class TexturedSwordItem extends TexturedWeaponItem {
    protected TexturedSwordItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, double attackDamage, double attackSpeed) {
        super(id, itemStack, maxDurability, repairMaterial, attackDamage, attackSpeed);
    }
}
