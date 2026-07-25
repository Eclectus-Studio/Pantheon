package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.datacomponent.DataComponentTypes;
import org.bukkit.inventory.ItemStack;

public class DurableTexturedItem extends TexturedItem {
    private final int maxDurability;

    protected DurableTexturedItem(ResourceLocation id, ItemStack itemStack, int maxDurability) {
        super(id, itemStack);
        this.maxDurability = maxDurability;
    }

    /**
     * Gets the remaining durability left on the item.
     */
    public int getRemainingDurability(ItemStack item) {
        Integer maxDamage = item.getData(DataComponentTypes.MAX_DAMAGE);
        Integer currentDamage = item.getData(DataComponentTypes.DAMAGE);

        // If it doesn't have a max damage component, treat it as infinite/indestructible
        if (maxDamage == null) {
            return -1;
        }

        int damage = (currentDamage != null) ? currentDamage : 0;

        return maxDamage - damage;
    }

    /**
     * Repairs the item by increasing its remaining durability.
     */
    public void addDurability(ItemStack itemStack, int amount) {
        removeDamage(itemStack, amount);
    }

    /**
     * Damages the item by decreasing its remaining durability.
     */
    public void removeDurability(ItemStack itemStack, int amount) {
        addDamage(itemStack, amount);
    }

    /**
     * Direct helper to apply damage points (reduces durability).
     */
    private void addDamage(ItemStack itemStack, int damageAmount) {
        Integer currentDamage = itemStack.getData(DataComponentTypes.DAMAGE);
        int damage = (currentDamage != null) ? currentDamage : 0;

        // Cap damage to max durability so it doesn't overflow
        int newDamage = Math.min(this.maxDurability, damage + damageAmount);
        itemStack.setData(DataComponentTypes.DAMAGE, newDamage);

        if (newDamage >= this.maxDurability) {
            int itemStackAmount = itemStack.getAmount();
            int newItemStackAmount = itemStackAmount - 1;

            itemStack.setAmount(newItemStackAmount);
        }
    }

    /**
     * Direct helper to remove damage points (restores durability).
     */
    private void removeDamage(ItemStack itemStack, int repairAmount) {
        Integer currentDamage = itemStack.getData(DataComponentTypes.DAMAGE);
        int damage = (currentDamage != null) ? currentDamage : 0;

        int newDamage = Math.max(0, damage - repairAmount);
        itemStack.setData(DataComponentTypes.DAMAGE, newDamage);
    }

    @Override
    public ItemStack createStack(){
        ItemStack item = super.createStack();

        item.setData(DataComponentTypes.MAX_DAMAGE, maxDurability);
        item.setData(DataComponentTypes.DAMAGE, 0);

        return item;
    }
}
