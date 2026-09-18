package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedMiningToolItem;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class TexturedAxeItem extends TexturedMiningToolItem {
    public TexturedAxeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial, float miningSpeed) {
        super(id, itemStack, maxDurability, repairMaterial, incorrectForToolMaterial, Tag.MINEABLE_AXE ,miningSpeed);

        List<Material> AXES = List.of(
                Material.COPPER_AXE,
                Material.DIAMOND_AXE,
                Material.GOLDEN_AXE,
                Material.IRON_AXE,
                Material.NETHERITE_AXE,
                Material.STONE_AXE,
                Material.WOODEN_AXE
        );

        boolean isBaseItemAxe = false;

        for (Material material : AXES) {
            if(itemStack.getType() == material){
                isBaseItemAxe = true;
            }
        }

        if(!isBaseItemAxe) {
            new IllegalArgumentException("Base item must be a axe");
        }

    }
}
