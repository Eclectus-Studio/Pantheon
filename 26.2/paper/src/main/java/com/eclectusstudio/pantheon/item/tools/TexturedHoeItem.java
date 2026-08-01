package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.DurableTexturedItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class TexturedHoeItem extends DurableTexturedItem {
    public TexturedHoeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial) {
        List<Material> HOES = List.of(
                Material.COPPER_HOE,
                Material.DIAMOND_HOE,
                Material.GOLDEN_HOE,
                Material.IRON_HOE,
                Material.NETHERITE_HOE,
                Material.STONE_HOE,
                Material.WOODEN_HOE
        );

        boolean isBaseItemHoe = false;

        for (Material material : HOES) {
            if(itemStack.getType() == material){
                isBaseItemHoe = true;
            }
        }

        if(!isBaseItemHoe) {
            new IllegalArgumentException("Base item must be a hoe");
        }
        
        super(id, itemStack, maxDurability, repairMaterial);
    }
}