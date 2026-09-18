package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.item.Item;
import com.eclectusstudio.pantheon.registry.ItemRegistry;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class SubmitItemsEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public void submitItems(List<Item> items){
        for(Item item : items){
            ItemRegistry.register(item);
        }
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
