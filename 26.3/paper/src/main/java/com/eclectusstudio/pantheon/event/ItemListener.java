package com.eclectusstudio.pantheon.event;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import com.eclectusstudio.pantheon.item.Item;
import com.eclectusstudio.pantheon.item.TexturedEquipmentItem;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import io.papermc.paper.event.entity.EntityEquipmentChangedEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

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

    @EventHandler
    public void onEquip(EntityEquipmentChangedEvent e) {
        for (Map.Entry<EquipmentSlot, EntityEquipmentChangedEvent.EquipmentChange> entry : e.getEquipmentChanges().entrySet()) {
            EquipmentSlot slot = entry.getKey();
            EntityEquipmentChangedEvent.EquipmentChange change = entry.getValue();

            ItemStack stack = change.newItem();

            if (stack == null || stack.getType().isAir()) {
                continue;
            }

            Item customItem = ItemRegistry.getItem(stack);
            if (customItem == null) {
                continue;
            }

            if (customItem instanceof TexturedEquipmentItem texturedItem) {

                texturedItem.onEquip(e.getEntity());
            }
        }
    }
}