package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedMiningToolItem;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class TexturedPickaxeItem extends TexturedMiningToolItem {
    public TexturedPickaxeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial, float miningSpeed) {
        List<Material> PICKAXES = List.of(
                Material.COPPER_PICKAXE,
                Material.DIAMOND_PICKAXE,
                Material.GOLDEN_PICKAXE,
                Material.IRON_PICKAXE,
                Material.NETHERITE_PICKAXE,
                Material.STONE_PICKAXE,
                Material.WOODEN_PICKAXE
        );

        boolean isBaseItemPickaxe = false;

        for (Material material : PICKAXES) {
            if(itemStack.getType() == material){
                isBaseItemPickaxe = true;
            }
        }

        if(!isBaseItemPickaxe) {
            new IllegalArgumentException("Base item must be a pickaxe");
        }

        super(id, itemStack, maxDurability, repairMaterial, incorrectForToolMaterial, Tag.MINEABLE_PICKAXE, miningSpeed);
    }
}
