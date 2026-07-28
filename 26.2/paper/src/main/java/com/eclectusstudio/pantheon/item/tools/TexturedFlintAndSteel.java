package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.DurableTexturedItem;
import org.bukkit.inventory.ItemStack;

public class TexturedFlintAndSteel extends DurableTexturedItem {
    protected TexturedFlintAndSteel(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial) {
        super(id, itemStack, maxDurability, repairMaterial);
    }
}
