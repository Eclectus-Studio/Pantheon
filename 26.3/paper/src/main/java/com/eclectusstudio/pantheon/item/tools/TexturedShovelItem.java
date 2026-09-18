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

import java.util.List;
import java.util.Map;

public class TexturedShovelItem extends TexturedMiningToolItem {
    public TexturedShovelItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial, float miningSpeed) {
        List<Material> SHOVELS = List.of(
                Material.COPPER_SHOVEL,
                Material.DIAMOND_SHOVEL,
                Material.GOLDEN_SHOVEL,
                Material.IRON_SHOVEL,
                Material.NETHERITE_SHOVEL,
                Material.STONE_SHOVEL,
                Material.WOODEN_SHOVEL
        );

        boolean isBaseItemShovel = false;

        for (Material material : SHOVELS) {
            if(itemStack.getType() == material){
                isBaseItemShovel = true;
            }
        }

        if(!isBaseItemShovel) {
            new IllegalArgumentException("Base item must be a shovel");
        }

        super(id, itemStack, maxDurability, repairMaterial, incorrectForToolMaterial, Tag.MINEABLE_SHOVEL, miningSpeed);
    }
}