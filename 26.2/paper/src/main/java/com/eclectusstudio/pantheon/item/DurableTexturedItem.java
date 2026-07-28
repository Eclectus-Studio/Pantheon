package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.datacomponent.DataComponentTypes;
import org.bukkit.inventory.ItemStack;

public class DurableTexturedItem extends TexturedItem {
    private final int maxDurability;
    private final ItemStack repairMaterial;

    protected DurableTexturedItem(ResourceLocation id, ItemStack itemStack, int maxDurability, ItemStack repairMaterial) {
        super(id, itemStack);
        this.maxDurability = maxDurability;
        this.repairMaterial = repairMaterial;
    }

    public int getMaxDurability() {
        return maxDurability;
    }

    public ItemStack getRepairMaterial() {
        return repairMaterial;
    }

    @Override
    public ItemStack createStack(){
        ItemStack item = super.createStack();

        item.setData(DataComponentTypes.MAX_STACK_SIZE, 1);

        item.setData(DataComponentTypes.MAX_DAMAGE, maxDurability);
        item.setData(DataComponentTypes.DAMAGE, 0);

        if(repairMaterial != null){
            item.isRepairableBy(repairMaterial);
        }
        return item;
    }
}
