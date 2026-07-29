package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedMiningToolItem;

import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

public class TexturedPickaxeItem extends TexturedMiningToolItem {
    public TexturedPickaxeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial, float miningSpeed) {
        super(id, itemStack, maxDurability, repairMaterial, incorrectForToolMaterial, Tag.MINEABLE_PICKAXE, miningSpeed);
    }
}
