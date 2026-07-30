package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.DurableTexturedItem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class TexturedHoeItem extends DurableTexturedItem {

    public TexturedHoeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial) {
        super(id, itemStack, maxDurability, repairMaterial);
    }

    @Override
    public void onRightClick(Player player, PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) {
            return;
        }

        if (event.getClickedBlock() == null) {
            return;
        }

        Block block = event.getClickedBlock();

        // Can't till if something solid is above.
        if (!block.getRelative(0, 1, 0).isEmpty()) {
            return;
        }

        Material tilled = TILLABLES.get(block.getType());

        if (tilled == null) {
            return;
        }

        block.setType(tilled);

        block.getWorld().playSound(
                block.getLocation(),
                Sound.ITEM_HOE_TILL,
                1.0f,
                1.0f
        );

        damageItem(player, event.getItem(), 1);

        event.setCancelled(true);
    }

    private static final Map<Material, Material> TILLABLES = Map.of(
            Material.GRASS_BLOCK, Material.FARMLAND,
            Material.DIRT, Material.FARMLAND,
            Material.DIRT_PATH, Material.FARMLAND,
            Material.COARSE_DIRT, Material.DIRT
    );
}