package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.key.Key;
import org.bukkit.Registry;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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

    public boolean damageItem(Player player, ItemStack stack, int amount) {
        if (!stack.hasData(DataComponentTypes.MAX_DAMAGE)) {
            return false;
        }

        int damage = stack.getData(DataComponentTypes.DAMAGE);
        int maxDamage = stack.getData(DataComponentTypes.MAX_DAMAGE);

        damage += amount;

        if (damage >= maxDamage) {
            Key breakSound = stack.hasData(DataComponentTypes.BREAK_SOUND)
                    ? stack.getData(DataComponentTypes.BREAK_SOUND)
                    : Registry.SOUNDS.getKey(Sound.ENTITY_ITEM_BREAK);

            player.getWorld().playSound(
                    player.getLocation(),
                    Registry.SOUNDS.get(breakSound),
                    SoundCategory.PLAYERS,
                    1.0f,
                    1.0f
            );

            stack.setAmount(0);
            return true;
        }

        stack.setData(DataComponentTypes.DAMAGE, damage);
        return false;
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
