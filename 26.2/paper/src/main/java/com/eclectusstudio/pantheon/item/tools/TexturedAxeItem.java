package com.eclectusstudio.pantheon.item.tools;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.TexturedMiningToolItem;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class TexturedAxeItem extends TexturedMiningToolItem {
    public TexturedAxeItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial, float miningSpeed) {
        super(id, itemStack, maxDurability, repairMaterial, incorrectForToolMaterial, Tag.MINEABLE_AXE ,miningSpeed);
    }

    @Override
    public void onRightClick(Player player, PlayerInteractEvent event) {
        if (holdingAnAxe(player, event.getItem())) {
            return; // Vanilla handles it
        }

        if (event.getClickedBlock() == null) {
            return;
        }

        Block block = event.getClickedBlock();
        Material stripped = getStrippedVariant(block.getType());

        if (stripped == null) {
            return;
        }

        block.setType(stripped);

        block.getWorld().playSound(
                block.getLocation(),
                Sound.ITEM_AXE_STRIP,
                1.0f,
                1.0f
        );

        damageItem(player, event.getItem(), 1);

        event.setCancelled(true);
    }

    private boolean holdingAnAxe(Player player, ItemStack stack){
        return (stack != null && stack.getType().name().endsWith("_AXE"));
    }

    private static final Map<Material, Material> STRIPPABLES = Map.ofEntries(
            Map.entry(Material.OAK_LOG, Material.STRIPPED_OAK_LOG),
            Map.entry(Material.SPRUCE_LOG, Material.STRIPPED_SPRUCE_LOG),
            Map.entry(Material.BIRCH_LOG, Material.STRIPPED_BIRCH_LOG),
            Map.entry(Material.JUNGLE_LOG, Material.STRIPPED_JUNGLE_LOG),
            Map.entry(Material.ACACIA_LOG, Material.STRIPPED_ACACIA_LOG),
            Map.entry(Material.DARK_OAK_LOG, Material.STRIPPED_DARK_OAK_LOG),
            Map.entry(Material.MANGROVE_LOG, Material.STRIPPED_MANGROVE_LOG),
            Map.entry(Material.CHERRY_LOG, Material.STRIPPED_CHERRY_LOG),
            Map.entry(Material.PALE_OAK_LOG, Material.STRIPPED_PALE_OAK_LOG),

            Map.entry(Material.OAK_WOOD, Material.STRIPPED_OAK_WOOD),
            Map.entry(Material.SPRUCE_WOOD, Material.STRIPPED_SPRUCE_WOOD),
            Map.entry(Material.BIRCH_WOOD, Material.STRIPPED_BIRCH_WOOD),
            Map.entry(Material.JUNGLE_WOOD, Material.STRIPPED_JUNGLE_WOOD),
            Map.entry(Material.ACACIA_WOOD, Material.STRIPPED_ACACIA_WOOD),
            Map.entry(Material.DARK_OAK_WOOD, Material.STRIPPED_DARK_OAK_WOOD),
            Map.entry(Material.MANGROVE_WOOD, Material.STRIPPED_MANGROVE_WOOD),
            Map.entry(Material.CHERRY_WOOD, Material.STRIPPED_CHERRY_WOOD),
            Map.entry(Material.PALE_OAK_WOOD, Material.STRIPPED_PALE_OAK_WOOD),

            Map.entry(Material.CRIMSON_STEM, Material.STRIPPED_CRIMSON_STEM),
            Map.entry(Material.WARPED_STEM, Material.STRIPPED_WARPED_STEM),
            Map.entry(Material.CRIMSON_HYPHAE, Material.STRIPPED_CRIMSON_HYPHAE),
            Map.entry(Material.WARPED_HYPHAE, Material.STRIPPED_WARPED_HYPHAE),
            Map.entry(Material.BAMBOO_BLOCK, Material.STRIPPED_BAMBOO_BLOCK)
    );

    private Material getStrippedVariant(Material material) {
        return STRIPPABLES.get(material);
    }
}
