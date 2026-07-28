package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.DurableTexturedItem;
import org.bukkit.inventory.ItemStack;

public class TexturedAxeItem extends DurableTexturedItem {
    protected TexturedAxeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial) {
        super(id, itemStack, maxDurability, repairMaterial);
    }
}
