package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourceLocation;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public abstract class TexturedItem extends Item{
    public TexturedItem(ResourceLocation id, ItemStack itemStack) {
        super(id, itemStack);
    }

    @Override
    public ItemStack createStack(){
        ItemStack stack = super.createStack().clone();

        ItemMeta meta = stack.getItemMeta();

        meta.setItemModel(toKey(getId()));

        stack.setItemMeta(meta);

        return stack;
    }
}
