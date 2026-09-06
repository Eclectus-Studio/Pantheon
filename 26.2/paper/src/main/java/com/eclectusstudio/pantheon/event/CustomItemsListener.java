package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.commands.CustomItemsCommand;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class CustomItemsListener implements Listener {@EventHandler
public void onInventoryClick(InventoryClickEvent event) {
    Component titleComponent = event.getView().title();// Convert the Adventure Component directly to a plain String safely
    String plainTitle = PlainTextComponentSerializer.plainText().serialize(titleComponent);

    if (!plainTitle.startsWith("Custom Items")) {
        return;
    }

// Cancel moving items inside or messing up the upper inventory grid
    event.setCancelled(true);

    ItemStack clickedItem = event.getCurrentItem();
    if (clickedItem == null || clickedItem.getType() == Material.AIR) {
        return;
    }

    Player player = (Player) event.getWhoClicked();
    ItemMeta meta = clickedItem.getItemMeta();

    if (meta == null) return;

// Process bottom row navigation data components
    if (meta.getPersistentDataContainer().has(CustomItemsCommand.ACTION_KEY, PersistentDataType.STRING)) {
        String action = meta.getPersistentDataContainer().get(CustomItemsCommand.ACTION_KEY, PersistentDataType.STRING);
        Integer currentPage = meta.getPersistentDataContainer().get(CustomItemsCommand.PAGE_KEY, PersistentDataType.INTEGER);

        if (action == null || currentPage == null) return;

        if (action.equals("prev")) {
            CustomItemsCommand.openGUI(player, currentPage - 1);
        } else if (action.equals("next")) {
            CustomItemsCommand.openGUI(player, currentPage + 1);
        }
        return;
    }

// Ignore utility filler panes
    if (clickedItem.getType() == Material.GRAY_STAINED_GLASS_PANE) {
        return;
    }

// Give item feature: Left-clicking an actual item clones a copy directly to the player's inventory
    if (event.getRawSlot() < 45) {
        ItemStack itemToGive = clickedItem.clone();
        itemToGive.setAmount(1);
        player.getInventory().addItem(itemToGive);
    }
}}