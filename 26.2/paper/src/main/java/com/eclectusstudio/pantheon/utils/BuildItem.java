package com.eclectusstudio.pantheon.utils;

import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.item.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class BuildItem {
    public static ItemStack buildItem(Item item) {
        ItemStack stack = item.getItemStack().clone();

        ItemMeta meta = stack.getItemMeta();

        meta.getPersistentDataContainer().set(
                Pantheon.customItemKey,
                PersistentDataType.STRING,
                item.getId().toString()
        );

        stack.setItemMeta(meta);

        return stack;
    }
}
