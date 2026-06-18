package com.eclectusstudio.pantheon.item;

import com.eclectusstudio.pantheon.common.ResourceLocation;
import com.eclectusstudio.pantheon.utils.BuildItem;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public abstract class Item {
    private final ResourceLocation id;
    private final ItemStack itemStack;

    protected Item(ResourceLocation id, ItemStack itemStack) {
        this.id = id;
        this.itemStack = itemStack;
    }

    public ResourceLocation getId() {
        return id;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void onLeftClick(Player player, PlayerInteractEvent event) {}

    public void onRightClick(Player player, PlayerInteractEvent event) {}

    public void onDrop(PlayerDropItemEvent event) {}

    public void onInventoryClick(InventoryClickEvent event) {}

    public ItemStack createStack() {
        return BuildItem.buildItem(this);
    }
}