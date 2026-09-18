package com.eclectusstudio.pantheon.registry;

import com.eclectusstudio.pantheon.Pantheon;
import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.item.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRegistry {
    private static boolean locked = false;

    private static final Map<ResourceLocation, Item> ITEMS = new HashMap<>();

    public static void register(Item item) {
        if(locked){
            throw new IllegalStateException("Tried registering items after registers where locked");
        }
        ITEMS.put(item.getId(), item);
    }

    public static Item get(ResourceLocation id) {
        return ITEMS.get(id);
    }

    public static Item getItem(ItemStack stack) {

        if (!stack.hasItemMeta())
            return null;

        String id = stack.getItemMeta()
                .getPersistentDataContainer()
                .get(Pantheon.customItemKey,
                        PersistentDataType.STRING);

        if (id == null)
            return null;

        return ItemRegistry.get(ResourceLocation.fromString(id));
    }

    public static Collection<Item> getItems() {
        return List.copyOf(ITEMS.values());
    }

    public static List<ResourceLocation> getItemLocations() {
        return List.copyOf(ITEMS.keySet());
    }

    public static void lock() {
        if (locked) {
            throw new IllegalStateException(
                    "Item registry already locked"
            );
        }

        locked = true;
    }

    public static boolean isLocked() {
        return locked;
    }
}