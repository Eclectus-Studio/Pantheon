package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourceLocation;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import static com.eclectusstudio.pantheon.utils.LocationToNamespaceKey.toKey;

public abstract class TexturedItem extends Item{
    protected TexturedItem(ResourceLocation id, ItemStack itemStack) {
        super(id, itemStack);
    }

    @Override
    public ItemStack createStack(){
        ItemStack stack = this.getItemStack().clone();

        ItemMeta meta = stack.getItemMeta();

        meta.setItemModel(toKey(getId()));

        meta.getPersistentDataContainer().set(
                Pantheon.customItemKey,
                PersistentDataType.STRING,
                this.getId().toString()
        );

        stack.setItemMeta(meta);

        return stack;
    }
}
