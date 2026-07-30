package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedMiningToolItem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.data.Lightable;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class TexturedShovelItem extends TexturedMiningToolItem {

    public TexturedShovelItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial, float miningSpeed) {
        super(id, itemStack, maxDurability, repairMaterial, incorrectForToolMaterial, Tag.MINEABLE_SHOVEL, miningSpeed);
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

        // Extinguish campfires.
        if (block.getBlockData() instanceof Lightable lightable && lightable.isLit()) {
            lightable.setLit(false);
            block.setBlockData(lightable);

            block.getWorld().playSound(
                    block.getLocation(),
                    Sound.BLOCK_FIRE_EXTINGUISH,
                    1.0f,
                    1.0f
            );

            damageItem(player, event.getItem(), 1);
            event.setCancelled(true);
            return;
        }

        // Can't make a path if something is above.
        if (!block.getRelative(0, 1, 0).isEmpty()) {
            return;
        }

        Material flattened = PATHABLES.get(block.getType());

        if (flattened == null) {
            return;
        }

        block.setType(flattened);

        block.getWorld().playSound(
                block.getLocation(),
                Sound.ITEM_SHOVEL_FLATTEN,
                1.0f,
                1.0f
        );

        damageItem(player, event.getItem(), 1);

        event.setCancelled(true);
    }

    private static final Map<Material, Material> PATHABLES = Map.ofEntries(
            Map.entry(Material.GRASS_BLOCK, Material.DIRT_PATH),
            Map.entry(Material.DIRT, Material.DIRT_PATH),
            Map.entry(Material.COARSE_DIRT, Material.DIRT_PATH),
            Map.entry(Material.PODZOL, Material.DIRT_PATH),
            Map.entry(Material.MYCELIUM, Material.DIRT_PATH),
            Map.entry(Material.ROOTED_DIRT, Material.DIRT_PATH)
    );
}