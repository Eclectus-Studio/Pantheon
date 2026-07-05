package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.item.Item;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        ItemStack stack = event.getItem();

        if (stack == null)
            return;

        Item customItem = ItemRegistry.getItem(stack);

        if (customItem == null)
            return;

        Action action = event.getAction();

        if (action == Action.RIGHT_CLICK_AIR
                || action == Action.RIGHT_CLICK_BLOCK) {

            customItem.onRightClick(
                    event.getPlayer(),
                    event
            );
        }

        if (action == Action.LEFT_CLICK_AIR
                || action == Action.LEFT_CLICK_BLOCK) {

            customItem.onLeftClick(
                    event.getPlayer(),
                    event
            );
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {

        ItemStack stack = event.getItemDrop().getItemStack();

        Item customItem = ItemRegistry.getItem(stack);

        if (customItem == null)
            return;

        customItem.onDrop(event);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        ItemStack stack = event.getCurrentItem();

        if (stack == null)
            return;

        Item customItem = ItemRegistry.getItem(stack);

        if (customItem == null)
            return;

        customItem.onInventoryClick(event);
    }
}