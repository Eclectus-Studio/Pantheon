package com.eclectusstudio.pantheon.commands;

import com.eclectusstudio.pantheon.item.Item;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomItemsCommand implements BasicCommand {

    private static final int GUI_SIZE = 54;
    private static final int ITEMS_PER_PAGE = 45;
    public static final NamespacedKey ACTION_KEY = new NamespacedKey("pantheon", "gui_action");
    public static final NamespacedKey PAGE_KEY = new NamespacedKey("pantheon", "gui_page");

    @Override
    public void execute(CommandSourceStack source, String[] args) {
        if (!(source.getExecutor() instanceof Player player)) {
            source.getSender().sendMessage(Component.text("Only players can execute this command.", NamedTextColor.RED));
            return;
        }
        openGUI(player, 0);

    }

    @Override
    public @Nullable String permission() {
// Paper natively enforces this and maps op/wildcard fallbacks automatically
        return "pantheon.customitemgui";
    }

    public static void openGUI(Player player, int page) {
        List<Item> allItems = new ArrayList<>(ItemRegistry.getItems());
        int totalItems = allItems.size();
        int maxPages = (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE);
        if (maxPages == 0) maxPages = 1;
        if (page < 0) page = 0;
        if (page >= maxPages) page = maxPages - 1;

        Component title = Component.text("Custom Items (Page " + (page + 1) + "/" + maxPages + ")", NamedTextColor.DARK_GRAY);
        Inventory inv = Bukkit.createInventory(null, GUI_SIZE, title);

        int startIndex = page * ITEMS_PER_PAGE;
        int endIndex = Math.min(startIndex + ITEMS_PER_PAGE, totalItems);

        for (int i = startIndex; i < endIndex; i++) {
            Item customItem = allItems.get(i);

            ItemStack displayStack = customItem.createStack();

            if (displayStack != null) {
                inv.addItem(displayStack);
            }
        }

        ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta fillerMeta = filler.getItemMeta();
        if (fillerMeta != null) {
            fillerMeta.displayName(Component.empty());
            filler.setItemMeta(fillerMeta);
        }
        for (int i = 45; i < 54; i++) {
            inv.setItem(i, filler);
        }

        if (page > 0) {
            ItemStack prevArrow = new ItemStack(Material.ARROW);
            ItemMeta meta = prevArrow.getItemMeta();
            if (meta != null) {
                meta.displayName(Component.text("← Previous Page", NamedTextColor.GREEN));
                meta.getPersistentDataContainer().set(ACTION_KEY, PersistentDataType.STRING, "prev");
                meta.getPersistentDataContainer().set(PAGE_KEY, PersistentDataType.INTEGER, page);
                prevArrow.setItemMeta(meta);
                inv.setItem(45, prevArrow);
            }
        }

        if (page < maxPages - 1) {
            ItemStack nextArrow = new ItemStack(Material.ARROW);
            ItemMeta meta = nextArrow.getItemMeta();
            if (meta != null) {
                meta.displayName(Component.text("Next Page →", NamedTextColor.GREEN));
                meta.getPersistentDataContainer().set(ACTION_KEY, PersistentDataType.STRING, "next");
                meta.getPersistentDataContainer().set(PAGE_KEY, PersistentDataType.INTEGER, page);
                nextArrow.setItemMeta(meta);
                inv.setItem(53, nextArrow);
            }
        }

        player.openInventory(inv);

    }

}