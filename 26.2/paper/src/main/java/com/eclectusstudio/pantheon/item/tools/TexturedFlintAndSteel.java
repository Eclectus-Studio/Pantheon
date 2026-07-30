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
    protected TexturedFlintAndSteel(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial) {
        super(id, itemStack, maxDurability, repairMaterial);
    }

    @Override
    public void onRightClick(Player player, PlayerInteractEvent event) {
        if(Material.FLINT_AND_STEEL == event.getMaterial()) {
            return;
        }

        if (event.getClickedBlock() == null || event.getBlockFace() == null) {
            return;
        }

        Block fireBlock = event.getClickedBlock().getRelative(event.getBlockFace());

        if (!fireBlock.isEmpty()) {
            return;
        }

        fireBlock.setType(Material.FIRE);

        fireBlock.getWorld().playSound(
                fireBlock.getLocation(),
                Sound.ITEM_FLINTANDSTEEL_USE,
                1.0f,
                1.0f
        );

        damageItem(player, event.getItem(), 1);

        event.setCancelled(true);
    }
}
