package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.DurableTexturedItem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TexturedFlintAndSteel extends DurableTexturedItem {
    public TexturedFlintAndSteel(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial) {
        if(Material.FLINT_AND_STEEL != itemStack.getType()) {
            throw new IllegalArgumentException("Base item must be flint and steel");
        }

        super(id, itemStack, maxDurability, repairMaterial);
    }
}
