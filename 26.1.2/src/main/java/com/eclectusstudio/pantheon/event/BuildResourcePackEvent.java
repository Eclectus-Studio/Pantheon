package com.eclectusstudio.pantheon.event;

import com.eclectusstudio.pantheon.common.ResourcePack;
import com.eclectusstudio.pantheon.common.ResourcePacks;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BuildResourcePackEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    public void buildResourcePack(ResourcePack pack){
        ResourcePacks.addPack(pack);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
