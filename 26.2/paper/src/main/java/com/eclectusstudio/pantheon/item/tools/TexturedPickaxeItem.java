package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.DurableTexturedItem;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;

public class TexturedPickaxeItem extends DurableTexturedItem {
    private final Tag<Material> incorrectForToolMaterial;

    public TexturedPickaxeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial) {
        super(id, itemStack, maxDurability, repairMaterial);
        this.incorrectForToolMaterial = incorrectForToolMaterial;
    }

    public Tag<Material> getIncorrectForToolMaterial() {
        return incorrectForToolMaterial;
    }
}
