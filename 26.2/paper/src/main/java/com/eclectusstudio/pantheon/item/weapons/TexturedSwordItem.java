package com.eclectusstudio.pantheon.item.weapons;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedWeaponItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class TexturedSwordItem extends TexturedWeaponItem {
    protected TexturedSwordItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, double attackDamage, double attackSpeed) {
        List<Material> SWORDS = List.of(
                Material.COPPER_SWORD,
                Material.DIAMOND_SWORD,
                Material.GOLDEN_SWORD,
                Material.IRON_SWORD,
                Material.NETHERITE_SWORD,
                Material.STONE_SWORD,
                Material.WOODEN_SWORD
        );

        boolean isBaseItemSword= false;

        for (Material material : SWORDS) {
            if(itemStack.getType() == material){
                isBaseItemSword = true;
            }
        }

        if(!isBaseItemSword) {
            new IllegalArgumentException("Base item must be a sword");
        }

        super(id, itemStack, maxDurability, repairMaterial, attackDamage, attackSpeed);
    }
}
