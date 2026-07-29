package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.ToolComponent;

public class TexturedMiningToolItem extends DurableTexturedItem {
    private final Tag<Material> incorrectForToolMaterial;
    private final Tag<Material> minableByTool;

    private final float miningSpeed;

    public TexturedMiningToolItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial, Tag<Material> incorrectForToolMaterial, Tag<Material> minableByTool, float miningSpeed) {
        super(id, itemStack, maxDurability, repairMaterial);
        this.incorrectForToolMaterial = incorrectForToolMaterial;
        this.minableByTool = minableByTool;
        this.miningSpeed = miningSpeed;
    }

    public Tag<Material> getIncorrectForToolMaterial() {
        return incorrectForToolMaterial;
    }

    public Tag<Material> getMinableByTool() {
        return minableByTool;
    }

    public float getMiningSpeed() {
        return miningSpeed;
    }

    @Override
    public ItemStack createStack(){
        ItemStack itemStack = super.createStack().clone();
        ItemMeta meta = itemStack.getItemMeta();

        if(meta != null) {
            ToolComponent toolComponent = meta.getTool();

            toolComponent.addRule(minableByTool, miningSpeed, true);
            toolComponent.addRule(incorrectForToolMaterial, null, false);

            meta.setTool(toolComponent);

            itemStack.setItemMeta(meta);
        }

        return itemStack;
    }
}
